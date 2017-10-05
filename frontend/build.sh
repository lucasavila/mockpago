#!/bin/bash

BUILD_NUMBER=$1
VERSION_NUMBER=$2
JENKINS_JOB_BUILD="B2C-BUILD"
JENKINS_JOB_DEPLOY="B2C-DEPLOY"
NOMBRE_IMAGEN="b2c_frontend"

cd /var/jenkins_home/workspace/$JENKINS_JOB_DEPLOY/builderFrontend/frontendImage

cp -rf /var/jenkins_home/jobs/$JENKINS_JOB_BUILD/builds/$BUILD_NUMBER/archive/frontend/dist.tar.gz .
tar -zxvf dist.tar.gz

docker stop $NOMBRE_IMAGEN
docker rm $NOMBRE_IMAGEN

docker rmi "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER"
docker build -t "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER" .
docker push "docker.dev.redbee.io/$NOMBRE_IMAGEN:$VERSION_NUMBER"
