package com.myproject.data_structures.sorting;

import java.util.Arrays;
import java.util.Random;

public class SortSuite {

    private static final int WARMUP = 3;
    private static final int ITERATIONS = 10;

    static void main(String[] args) {

        Sort[] algorithms = {new BubbleSort(), new SelectionSort(), new InsertionSort(),
                new MergeSort(), new QuickSort(), new DualPivotQuickSort(), new HeapSort()};

        int[] sizes = {100, 500, 1_000, 2_500, 5_000, 10_000, 25_000, 50_000, 100_000};

        System.out.println("==============================================================");
        System.out.println("            SORTING ALGORITHM BENCHMARK SUITE");
        System.out.println("==============================================================");
        System.out.println("Java Version : " + System.getProperty("java.version"));
        System.out.println("Warmups      : " + WARMUP);
        System.out.println("Iterations   : " + ITERATIONS);
        System.out.println("Algorithms   : " + algorithms.length);
        System.out.println("==============================================================");

        for (int size : sizes) {

            benchmark("Random", randomArray(size), algorithms);

            benchmark("Sorted", sortedArray(size), algorithms);

            benchmark("Reverse", reverseArray(size), algorithms);
        }
    }

    private static void benchmark(String dataset, int[] original, Sort[] algorithms) {

        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("Dataset : " + dataset);
        System.out.println("Size    : " + original.length);
        System.out.println("--------------------------------------------------------------");

        Result[] results = new Result[algorithms.length];

        int index = 0;

        for (Sort algorithm : algorithms) {

            String reason = skipReason(algorithm, dataset, original.length);

            if (reason != null) {

                results[index++] = new Result(algorithm.getName(), -1, false, reason);

                continue;
            }

            System.out.println("Running : " + algorithm.getName());

            // Warmup

            for (int i = 0; i < WARMUP; i++) {

                int[] copy = Arrays.copyOf(original, original.length);

                algorithm.sort(copy);
            }

            long total = 0;

            for (int i = 0; i < ITERATIONS; i++) {

                int[] copy = Arrays.copyOf(original, original.length);

                long start = System.nanoTime();

                algorithm.sort(copy);

                long end = System.nanoTime();

                if (!isSorted(copy)) {

                    throw new IllegalStateException(algorithm.getName() + " produced an incorrect result.");
                }

                total += end - start;
            }

            double average = total / (double) ITERATIONS / 1_000_000.0;

            results[index++] = new Result(algorithm.getName(), average, true, "Completed");
        }

        Arrays.sort(results, (a, b) -> {

            if (a.time() < 0 && b.time() < 0) return 0;

            if (a.time() < 0) return 1;

            if (b.time() < 0) return -1;

            return Double.compare(a.time(), b.time());
        });

        printResults(results);
    }

    private static void printResults(Result[] results) {

        System.out.printf("%-5s %-25s %-12s %-10s %-35s%n", "Rank", "Algorithm", "Avg(ms)", "Sorted", "Status");

        System.out.println("---------------------------------------------------------------------------------------------");

        int rank = 1;

        for (Result result : results) {

            if (result.time() < 0) {

                System.out.printf("%-5s %-25s %-12s %-10s %-35s%n", "-", result.algorithm(), "Skipped", "-", result.reason());

            } else {

                System.out.printf("%-5d %-25s %-12.3f %-10s %-35s%n", rank++, result.algorithm(), result.time(), result.sorted() ? "Yes" : "No", result.reason());
            }
        }
    }

    private static String skipReason(Sort algorithm, String dataset, int size) {

        // O(n²) algorithms
        if (size > 10_000 && (algorithm instanceof BubbleSort || algorithm instanceof SelectionSort || algorithm instanceof InsertionSort)) {

            return "Quadratic complexity";
        }

        // Classic Quick Sort
        if (size > 25_000 && ("Sorted".equals(dataset) || "Reverse".equals(dataset)) && algorithm instanceof QuickSort) {

            return "Worst-case pivot selection";
        }

        // Textbook Dual Pivot Quick Sort
        if (size > 50_000 && ("Sorted".equals(dataset) || "Reverse".equals(dataset)) && algorithm instanceof DualPivotQuickSort) {

            return "Non-optimized pivot selection";
        }

        return null;
    }

    private static boolean isSorted(int[] array) {

        for (int i = 1; i < array.length; i++) {

            if (array[i - 1] > array[i]) {
                return false;
            }
        }

        return true;
    }

    private static int[] randomArray(int size) {

        Random random = new Random();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }

        return array;
    }

    private static int[] sortedArray(int size) {

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        return array;
    }

    private static int[] reverseArray(int size) {

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }

        return array;
    }

    private record Result(String algorithm, double time, boolean sorted, String reason) {
    }
}
