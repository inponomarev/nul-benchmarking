package uk.ac.nulondon;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AccurateBenchmark {
    @Benchmark
    public void arrayListAppending(Blackhole bh) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            list.add(i);
        }
        bh.consume(list);
    }

    @Benchmark
    public void linkedListAppending(Blackhole bh) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 500000; i++) {
            list.add(i);
        }
        bh.consume(list);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AccurateBenchmark.class.getSimpleName())
                .warmupForks(0)
                .warmupIterations(2)
                .forks(1)
                .measurementIterations(3)
                .build();

        new Runner(opt).run();
    }
}
