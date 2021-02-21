#!/bin/sh
 BinDir=$(dirname "$(readlink -fn "$0")")
 # Change this depending on the version you want to install to your local repository.
 Version=4.0.1
 cd "$BinDir" || return
 wget "https://github.com/ChaosMelone9/SolarLogAPI/releases/download/$Version/SolarLogAPI-$Version.jar"
 mvn install:install-file -Dfile=SolarLogAPI-$Version.jar -DgroupId=me.meloni -DartifactId=SolarLogAPI -Dversion=$Version -Dpackaging=jar
 rm "SolarLogAPI-$Version.jar"