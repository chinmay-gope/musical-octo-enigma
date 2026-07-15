package com.myproject.graphite.examples.util;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.util.GraphBuilder;

public final class DemoGraphs {

    private DemoGraphs() {
    }

    /**
     * BFS / DFS
     */
    public static IGraph traversalGraph() {

        return GraphBuilder
                .undirected(8)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(2, 5)
                .addEdge(4, 6)
                .addEdge(5, 7)
                .build();
    }

    /**
     * Directed Acyclic Graph
     * DFS Topological
     * Kahn Topological
     */
    public static IGraph dag() {

        return GraphBuilder
                .directed(8)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(2, 3)
                .addEdge(2, 4)
                .addEdge(3, 5)
                .addEdge(4, 6)
                .addEdge(5, 7)
                .addEdge(6, 7)
                .build();
    }

    /**
     * Dijkstra
     * Bellman Ford
     * Floyd Warshall
     */
    public static IGraph weightedGraph() {

        return GraphBuilder
                .directed(7)
                .addEdge(0, 1, 2)
                .addEdge(0, 2, 5)
                .addEdge(1, 2, 1)
                .addEdge(1, 3, 3)
                .addEdge(2, 4, 6)
                .addEdge(3, 4, 2)
                .addEdge(3, 5, 4)
                .addEdge(4, 6, 1)
                .addEdge(5, 6, 7)
                .build();
    }

    /**
     * Bellman Ford (Negative Weights)
     */
    public static IGraph negativeWeightGraph() {

        return GraphBuilder
                .directed(6)
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 5)
                .addEdge(1, 2, -2)
                .addEdge(1, 3, 6)
                .addEdge(2, 4, 3)
                .addEdge(4, 5, -1)
                .addEdge(3, 5, 2)
                .build();
    }

    /**
     * Bellman Ford Exception Demo
     */
    public static IGraph negativeCycleGraph() {

        return GraphBuilder
                .directed(5)
                .addEdge(0, 1, 2)
                .addEdge(1, 2, -5)
                .addEdge(2, 3, 1)
                .addEdge(3, 1, 1)
                .addEdge(3, 4, 2)
                .build();
    }

    /**
     * Prim
     * Kruskal
     */
    public static IGraph mstGraph() {

        return GraphBuilder
                .undirected(8)
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 3)
                .addEdge(1, 2, 2)
                .addEdge(1, 3, 5)
                .addEdge(2, 4, 6)
                .addEdge(3, 4, 1)
                .addEdge(3, 5, 7)
                .addEdge(4, 6, 8)
                .addEdge(5, 6, 9)
                .addEdge(5, 7, 2)
                .addEdge(6, 7, 4)
                .build();
    }

    /**
     * Bridges
     * Articulation Points
     * Biconnected Components
     */
    public static IGraph articulationGraph() {

        return GraphBuilder
                .undirected(9)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(1, 3)
                .addEdge(3, 4)
                .addEdge(4, 5)
                .addEdge(5, 3)
                .addEdge(3, 6)
                .addEdge(6, 7)
                .addEdge(6, 8)
                .build();
    }

    /**
     * Kosaraju
     */
    public static IGraph sccGraph() {

        return GraphBuilder
                .directed(10)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)

                .addEdge(2, 3)

                .addEdge(3, 4)
                .addEdge(4, 5)
                .addEdge(5, 3)

                .addEdge(5, 6)

                .addEdge(6, 7)
                .addEdge(7, 6)

                .addEdge(7, 8)
                .addEdge(8, 9)
                .build();
    }

    /**
     * Cycle Detection
     */
    public static IGraph directedCycleGraph() {

        return GraphBuilder
                .directed(6)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 1)
                .addEdge(3, 4)
                .addEdge(4, 5)
                .build();
    }

    /**
     * Undirected Cycle Detection
     */
    public static IGraph undirectedCycleGraph() {

        return GraphBuilder
                .undirected(7)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .addEdge(4, 5)
                .addEdge(5, 6)
                .build();
    }
}
