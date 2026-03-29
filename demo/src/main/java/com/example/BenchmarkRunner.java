package com.example;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {

    public static void runGroup(String[] files, String groupName) throws Exception {
        System.out.println("=== Running group: " + groupName + " ===");

        Options opt = new OptionsBuilder()
                .include(SolutionBenchmark.class.getSimpleName())
                .param("inputFile", files)
                .forks(1)
                .warmupIterations(2)
                .measurementIterations(3)
                .build();

        new Runner(opt).run();
    }

    public static void main(String[] args) throws Exception {
        // Group 1
        runGroup(new String[]{"big_huge_normal.in", "big_huge_random.in"}, "Big Huge Inputs");

        // Group 2
        runGroup(new String[]{"pla10b.in", "pla10a.in"}, "PLA 10 Inputs");
    }
}