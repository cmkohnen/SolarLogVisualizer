#!/bin/sh
 BINDIR=$(dirname "$(readlink -fn "$0")")
 # Change this depending on the version you want to install to your local repository.
 Version=3.0.3
 # shellcheck disable=SC2164
 cd "$BINDIR"
 mvn install:install-file -Dfile=SolarLogAPI-$Version.jar -DgroupId=me.meloni -DartifactId=SolarLogAPI -Dversion=$Version -Dpackaging=jar