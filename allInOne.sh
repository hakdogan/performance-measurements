#!/bin/bash

cpus=${1:-1}
memory=${2:-'128m'}
gc=${3:-'-XX:+UseG1GC'}

sh javaBuild.sh dockerBuild.sh execute.sh $cpus $memory $gc