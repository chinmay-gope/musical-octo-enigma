package com.myproject.data_structures.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortSuite {

    private static final int WARMUP = 3;
    private static final int ITERATIONS = 10;

    static void main(String[] args) {

        Sort[] algorithms = {new BubbleSort(), new SelectionSort(), new InsertionSort(), new MergeSort(), new QuickSort(), new DualPivotQuickSort(), new HeapSort()};

        int[] sizes = {100, 500, 1_000, 2_500, 5_000, 10_000, 25_000};
//                50_000, 100_000};

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
            System.out.println("Running: " + algorithm.getName());

            // Skip slow algorithms for large arrays
            if ((original.length > 10_000) && (
                    algorithm instanceof BubbleSort
                            || algorithm instanceof SelectionSort
                            || algorithm instanceof InsertionSort)) {

                results[index++] = new Result(algorithm.getName(), -1, true);

                continue;
            }

            // Warmup
            for (int i = 0; i < WARMUP; i++) {
                int[] copy = Arrays.copyOf(original, original.length);
                algorithm.sort(copy);
            }

            long total = 0;

            boolean sorted = true;

            for (int i = 0; i < ITERATIONS; i++) {

                int[] copy = Arrays.copyOf(original, original.length);

                long start = System.nanoTime();

                algorithm.sort(copy);

                long end = System.nanoTime();

                total += end - start;

                sorted &= isSorted(copy);
            }

            double avgMs = total / (double) ITERATIONS / 1_000_000.0;

            results[index++] = new Result(algorithm.getName(), avgMs, sorted);
        }

        Arrays.sort(results, Comparator.comparingDouble(Result::time));

        System.out.printf("%-5s %-25s %-12s %-10s%n", "Rank", "Algorithm", "Avg(ms)", "Sorted");

        int rank = 1;

        for (Result result : results) {

            if (result.time() < 0) {

                System.out.printf("%-5s %-25s %-12s %-10s%n", "-", result.algorithm(), "Skipped", "-");

            } else {

                System.out.printf("%-5d %-25s %-12.3f %-10s%n", rank++, result.algorithm(), result.time(), result.sorted() ? "Yes" : "No");
            }
        }
    }

    private static boolean isSorted(int[] array) {

        for (int i = 1; i < array.length; i++) {

            if (array[i - 1] > array[i]) return false;
        }

        return true;
    }

    private static int[] randomArray(int size) {

        Random random = new Random();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
            arr[i] = random.nextInt(size);

        return arr;
    }

    private static int[] sortedArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
            arr[i] = i;

        return arr;
    }

    private static int[] reverseArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
            arr[i] = size - i;

        return arr;
    }

    private record Result(String algorithm, double time, boolean sorted) {
    }

}
