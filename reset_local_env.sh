#!/bin/bash

echo "CREATE DBATABASE test;" > ./init.sql

docker-compose stop && \
docker-compose rm -f && \
docker-compose pull && \
docker-compose up -d && \
echo Pausing 4 sec && sleep 5