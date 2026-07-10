package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.interfaces.ShortestPathAlgorithm;
import com.myproject.graphite.api.algorithms.shortestpath.Dijkstra;
import com.myproject.graphite.exceptions.GraphException;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.ShortestPathResult;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;

public class DijkstraDemo {
    static void main() {
        Graph graph = GraphBuilder
                .directed(6)
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 2)
                .addEdge(1, 2, 5)
                .addEdge(1, 3, 10)
                .addEdge(2, 4, 3)
                .addEdge(4, 3, 4)
                .addEdge(3, 5, 11)
                .build();

        GraphPrinter.print(graph);
        DemoUtils.printHeader("Dijkstra Shortest Path", graph);

        ShortestPathAlgorithm algorithm = new Dijkstra();

        ShortestPathResult result = algorithm.shortestPath(graph, 0);
        System.out.println(result);

        DemoUtils.printFooter();

        Graph unreachableVertex = GraphBuilder
                .directed(7)
                .addEdge(0, 1, 4)
                .addEdge(0, 2, 2)
                .addEdge(2, 4, 3)
                .addEdge(4, 3, 4)
                .build();

        GraphPrinter.print(unreachableVertex);
        DemoUtils.printHeader("Dijkstra Shortest Path for Unreachable Vertex", unreachableVertex);

        result = algorithm.shortestPath(unreachableVertex, 0);
        System.out.println(result);

        try {
            Graph g = GraphBuilder
                    .directed(3)
                    .addEdge(0, 2, -2)
                    .build();

            DemoUtils.printHeader("Dijkstra Shortest Path for Negative Weight", g);

            result = algorithm.shortestPath(g, 0);
            System.out.println(result);
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }
    }
}
