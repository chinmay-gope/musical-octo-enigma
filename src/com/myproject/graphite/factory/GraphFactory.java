package com.myproject.graphite.factory;

import com.myproject.graphite.generator.RandomGraphGenerator;
import com.myproject.graphite.model.DirectedGraph;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.model.UnDirectedGraph;

public final class GraphFactory {

    public static final double DENSITY = 0.75;

    private GraphFactory() {
    }

    public static Graph create(GraphType type, int vertices) {
        return switch (type) {

            case DIRECTED -> new DirectedGraph(vertices);

            case UNDIRECTED -> new UnDirectedGraph(vertices);
        };
    }

    public static Graph traversalGraph(int vertices) {

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(vertices * 2)
                .connected(true)
                .build();
    }

    public static Graph mstGraph(int vertices) {
        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(vertices * 3)
                .weighted(true)
                .connected(true)
                .build();
    }

    public static Graph denseGraph(int vertices) {

        return denseGraph(vertices, DENSITY);
    }

    public static Graph directedDenseGraph(int vertices) {

        int maximumEdges = vertices * (vertices - 1) / 2;

        int edges = (int) (maximumEdges * 0.75);

        return RandomGraphGenerator
                .directed()
                .vertices(vertices)
                .edges(edges)
                .connected(true)
                .build();
    }

    public static Graph denseGraph(int vertices, double density) {

        int maximumEdges = vertices * (vertices - 1) / 2;

        int edges = (int) (maximumEdges * density);

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(edges)
                .connected(true)
                .build();
    }

    public static Graph denseWeightedGraph(int vertices) {

        int maxEdges = vertices * (vertices - 1) / 2;

        int edges = (int) (maxEdges * DENSITY);

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(edges)
                .connected(true)
                .weighted(true)
                .weightRange(1, 50)
                .build();
    }

    public static Graph weightedGraph(int vertices) {

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges(vertices * 2)
                .connected(true)
                .weighted(true)
                .weightRange(1, 50)
                .build();
    }

    public static Graph directedGraph(int vertices) {

        return RandomGraphGenerator
                .directed()
                .vertices(vertices)
                .edges(vertices * 2)
                .build();
    }

    public static Graph sparseGraph(int vertices) {

        return RandomGraphGenerator
                .undirected()
                .vertices(vertices)
                .edges((int) (vertices * 1.3))
                .connected(true)
                .build();
    }
    public static Graph directedSparseGraph(int vertices) {

        return RandomGraphGenerator
                .directed()
                .vertices(vertices)
                .edges((int) (vertices * 1.3))
                .connected(true)
                .build();
    }

    public static Graph dag(int vertices) {

        return RandomGraphGenerator
                .dag(vertices);
    }
}
