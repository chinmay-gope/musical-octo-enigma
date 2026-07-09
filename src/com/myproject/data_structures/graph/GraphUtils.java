package com.myproject.data_structures.graph;

import java.util.Arrays;
import java.util.List;

public class GraphUtils {
    private static int time;

    static class DFSState {
        int[] disc;
        int[] low;
        int[] parent;
        int time;

        DFSState(int V) {
            disc = new int[V];
            low = new int[V];
            parent = new int[V];

            Arrays.fill(low, -1);
            Arrays.fill(disc, -1);
            Arrays.fill(parent, -1);

            time = 0;
        }
    }

    // Run DFS for articulation points only
    static void runArticulationDFS(List<List<Edge>> graph, int V, boolean[] articulationPoints) {
        DFSState state = new DFSState(V);

        for (int i = 0; i < V; i++) {
            if (state.disc[i] == -1) {
                dfsArticulation(graph, i, state.disc, state.low, state.parent, articulationPoints);
            }
        }
    }

    // Run DFS for articulation points + bridges
    static void runTarjanDFS(List<List<Edge>> graph, int V, boolean[] articulationPoints, List<String> bridges) {
        DFSState state = new DFSState(V);

        for (int i = 0; i < V; i++) {
            if (state.disc[i] == -1) {
                dfsTarjan(graph, i, state.disc, state.low, state.parent, articulationPoints, bridges);
            }
        }
    }

    // DFS for articulation points only
    private static void dfsArticulation(List<List<Edge>> graph, int u, int[] disc, int[] low, int[] parent, boolean[] ap) {
        disc[u] = low[u] = ++time;
        int children = 0;

        for (Edge e : graph.get(u)) {
            int v = e.v;

            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                dfsArticulation(graph, v, disc, low, parent, ap);

                updateArticulation(u, v, disc, low, parent, ap, children);
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // DFS for articulation points + bridges
    private static void dfsTarjan(List<List<Edge>> graph, int u, int[] disc, int[] low, int[] parent,
                                  boolean[] ap, List<String> bridges) {
        disc[u] = low[u] = ++time;
        int children = 0;

        for (Edge e : graph.get(u)) {
            int v = e.v;

            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                dfsTarjan(graph, v, disc, low, parent, ap, bridges);

                updateArticulation(u, v, disc, low, parent, ap, children);

                // Bridge check
                if (low[v] > disc[u]) {
                    bridges.add(u + " - " + v);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // Common articulation point update logic
    private static void updateArticulation(
            int u, int v, int[] disc, int[] low, int[] parent,
            boolean[] ap, int children) {
        low[u] = Math.min(low[u], low[v]);

        if (parent[u] == -1 && children > 1) ap[u] = true;
        if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
    }
}
