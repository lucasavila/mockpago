#!/bin/sh

VERSION_NUMBER=latest
IMAGENES="mock"

cd /webapps/redbee/mockpago/deploy/

AMBIENTE_YML=""

if [ "$1" == "-help" ];then
        echo "Argumentos: <AMBIENTE_YML> (desa.yml,test.yml,preprod.yml,prod.yml...)"
        exit 0
fi

if [ "$1" == "" ];then
        echo "ERROR: no se proporciono AMBIENTE_YML (desa.yml, test.yml,preprod.yml,prod.yml...)"
        exit 0
else
        AMBIENTE_YML="$1/$1.yml"
        echo $AMBIENTE_YML
fi

echo "$AMBIENTE_YML"
echo "IMPORTANTE: Ejecutar frontend/build_docker.sh para crear una nueva imagen"
echo "IMPORTANTE: Ejecutar backend/build_docker.sh para crear una nueva imagen"

echo "Deteniendo el compose"
docker-compose -f $AMBIENTE_YML stop
echo "Eliminando el compose anterior"
docker-compose -f $AMBIENTE_YML rm -f
echo "Eliminando las imagenes anteriores"
docker rmi docker.dev.redbee.io/"$IMAGENES"_frontend:$VERSION_NUMBER
docker rmi docker.dev.redbee.io/"$IMAGENES"_backend:$VERSION_NUMBER
echo "Levantando el compose"
docker-compose -f $AMBIENTE_YML scale "$IMAGENES"_backend=1 "$IMAGENES"_frontend=1

echo "Listo!"

