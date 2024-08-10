# Performance Measurements

JMH is a Java harness for building, running, and analysing nano/micro/milli/macro benchmarks written in Java and other languages targeting the JVM.

This code repository demonstrates how to measure the performance of different garbage collectors using JMH. 


## To generate executable jar file

```shell
sh javaBuild.sh
```

## To generate Docker image

```shell
sh dockerBuild.sh
```

## To execution

```shell
sh execute.sh
```

```shell

#The third parameter of the script specifies the garbage collection algorithm; 
# if no value is provided, the G1GC garbage collector is used.

sh execute.sh 2 8192m

Starting performance measurements to Java Garbage Collector
-XX:ConcGCThreads=1 -XX:G1ConcRefinementThreads=2 -XX:GCDrainStackTargetSize=64 -XX:InitialHeapSize=134217728 -XX:MarkStackSize=4194304 -XX:MaxHeapSize=2147483648 -XX:MinHeapSize=6815736 -XX:+PrintCommandLineFlags -XX:ReservedCodeCacheSize=251658240 -XX:+SegmentedCodeCache -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseG1GC
# JMH version: 1.35
# VM version: JDK 17-ea, OpenJDK 64-Bit Server VM, 17-ea+14
# VM invoker: /opt/openjdk-17/bin/java
# VM options: -XX:+UseG1GC -XX:+PrintCommandLineFlags
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 1 s each
# Measurement: 5 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 50 threads, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.jugistanbul.StreamBenchmark.measurement

...
Benchmark                    Mode  Cnt           Score           Error  Units
StreamBenchmark.measurement  avgt   15  1740294985.662 ± 113734802.949  ns/op

...

sh execute.sh 2 8192m -XX:+UseZGC
Starting performance measurements to Java Garbage Collector
-XX:InitialHeapSize=134217728 -XX:MaxHeapSize=2147483648 -XX:MinHeapSize=6815736 -XX:+PrintCommandLineFlags -XX:ReservedCodeCacheSize=251658240 -XX:+SegmentedCodeCache -XX:+UseCompressedClassPointers -XX:-UseCompressedOops -XX:+UseZGC
# JMH version: 1.35
# VM version: JDK 17-ea, OpenJDK 64-Bit Server VM, 17-ea+14
# VM invoker: /opt/openjdk-17/bin/java
# VM options: -XX:+UseZGC -XX:+PrintCommandLineFlags
# Blackhole mode: full + dont-inline hint (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 1 s each
# Measurement: 5 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 50 threads, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: org.jugistanbul.StreamBenchmark.measurement

Benchmark                    Mode  Cnt           Score           Error  Units
StreamBenchmark.measurement  avgt   15  1079675748.952 ± 121858303.656  ns/op
```