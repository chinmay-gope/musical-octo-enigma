package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.CycleDetectionAlgorithm;
import com.myproject.graphite.api.algorithms.cycle.UndirectedCycleDetector;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.util.GraphBuilder;

public class UndirectedCycleDemo {
    static void main() {
        CycleDetectionAlgorithm detector =
                new UndirectedCycleDetector();
        Graph noCycleGraph = GraphBuilder
                .undirected(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();

        DemoUtils.printHeader("Undirected Cycle Detection", noCycleGraph);
        System.out.println(detector.hasCycle(noCycleGraph));

        Graph cycleGraph = GraphBuilder
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .build();

        DemoUtils.printHeader("Undirected Cycle Detection", cycleGraph);
        System.out.println(detector.hasCycle(cycleGraph));
    }
}
