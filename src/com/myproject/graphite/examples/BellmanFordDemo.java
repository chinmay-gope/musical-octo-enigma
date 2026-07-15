package com.myproject.graphite.examples;

import com.myproject.graphite.api.algorithms.interfaces.ShortestPathAlgorithm;
import com.myproject.graphite.api.algorithms.shortestpath.BellmanFord;
import com.myproject.graphite.exception.GraphException;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.ShortestPathResult;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;

public class BellmanFordDemo {
    static void main() {
        Graph graph = GraphBuilder
                .directed(4)
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 5)
                .addEdge(1, 2, -2)
                .addEdge(2, 3, 3)
                .addEdge(3, 1, 1)
                .build();

        GraphDemoPrinter.printHeader("BellmanFord Shortest Path", graph);
        GraphPrinter.printEdges(graph);

        ShortestPathAlgorithm algorithm = new BellmanFord();

        ShortestPathResult result = algorithm.shortestPath(graph, 0);
        System.out.println(result);

        try {
            Graph negativeWeightCycle = GraphBuilder
                    .directed(4)
                    .addEdge(0, 1, 1)
                    .addEdge(1, 2, -1)
                    .addEdge(2, 3, -1)
                    .addEdge(3, 1, -1)
                    .build();

            GraphDemoPrinter.printHeader("BellmanFord Shortest Path for negativeWeightCycle", negativeWeightCycle);
            GraphPrinter.printEdges(negativeWeightCycle);

            result = algorithm.shortestPath(negativeWeightCycle, 0);
            System.out.println(result);
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
