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
#CPU: 2 RAM: 8GB Garbage Collector: G1GC
 
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
Result "org.jugistanbul.StreamBenchmark.measurement":
  1739932886.556 ±(99.9%) 109225730.527 ns/op [Average]
  (min, avg, max) = (1497378210.040, 1739932886.556, 1902763585.180), stdev = 102169816.112
  CI (99.9%): [1630707156.029, 1849158617.083] (assumes normal distribution)


# Run complete. Total time: 00:03:36

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                    Mode  Cnt           Score           Error  Units
StreamBenchmark.measurement  avgt   15  1739932886.556 ± 109225730.527  ns/op

...

sh execute.sh 2 8192m -XX:+UseZGC
#CPU: 2 RAM: 8GB Garbage Collector: ZGC

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

...

Result "org.jugistanbul.StreamBenchmark.measurement":
  1120847190.661 ±(99.9%) 112668974.602 ns/op [Average]
  (min, avg, max) = (983403333.550, 1120847190.661, 1306016609.643), stdev = 105390628.756
  CI (99.9%): [1008178216.059, 1233516165.263] (assumes normal distribution)


# Run complete. Total time: 00:02:04

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                    Mode  Cnt           Score           Error  Units
StreamBenchmark.measurement  avgt   15  1120847190.661 ± 112668974.602  ns/op

...

sh execute.sh 1 8192m -XX:+UseZGC
#CPU: 1 RAM: 8GB Garbage Collector: ZGC

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

...

Result "org.jugistanbul.StreamBenchmark.measurement":
  1567409847.903 ±(99.9%) 195128400.805 ns/op [Average]
  (min, avg, max) = (1297439204.800, 1567409847.903, 1973717241.460), stdev = 182523227.195
  CI (99.9%): [1372281447.097, 1762538248.708] (assumes normal distribution)


# Run complete. Total time: 00:03:04

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                    Mode  Cnt           Score           Error  Units
StreamBenchmark.measurement  avgt   15  1567409847.903 ± 195128400.805  ns/op
```