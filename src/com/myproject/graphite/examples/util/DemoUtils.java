package com.myproject.graphite.examples.util;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.api.algorithms.interfaces.TraversalAlgorithm;
import com.myproject.graphite.exception.GraphException;
import com.myproject.graphite.result.ResultColors;
import com.myproject.graphite.util.GraphPrinter;

public final class DemoUtils {

    private DemoUtils() {
        throw new AssertionError("Utility class");
    }

    /**
     * Executes a demo section with timing and exception handling.
     */
    public static void run(String title, Runnable runnable) {
        DemoPrinter.printSection(title);

        long start = System.nanoTime();

        try {
            runnable.run();

            long end = System.nanoTime();

            DemoPrinter.printSuccess();
            DemoPrinter.printExecutionTime(end - start);
        } catch (GraphException e) {
            DemoPrinter.printFailure(e);
        }

        DemoPrinter.blankLine();
    }

    /**
     * Prints adjacency list, graph visualization, edges and neighbours.
     */
    public static void printGraph(IGraph graph) {

        printAdjacencyList(graph);

        GraphPrinter.print(graph);

        printEdges(graph);

        printNeighbours(graph);
    }

    /**
     * Prints only the adjacency list.
     */
    public static void printAdjacencyList(IGraph graph) {
        IO.println(
                "Adjacency List : " +
                        ResultColors.MAGENTA + graph.getAdjacencyList() + ResultColors.RESET
        );
    }

    /**
     * Prints all graph edges.
     */
    public static void printEdges(IGraph graph) {
        GraphPrinter.printEdges(graph);
    }

    /**
     * Prints neighbors of every vertex.
     */
    public static void printNeighbours(IGraph graph) {

        for (int vertex = 0; vertex < graph.getVertices(); vertex++) {

            System.out.printf(
                    "Neighbours of %-2d : %s%n",
                    vertex,
                    ResultColors.BLUE + graph.getNeighbours(vertex) + ResultColors.RESET
            );
        }
    }

    /**
     * Prints traversal from one source vertex.
     */
    public static void printTraversal(
            IGraph graph,
            TraversalAlgorithm algorithm,
            int source) {

        IO.println(
                algorithm.traverse(graph, source)
        );
    }

    /**
     * Prints traversals from every vertex.
     */
    public static void printTraversalsFromAllVertices(
            IGraph graph,
            TraversalAlgorithm algorithm) {

        for (int vertex = 0; vertex < graph.getVertices(); vertex++) {

            printTraversal(
                    graph,
                    algorithm,
                    vertex
            );
        }
    }
}
