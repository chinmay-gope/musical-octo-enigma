package com.myproject.data_structures.graph;

import java.util.List;

public class ArticulationPoint {

    static void getArticulationPoints(List<List<Edge>> graph, int V) {
        boolean[] ap = new boolean[V];
        GraphUtils.runArticulationDFS(graph, V, ap);

        System.out.println("Articulation Points:");
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println(i);
            }
        }
    }

    static void main() {

        Graph g = new Graph(5);

        g.addEdge(1, 0, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 1);
        g.addEdge(0, 3, 1);
        g.addEdge(3, 4, 1);

        getArticulationPoints(g.adjacencyList, g.V);
    }
}