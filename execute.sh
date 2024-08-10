#!/bin/bash

cpus=${1:-1}
memory=${2:-'128m'}
gc=${3:-'-XX:+UseG1GC'}

echo "Starting performance measurements to Java Garbage Collector"

docker run --memory=$memory --cpus=$cpus performance-measurement-app java $gc -XX:+PrintCommandLineFlags -jar /app/measurement.jar
