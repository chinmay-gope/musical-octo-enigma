package com.myproject.graphite.demo;

import com.myproject.graphite.generator.RandomGraphGenerator;
import com.myproject.graphite.model.Graph;

public class RandomGraphGeneratorDemo {

    static void main() {

        for (int i = 1; i <= 100; i++) {

            Graph graph = RandomGraphGenerator
                    .directed()
                    .vertices(100)
                    .edges(300)
                    .connected(true)
                    .build();

            System.out.printf(
                    "Generated graph %3d : %d vertices %d edges%n",
                    i,
                    graph.getVertices(),
                    graph.edgeCount()
            );
        }
    }
}
