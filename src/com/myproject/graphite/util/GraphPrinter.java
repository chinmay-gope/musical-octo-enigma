package com.myproject.graphite.util;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.model.Edge;

public final class GraphPrinter {
    private GraphPrinter() {
        throw new AssertionError("No GraphPrinter instances for you!");
    }

    public static void print(IGraph graph, String title) {
        IO.println(title);

        for (int i = 0; i < graph.getVertices(); i++) {
            IO.print(i + " -> ");

            for (Edge edge : graph.getNeighbours(i)) {
                IO.print(edge + " ");
            }

            IO.println();
        }
    }

    public static void printEdges(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {
                System.out.printf(
                        "%d -> %d (weight=%d)%n",
                        i,
                        edge.destination(),
                        edge.weight()
                );
            }
        }
    }
}
