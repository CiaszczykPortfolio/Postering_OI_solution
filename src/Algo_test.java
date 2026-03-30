import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Algo_test {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.err.println("Usage: java Algo_test <input_file>");
            return;
        }

        String inputFile = args[0];
        try{

            // NAIVE
            int repeat = 10;
            long start = System.nanoTime();
            for (int i = 0; i < repeat; i++) 
                Solution.naiveSolve(new BufferedReader(new FileReader(inputFile)));
            long end = System.nanoTime();
            System.out.printf("naiveSolve x%d: %.3f ms%n", repeat, (end - start)/1e6);

            // BINARY SEARCH
            start = System.nanoTime();
            for(int i = 0; i<repeat;i++)
                Solution.binarySearchSolve(new BufferedReader(new FileReader(inputFile)));
            end = System.nanoTime();
            System.out.printf("binarySolve x%d: %.3f ms%n", repeat, (end - start)/1e6);

            // EXPONENTIAL SEARCH
            start = System.nanoTime();
            for(int i=0;i<repeat;i++)
                Solution.exponentialSearchSolve(new BufferedReader(new FileReader(inputFile)));
            end = System.nanoTime();
            System.out.printf("ExponentialSolve x%d: %.3f ms%n", repeat, (end - start)/1e6);

        } catch(IOException e) {
            System.err.println(e);
        }
    }
}