#!/usr/bin/env sh
set -eu
cd "$(dirname "$0")"
mvn -q clean package
java -jar target/bai08-1.0-SNAPSHOT.jar
