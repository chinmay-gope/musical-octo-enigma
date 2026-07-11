package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;

public final class GraphDemoPrinter {

    private static final String RESET = "\u001B[0m";
    private static final String CYAN_BRIGHT = "\u001B[96m";
    private static final String YELLOW_BRIGHT = "\u001B[93m";
    private static final String MAGENTA_BRIGHT = "\u001B[95m";
    private static final String WHITE_BRIGHT = "\u001B[97m";

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
