package com.myproject.data_structures.graph;

import java.util.Arrays;
import java.util.List;

public class ArticulationPoint {

    static int time;

    static void dfs(
            List<List<Edge>> graph,
            int u,
            int[] disc,
            int[] low,
            int[] parent,
            boolean[] ap) {

        disc[u] = low[u] = ++time;

        int children = 0;

        for (Edge edge : graph.get(u)) {

            int v = edge.v;

            // Tree edge
            if (disc[v] == -1) {

                children++;
                parent[v] = u;

                dfs(graph, v, disc, low, parent, ap);

                // Update low value
                low[u] = Math.min(low[u], low[v]);

                // Case 1: root with multiple children
                if (parent[u] == -1 && children > 1) {
                    ap[u] = true;
                }

                // Case 2: non-root node disconnects subtree
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    ap[u] = true;
                }

            }
            // Back edge
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static void getArticulationPoints(List<List<Edge>> graph, int V) {

        time = 0;

        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(graph, i, disc, low, parent, ap);
            }
        }

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