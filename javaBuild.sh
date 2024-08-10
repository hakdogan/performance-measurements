#!/bin/bash

main_directory=$(pwd)

cd src/main/java

javac -cp "$main_directory/lib/*" \
-d $main_directory/out \
$(find . -name "*.java")

cd $main_directory/out

jar -cmf ../manifest.txt measurement.jar .