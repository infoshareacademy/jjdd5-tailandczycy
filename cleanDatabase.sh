#!/bin/bash
docker rm -f mysql-tailandczycy
docker volume rm -f mysql-data
docker container run -d --name mysql-tailandczycy --env="TZ=Europe/Warsaw" --publish 6603:3306 -v mysql-data:/var/lib/mysql 11418/tailandczycy:user

