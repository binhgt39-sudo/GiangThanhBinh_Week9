#!/usr/bin/env sh
set -eu

cd "$(dirname "$0")"
mvn -q package dependency:build-classpath -Dmdep.outputFile=target/classpath.txt

classpath_separator=:
case "${OSTYPE:-}" in
  msys*|mingw*|cygwin*) classpath_separator=';' ;;
esac
classpath="target/classes${classpath_separator}$(cat target/classpath.txt)"
java -cp "$classpath" Main
