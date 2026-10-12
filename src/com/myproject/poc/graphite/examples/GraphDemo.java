package com.myproject.poc.graphite.examples;

import com.myproject.poc.graphite.model.Graph;
import com.myproject.poc.graphite.util.GraphBuilder;
import com.myproject.poc.graphite.util.GraphPrinter;
import com.myproject.poc.graphite.util.GraphUtils;

public class GraphDemo {

    static void main() {

        Graph graph = GraphBuilder
                .directed(6)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(2, 4)
                .addEdge(3, 5)
                .build();

        GraphPrinter.print(graph);
        System.out.println("\nEdge Count : " + GraphUtils.edgeCount(graph));

        Graph g2 = GraphUtils.transpose(graph);
        System.out.println("\nTransposed Graph : ");
        GraphPrinter.print(g2);
    }
}
