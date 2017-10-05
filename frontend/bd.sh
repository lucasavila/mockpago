#!/bin/bash

rm -rf dist/
grunt build
docker rmi docker.dev.redbee.io/mock_frontend
docker build -t docker.dev.redbee.io/mock_frontend .
docker push docker.dev.redbee.io/mock_frontend
