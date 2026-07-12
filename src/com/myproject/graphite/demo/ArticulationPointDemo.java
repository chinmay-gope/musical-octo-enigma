package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.connectivity.ArticulationPointFinder;
import com.myproject.graphite.api.algorithms.interfaces.ArticulationPointAlgorithm;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.ArticulationPointResult;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;

public class ArticulationPointDemo {
    static void main() {
        Graph graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Articulation Points Linear Graph", graph);
        GraphPrinter.print(graph);

        ArticulationPointAlgorithm algorithm = new ArticulationPointFinder();

        ArticulationPointResult result = algorithm.findArticulationPoints(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .build();
        GraphDemoPrinter.printHeader("Articulation Points Cycle Graph", graph);
        GraphPrinter.print(graph);
        result = algorithm.findArticulationPoints(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(1, 3)
                .addEdge(3, 4)
                .build();
        GraphDemoPrinter.printHeader("Articulation Points Classic Example", graph);
        GraphPrinter.print(graph);
        result = algorithm.findArticulationPoints(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(0, 3)
                .addEdge(0, 4)
                .build();
        GraphDemoPrinter.printHeader("Articulation Star Graph", graph);
        GraphPrinter.print(graph);
        result = algorithm.findArticulationPoints(graph);
        System.out.println(result);

        graph = GraphBuilder
                .undirected(7)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(3, 4)
                .addEdge(4, 5)
                .addEdge(5, 6)
                .build();
        GraphDemoPrinter.printHeader("Articulation Points Disconnected Graph", graph);
        GraphPrinter.print(graph);
        result = algorithm.findArticulationPoints(graph);
        System.out.println(result);

        graph =  GraphBuilder
                .undirected(8)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(1, 3)
                .addEdge(3, 4)
                .addEdge(4, 5)
                .addEdge(5, 3)
                .addEdge(5, 6)
                .addEdge(6, 7)
                .build();
        GraphDemoPrinter.printHeader("Articulation Points Mixed Graph", graph);
        GraphPrinter.print(graph);
        result = algorithm.findArticulationPoints(graph);
        System.out.println(result);
    }
}
