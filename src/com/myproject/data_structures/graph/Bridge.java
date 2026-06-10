package com.myproject.data_structures.graph;

import java.util.Arrays;
import java.util.List;

public class Bridge {

    static int time;

    static void dfs(
            List<List<Edge>> graph,
            int u,
            int[] disc,
            int[] low,
            int[] parent) {

        disc[u] = low[u] = ++time;

        for (Edge edge : graph.get(u)) {

            int v = edge.v;

            // Tree edge
            if (disc[v] == -1) {

                parent[v] = u;

                dfs(graph, v, disc, low, parent);

                low[u] = Math.min(low[u], low[v]);

                // Bridge condition
                if (low[v] > disc[u]) {
                    System.out.println(u + " -- " + v);
                }

            }
            // Back edge
            else if (v != parent[u]) {

                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static void getBridges(List<List<Edge>> graph, int V) {

        time = 0;

        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        System.out.println("Bridges:");

        for (int i = 0; i < V; i++) {

            if (disc[i] == -1) {
                dfs(graph, i, disc, low, parent);
            }
        }
    }

    static void main() {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);

        getBridges(g.list, g.V);
    }
}