package com.myproject.graphite.demo;

import com.myproject.graphite.api.IGraph;

public final class DemoUtils {
    private DemoUtils() {
    }

    public static void printHeader(String algorithm, IGraph graph) {
        printFooter();
        System.out.println("Algorithm : " + algorithm);
        System.out.println("Graph Type: " + graph.getGraphType());
        System.out.println("Vertices  : " + graph.getVertices());
        printFooter();
    }

    public static void printFooter() {
        IO.println("================================================================================");
    }
}
