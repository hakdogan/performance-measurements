package org.jugistanbul;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author hakdogan (huseyin.akdogan@patikaglobal.com)
 * Created on 8.09.2023
 ***/
public class JMHBenchmarkRunner
{
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StreamBenchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
