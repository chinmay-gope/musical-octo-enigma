package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.topo.DFSTopologicalSort;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;

public class TopologicalDemo {
    static void main() {
        Graph graph = GraphBuilder
                .directed(6)
                .addEdge(5, 2)
                .addEdge(5, 0)
                .addEdge(4, 0)
                .addEdge(4, 1)
                .addEdge(2, 3)
                .addEdge(3, 1)
                .build();

        GraphPrinter.print(graph);

        DemoUtils.printHeader("DFS Topological Sort", graph);

        DFSTopologicalSort algorithm = new DFSTopologicalSort();
        System.out.println(algorithm.sort(graph));

        DemoUtils.printFooter();

        Graph cyclic = GraphBuilder
                .directed(3)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .build();

        GraphPrinter.print(cyclic);

        DemoUtils.printHeader("DFS Topological Sort With Cycle", cyclic);
        System.out.println(algorithm.sort(cyclic));
    }
}
