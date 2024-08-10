package org.jugistanbul;

import org.openjdk.jmh.annotations.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(3)
@Threads(50)
public class StreamBenchmark {


    public static void main(String[] args) {}

    @Benchmark
    public void measurement(){
        var list = new ArrayList<BigDecimal>();
        IntStream.range(0, 500_000)
                .mapToObj(BigDecimal::valueOf)
                .forEach(list::add);
    }
}