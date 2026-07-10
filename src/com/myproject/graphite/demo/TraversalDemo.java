package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.interfaces.TraversalAlgorithm;
import com.myproject.graphite.api.algorithms.traversal.BFS;
import com.myproject.graphite.api.algorithms.traversal.DFS;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.util.GraphBuilder;

public class TraversalDemo {

    static void main() {

        Graph graph = GraphBuilder
                .undirected(7)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(2, 5)
                .addEdge(2, 6)
                .build();

        TraversalAlgorithm bfs = new BFS();
        TraversalAlgorithm dfs = new DFS();

        DemoUtils.printHeader("Breadth First Search", graph);
        System.out.println(bfs.traverse(graph, 0));
        DemoUtils.printFooter();

        System.out.println();

        DemoUtils.printHeader("Depth First Search", graph);
        System.out.println(dfs.traverse(graph, 0));
        DemoUtils.printFooter();
    }
}