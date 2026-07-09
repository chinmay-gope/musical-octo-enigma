package com.myproject.data_structures.graph;

import java.util.ArrayList;
import java.util.List;

public class TarjanGraph extends Graph {

    public TarjanGraph(int V) {
        super(V);
    }

    static void findBridgesAndArticulationPoints(List<List<Edge>> graph, int V) {
        boolean[] ap = new boolean[V];
        List<String> bridges = new ArrayList<>();
        GraphUtils.runTarjanDFS(graph, V, ap, bridges);

        System.out.println("\nArticulation Points:");
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println(i);
            }
        }

        System.out.println("\nBridges:");
        for (String b : bridges) {
            System.out.println(b);
        }

    }

    static void main() {

        TarjanGraph g = new TarjanGraph(5);

        g.addEdge(1, 0, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 1);
        g.addEdge(0, 3, 1);
        g.addEdge(3, 4, 1);

        TarjanGraph.findBridgesAndArticulationPoints(g.adjacencyList, g.V);
    }
}
