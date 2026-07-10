package com.myproject.graphite.api.algorithms;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.exceptions.UnsupportedGraphTypeException;
import com.myproject.graphite.factory.GraphType;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.util.GraphValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class GraphAlgorithm {

    protected void validateGraph(IGraph graph) {
        Objects.requireNonNull(graph, "Graph cannot be null.");
    }

    protected void validateVertex(IGraph graph, int vertex) {
        GraphValidator.validateVertex(graph, vertex);
    }

    protected boolean[] createVisitedArray(IGraph graph) {
        return new boolean[graph.getVertices()];
    }

    protected int[] createDistanceArray(IGraph graph, int initialValue) {
        int[] distance = new int[graph.getVertices()];
        Arrays.fill(distance, initialValue);
        return distance;
    }

    protected List<Integer> createTraversalList() {
        return new ArrayList<>();
    }

    protected Iterable<Edge> neighbours(IGraph graph, int vertex) {
        return graph.getNeighbours(vertex);
    }

    protected void requireDirectedGraph(IGraph graph) {
        if (graph.getGraphType() != GraphType.DIRECTED) {
            throw new UnsupportedGraphTypeException(
                    GraphType.DIRECTED,
                    graph.getGraphType()
            );
        }
    }

    protected void requireUndirectedGraph(IGraph graph) {
        if (graph.getGraphType() != GraphType.UNDIRECTED) {
            throw new UnsupportedGraphTypeException(
                    GraphType.UNDIRECTED,
                    graph.getGraphType()
            );
        }
    }
}
