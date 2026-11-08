#!/usr/bin/env sh
set -eu
cd "$(dirname "$0")"
mvn -q verify dependency:build-classpath -Dmdep.outputFile=target/classpath.txt
separator=:
case "${OSTYPE:-}" in msys*|mingw*|cygwin*) separator=';' ;; esac
java -cp "target/classes${separator}$(cat target/classpath.txt)" Main
