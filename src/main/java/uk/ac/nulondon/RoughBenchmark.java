package uk.ac.nulondon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RoughBenchmark {
    static void arrayListAppending() {
        long start = System.nanoTime();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        double throughput = 1e9 / (end - start); //1e9 nanoseconds in a second
        System.out.printf("ArrayList throughput: %.2f ops/sec, size: %s%n", throughput, list.size());
    }

    static void linkedListAppending() {
        long start = System.nanoTime();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 500000; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        double throughput = 1e9 / (end - start); //1e9 nanoseconds in a second
        System.out.printf("LinkedList throughput: %.2f ops/sec, size: %s%n", throughput, list.size());
    }

    public static void main(String[] args) {
        arrayListAppending();
        linkedListAppending();
    }


}
