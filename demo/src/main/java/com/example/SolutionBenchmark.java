package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class SolutionBenchmark {

    @Param({})  // will be filled programmatically
    public String inputFile;

    private List<String> inputLines;

    @Setup(Level.Iteration)
    public void setup() throws IOException {
        inputLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("in/" + inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                inputLines.add(line);
            }
        }
    }

    private BufferedReader getReader() {
        return new BufferedReader(new StringReader(String.join("\n", inputLines)));
    }

    @Benchmark
    public int naiveSolveBenchmark() throws IOException {
        return Solution.naiveSolve(getReader());
    }

    @Benchmark
    public int binarySearchSolveBenchmark() throws IOException {
        return Solution.binarySearchSolve(getReader());
    }

    @Benchmark
    public int exponentialSearchSolveBenchmark() throws IOException {
        return Solution.exponentialSearchSolve(getReader());
    }
}