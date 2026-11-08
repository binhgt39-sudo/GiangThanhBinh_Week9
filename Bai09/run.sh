#!/usr/bin/env sh
set -eu
cd "$(dirname "$0")"
mvn -q test
