package com.myproject.graphite.util;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.model.Edge;

public final class GraphPrinter {
    private GraphPrinter() {
        throw new AssertionError("No GraphPrinter instances for you!");
    }

    public static void print(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            IO.println(i + " -> ");

            for (Edge edge : graph.getNeighbours(i)) {
                IO.println(edge + " ");
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
                        edge.getDestination(),
                        edge.getWeight()
                );
            }
        }
    }
}
