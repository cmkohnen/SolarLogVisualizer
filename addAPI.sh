#!/bin/sh
 BINDIR=$(dirname "$(readlink -fn "$0")")
 cd "$BINDIR"
 mvn install:install-file -Dfile=SolarLogAPI-2.0.0.jar -DgroupId=me.meloni -DartifactId=SolarLogAPI -Dversion=2.0.0 -Dpackaging=jar