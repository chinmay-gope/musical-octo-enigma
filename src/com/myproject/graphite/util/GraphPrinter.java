package com.myproject.graphite.util;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.model.Edge;

public final class GraphPrinter {
    // ANSI escape codes
    private static final String RESET = "\u001B[0m";
    private static final String CYAN_BRIGHT = "\u001B[96m";
    private static final String YELLOW_BRIGHT = "\u001B[93m";
    private static final String MAGENTA_BRIGHT = "\u001B[95m";
    private static final String WHITE_BRIGHT = "\u001B[97m";

    private GraphPrinter() {
        throw new AssertionError("No GraphPrinter instances for you!");
    }

    public static void print(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            IO.print(CYAN_BRIGHT + i + WHITE_BRIGHT + " -> ");

            for (Edge edge : graph.getNeighbours(i)) {
                IO.print(YELLOW_BRIGHT+ edge + RESET + " ");
            }

            IO.println();
        }
    }

    public static void printEdges(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {
                System.out.printf(
                        CYAN_BRIGHT + "%d" + RESET + " -> " +
                                YELLOW_BRIGHT + "%d" + RESET +
                                " (weight = " + MAGENTA_BRIGHT + "%d" + RESET + ")%n",
                        i,
                        edge.destination(),
                        edge.weight()
                );
            }
        }
    }
}
