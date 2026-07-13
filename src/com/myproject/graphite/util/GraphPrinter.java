package com.myproject.graphite.util;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.model.Edge;

import static com.myproject.graphite.result.ResultColors.*;

public final class GraphPrinter {

    private GraphPrinter() {
        throw new AssertionError("No GraphPrinter instances for you!");
    }

    public static void print(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            IO.print(CYAN + i + WHITE + " -> ");

            for (Edge edge : graph.getNeighbours(i)) {
                IO.print(YELLOW + edge + RESET + " ");
            }

            IO.println();
        }
    }

    public static void printEdges(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {
                System.out.printf(
                        CYAN + "%d" + RESET + " -> " +
                                YELLOW + "%d" + RESET +
                                " (weight = " + MAGENTA + "%d" + RESET + ")%n",
                        i,
                        edge.destination(),
                        edge.weight()
                );
            }
        }
    }
}
