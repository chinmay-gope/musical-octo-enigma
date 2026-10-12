package com.myproject.poc.graphite.examples;

import com.myproject.poc.graphite.api.algorithms.cycle.DirectedCycleDetector;
import com.myproject.poc.graphite.api.algorithms.interfaces.CycleDetectionAlgorithm;
import com.myproject.poc.graphite.model.Graph;
import com.myproject.poc.graphite.util.GraphBuilder;

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

        GraphDemoPrinter.printHeader("Directed Cycle Detection", noCycleGraph);
        System.out.println(detector.hasCycle(noCycleGraph));

        Graph cycleGraph = GraphBuilder
                .directed(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 1)
                .build();

        GraphDemoPrinter.printHeader("Directed Cycle Detection", cycleGraph);
        System.out.println(detector.hasCycle(cycleGraph));
    }
}
