package com.myproject.graphite.util;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.exceptions.validation.UnsupportedGraphTypeException;
import com.myproject.graphite.factory.GraphFactory;
import com.myproject.graphite.factory.GraphType;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.model.Graph;

public final class GraphUtils {
    private GraphUtils() {
        throw new AssertionError("No GraphUtils instances for you!");
    }

    public static int edgeCount(IGraph graph) {
        int count = 0;

        for (int i = 0; i < graph.getVertices(); i++) {
            count += graph.getNeighbours(i).size();
        }

        return count;
    }

    public static Graph transpose(IGraph graph) {
        if (graph.getGraphType() != GraphType.DIRECTED) {
            throw new UnsupportedGraphTypeException(graph.getGraphType(), GraphType.DIRECTED);
        }
        Graph reversed = GraphFactory.create(
                GraphType.DIRECTED,
                graph.getVertices()
        );

        for (int source = 0; source < graph.getVertices(); source++) {
            for (Edge edge : graph.getNeighbours(source)) {
                reversed.addEdge(
                        edge.destination(),
                        source,
                        edge.weight()
                );
            }
        }

        return reversed;
    }

    public static Graph cloneGraph(IGraph graph) {
        Graph clone = GraphFactory.create(
                graph.getGraphType(),
                graph.getVertices()
        );

        for (int i = 0; i < graph.getVertices(); i++) {
            for (Edge edge : graph.getNeighbours(i)) {
                clone.addEdge(
                        i,
                        edge.destination(),
                        edge.weight()
                );
            }
        }

        return clone;
    }
}
