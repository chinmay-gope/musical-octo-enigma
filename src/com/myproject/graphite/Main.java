package com.myproject.graphite;

import com.myproject.graphite.model.Graph;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;

public class Main {
    static void main() {
        Graph graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(2, 4)
                .build();

        System.out.println("Undirected Adj List : " + graph.getAdjacencyList());
        GraphPrinter.print(graph);

        Graph graph2 = GraphBuilder
                .directed(4)
                .addEdge(0, 1, 5)
                .addEdge(1, 2, 7)
                .addEdge(2, 3, 9)
                .build();

        System.out.println("Directed Adj List : " + graph2.getAdjacencyList());
        GraphPrinter.print(graph2);
    }
}
