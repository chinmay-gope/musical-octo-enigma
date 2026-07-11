package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.interfaces.MSTAlgorithm;
import com.myproject.graphite.api.algorithms.mst.Prim;
import com.myproject.graphite.exceptions.GraphException;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.MSTResult;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;

public class PrimDemo {
    static void main() {
        Graph graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1, 2)
                .addEdge(0, 3, 6)
                .addEdge(1, 2, 3)
                .addEdge(1, 3, 8)
                .addEdge(1, 4, 5)
                .addEdge(2, 4, 7)
                .addEdge(3, 4, 9)
                .build();

        GraphPrinter.print(graph);
        GraphDemoPrinter.printHeader("Prim MST", graph);

        MSTAlgorithm algorithm = new Prim();

        MSTResult result = algorithm.findMST(graph, 0);

        System.out.println(result);

        GraphDemoPrinter.printFooter();

        Graph graph2 = GraphBuilder
                .undirected(4)
                .addEdge(0, 1, 1)
                .addEdge(0, 2, 1)
                .addEdge(1, 2, 1)
                .addEdge(1, 3, 2)
                .addEdge(2, 3, 2)
                .build();

        GraphPrinter.print(graph2);
        GraphDemoPrinter.printHeader("Prim MST With Multiple Equal Weights", graph2);

        result = algorithm.findMST(graph2, 0);
        System.out.println(result);

        Graph graph3 = GraphBuilder
                .undirected(1)
                .build();
        GraphDemoPrinter.printHeader("Prim MST With Single Vertex", graph3);

        result = algorithm.findMST(graph3, 0);
        System.out.println(result);


        Graph negativeWeightCycle = GraphBuilder
                .undirected(4)
                .addEdge(0, 1, 1)
                .addEdge(1, 2, -1)
                .addEdge(2, 3, -1)
                .addEdge(3, 1, -1)
                .build();

        GraphDemoPrinter.printHeader("Prim MST With Negative Weight Cycle", negativeWeightCycle);
        GraphPrinter.print(negativeWeightCycle);
        result = algorithm.findMST(negativeWeightCycle, 0);
        System.out.println(result);

        try {
            Graph disconnectedGraph = GraphBuilder
                    .undirected(6)
                    .addEdge(0, 1, 4)
                    .addEdge(1, 2, 2)
                    .addEdge(3, 4, 1)
                    .build();

            GraphPrinter.print(disconnectedGraph);
            GraphDemoPrinter.printHeader("Prim MST With Disconnected Graph", disconnectedGraph);

            result = algorithm.findMST(disconnectedGraph, 0);
            System.out.println(result);

        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
