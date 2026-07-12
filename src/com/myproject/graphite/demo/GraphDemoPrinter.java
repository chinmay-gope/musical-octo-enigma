package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;

import static com.myproject.graphite.result.ResultColors.*;

public final class GraphDemoPrinter {

    private GraphDemoPrinter() {
        throw new AssertionError("No GraphDemoPrinter instances for you!");
    }

    public static void printHeader(String algorithm, IGraph graph) {
        printFooter();
        System.out.println(WHITE + "Algorithm : " + RESET + CYAN + algorithm + RESET);
        System.out.println(WHITE + "Graph Type: " + RESET + YELLOW + graph.getGraphType() + RESET);
        System.out.println(WHITE + "Vertices  : " + RESET + MAGENTA + graph.getVertices() + RESET);
        printFooter();
    }

    public static void printFooter() {
        IO.println("================================================================================");
    }
}
