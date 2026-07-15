package com.myproject.graphite.examples;

import com.myproject.graphite.api.algorithms.connectivity.BridgeFinder;
import com.myproject.graphite.api.algorithms.interfaces.BridgeAlgorithm;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.BridgeResult;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;

public class BridgeDemo {
    static void main() {
        Graph graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Bridge Detection", graph);
        GraphPrinter.printEdges(graph);

        BridgeAlgorithm algorithm = new BridgeFinder();

        BridgeResult result = algorithm.findBridges(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Every edge is a bridge", graph);
        GraphPrinter.printEdges(graph);

        result = algorithm.findBridges(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .build();
        GraphDemoPrinter.printHeader("No Bridges", graph);
//        GraphPrinter.printEdges(graph);

        result = algorithm.findBridges(graph);
        System.out.println(result.bridges());

        graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(1, 3)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Classical Example", graph);
        GraphPrinter.printEdges(graph);

        result = algorithm.findBridges(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(6)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Disconnected graph", graph);
        GraphPrinter.printEdges(graph);

        result = algorithm.findBridges(graph);
        System.out.println(result);
    }
}
