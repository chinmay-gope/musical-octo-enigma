package com.myproject.graphite.examples.util;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.api.algorithms.traversal.BFS;
import com.myproject.graphite.api.algorithms.traversal.DFS;

public final class TraversalDemo {

    private static final IGraph GRAPH =
            DemoGraphs.traversalGraph();

    private TraversalDemo() {
        throw new AssertionError("Utility class");
    }

    static void main() {
        DemoPrinter.printHeader(
                "Traversal Algorithms",
                GRAPH
        );

        DemoUtils.run(
                "Graph",
                () -> DemoUtils.printGraph(GRAPH)
        );

        DemoUtils.run(
                "Breadth First Search",
                () -> DemoUtils.printTraversalsFromAllVertices(
                        GRAPH,
                        new BFS())
        );

        DemoUtils.run(
                "Depth First Search",
                () -> DemoUtils.printTraversalsFromAllVertices(
                        GRAPH,
                        new DFS())
        );
    }
}
