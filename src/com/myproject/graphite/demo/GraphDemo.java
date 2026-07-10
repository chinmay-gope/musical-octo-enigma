package com.myproject.graphite.demo;

import com.myproject.graphite.model.Graph;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;

public class GraphDemo {

    static void main() {

        Graph graph = GraphBuilder
                .undirected(6)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(2, 4)
                .addEdge(3, 5)
                .build();

        GraphPrinter.print(graph, "Original Graph");
    }
}