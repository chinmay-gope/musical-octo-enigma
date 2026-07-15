package com.myproject.graphite.generator;

import com.myproject.graphite.model.Graph;
import com.myproject.graphite.util.GraphBuilder;

public final class GraphGenerator {

    private GraphGenerator() {
        throw new AssertionError("Utility class");
    }

    /**
     * Generates a path graph.
     *
     * 0──1──2──3──...──(n-1)
     */
    public static Graph pathGraph(int vertices) {
        validateVertices(vertices);

        GraphBuilder builder = GraphBuilder.undirected(vertices);

        for (int i = 0; i < vertices - 1; i++) {
            builder.addEdge(i, i + 1);
        }

        return builder.build();
    }

    /**
     * Generates a cycle graph.
     *
     * 0──1
     * |  |
     * 5──2
     * |  |
     * 4──3
     */
    public static Graph cycleGraph(int vertices) {
        validateVertices(vertices);

        GraphBuilder builder = GraphBuilder.undirected(vertices);

        for (int i = 0; i < vertices - 1; i++) {
            builder.addEdge(i, i + 1);
        }

        if (vertices > 2) {
            builder.addEdge(vertices - 1, 0);
        }

        return builder.build();
    }

    /**
     * Generates a star graph.
     *      1
     *      |
     * 4 ----0----2
     *      |
     *      3
     */
    public static Graph starGraph(int vertices) {
        validateVertices(vertices);

        GraphBuilder builder = GraphBuilder.undirected(vertices);

        for (int i = 1; i < vertices; i++) {
            builder.addEdge(0, i);
        }

        return builder.build();
    }

    /**
     *  Generates a complete graph.

            0────1
            |\  /|
            | \/ |
            | /\ |
            |/  \|
            2────3
     */
    public static Graph completeGraph(int vertices) {

        validateVertices(vertices);

        GraphBuilder builder = GraphBuilder.undirected(vertices);

        for (int source = 0; source < vertices; source++) {

            for (int destination = source + 1; destination < vertices; destination++) {

                builder.addEdge(source, destination);
            }
        }

        return builder.build();
    }

    /**
     *  Generates a wheel graph.
               1
            /-----\
           5---0---2
            \     /
              4-3
     */
    public static Graph wheelGraph(int vertices) {

        if (vertices < 4) {
            throw new IllegalArgumentException(
                    "Wheel graph requires at least 4 vertices."
            );
        }

        GraphBuilder builder = GraphBuilder.undirected(vertices);

        // Outer cycle
        for (int i = 1; i < vertices - 1; i++) {
            builder.addEdge(i, i + 1);
        }

        builder.addEdge(vertices - 1, 1);

        // Hub (0)
        for (int i = 1; i < vertices; i++) {
            builder.addEdge(0, i);
        }

        return builder.build();
    }

    private static void validateVertices(int vertices) {

        if (vertices < 1) {
            throw new IllegalArgumentException(
                    "Number of vertices must be at least 1."
            );
        }
    }
}
