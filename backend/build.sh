#!/bin/bash

VERSION_NUMBER="latest"
NOMBRE_IMAGEN="mock_backend"

gradle build
docker stop $NOMBRE_IMAGEN
docker rm $NOMBRE_IMAGEN
echo "docker rmi "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER""
docker rmi "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER"
docker build -t "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER" .
docker push "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER"
