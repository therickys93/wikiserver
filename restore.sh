#!/bin/sh

docker run --rm -v wikiserver_postgresql_database:/volume -v /tmp:/backup loomchild/volume-backup restore wikiserver_postgresql_database
docker run --rm -v wikiserver_redis_database:/volume -v /tmp:/backup loomchild/volume-backup restore wikiserver_redis_database
