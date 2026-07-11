package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;

import static com.myproject.graphite.result.ResultColors.*;

public final class GraphDemoPrinter {

    private GraphDemoPrinter() {
        throw new AssertionError("No GraphDemoPrinter instances for you!");
    }

    public static void printHeader(String algorithm, IGraph graph) {
        printFooter();
        System.out.println(WHITE_BRIGHT + "Algorithm : " + RESET + CYAN_BRIGHT + algorithm + RESET);
        System.out.println(WHITE_BRIGHT + "Graph Type: " + RESET + YELLOW_BRIGHT + graph.getGraphType() + RESET);
        System.out.println(WHITE_BRIGHT + "Vertices  : " + RESET + MAGENTA_BRIGHT + graph.getVertices() + RESET);
        printFooter();
    }

    public static void printFooter() {
        IO.println("================================================================================");
    }
}
