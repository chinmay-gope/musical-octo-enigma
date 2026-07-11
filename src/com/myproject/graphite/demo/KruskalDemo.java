package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.interfaces.MSTAlgorithm;
import com.myproject.graphite.api.algorithms.mst.Kruskal;
import com.myproject.graphite.exceptions.GraphException;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.MSTResult;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;

public class KruskalDemo {
    static void main() {
        Graph graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1, 2)
                .addEdge(0, 3, 6)
                .addEdge(1, 2, 3)
                .addEdge(1, 3, 8)
                .addEdge(1, 4, 5)
                .addEdge(2, 3, 5)
                .addEdge(0, 1, 5)
                .addEdge(2, 4, 7)
                .addEdge(3, 4, 9)
                .build();

        GraphDemoPrinter.printHeader("Kruskal MST", graph);
        GraphPrinter.printEdges(graph);
        GraphPrinter.print(graph);

        MSTAlgorithm algorithm = new Kruskal();

        Graph equalWeights = GraphBuilder
                .undirected(4)
                .addEdge(0, 1, 1)
                .addEdge(0, 2, 1)
                .addEdge(1, 2, 1)
                .addEdge(1, 3, 2)
                .addEdge(2, 3, 2)
                .build();
        GraphDemoPrinter.printHeader("Kruskal MST Equal Weights", graph);
        GraphPrinter.print(equalWeights);
        MSTResult result = algorithm.findMST(graph, 0);
        System.out.println(result);

        Graph single = GraphBuilder
                .undirected(1)
                .build();
        GraphDemoPrinter.printHeader("Kruskal MST Single", graph);
        GraphPrinter.print(single);
        result = algorithm.findMST(single, 0);
        System.out.println(result);

        Graph cycleHeavyGraph = GraphBuilder
                .undirected(6)
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 4)
                .addEdge(1, 2, 2)
                .addEdge(1, 3, 5)
                .addEdge(2, 3, 5)
                .addEdge(2, 4, 11)
                .addEdge(3, 4, 2)
                .addEdge(3, 5, 1)
                .addEdge(4, 5, 7)
                .build();
        GraphDemoPrinter.printHeader("Kruskal MST Cycle Heavy", graph);
        GraphPrinter.printEdges(cycleHeavyGraph);
        result = algorithm.findMST(cycleHeavyGraph, 0);
        System.out.println(result);

        try {
            Graph disconnectedGraph = GraphBuilder
                    .undirected(6)
                    .addEdge(0, 1, 4)
                    .addEdge(1, 2, 2)
                    .addEdge(3, 4, 1)
                    .build();
            GraphDemoPrinter.printHeader("Kruskal MST Disconnected Graph", graph);
            result = algorithm.findMST(disconnectedGraph, 0);
            System.out.println(result);
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
