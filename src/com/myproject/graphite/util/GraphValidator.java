package com.myproject.graphite.util;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.exceptions.InvalidVertexException;
import com.myproject.graphite.model.Edge;

public final class GraphValidator {
    private GraphValidator() {
        throw new AssertionError("No GraphValidator instances for you!");
    }

    public static boolean isEmpty(IGraph graph) {
        return graph.isEmpty();
    }

    public static boolean hasSelfLoop(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {

                if (i == edge.getDestination()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasWeightedEdges(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {
                if (edge.getWeight() != 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasNegativeEdges(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {
                if (edge.getWeight() < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void validateVertex(IGraph graph, int vertex) {
        if (graph == null) {
            throw new NullPointerException("Graph cannot be null.");
        }

        if (vertex < 0 || vertex >= graph.getVertices()) {
            throw new InvalidVertexException(vertex);
        }
    }
}
