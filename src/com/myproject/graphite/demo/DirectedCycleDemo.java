package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.CycleDetectionAlgorithm;
import com.myproject.graphite.api.algorithms.cycle.DirectedCycleDetector;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.util.GraphBuilder;

public class DirectedCycleDemo {
    static void main() {
        CycleDetectionAlgorithm detector =
                new DirectedCycleDetector();
        Graph noCycleGraph = GraphBuilder
                .directed(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .build();

        DemoUtils.printHeader("Directed Cycle Detection", noCycleGraph);
        System.out.println(detector.hasCycle(noCycleGraph));

        Graph cycleGraph = GraphBuilder
                .directed(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 1)
                .build();

        DemoUtils.printHeader("Directed Cycle Detection", cycleGraph);
        System.out.println(detector.hasCycle(cycleGraph));
    }
}
