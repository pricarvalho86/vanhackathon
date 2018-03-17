#!/usr/bin/env bash
docker ps --no-trunc -aqf "status=exited" | xargs docker rm ;
docker images --no-trunc -aqf "dangling=true" | xargs docker rmi;
docker volume ls -qf "dangling=true" | xargs docker volume rm;
mvn clean install dockerfile:build
docker-compose up
