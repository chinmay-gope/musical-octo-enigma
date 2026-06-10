package com.myproject.data_structures.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cycle {
    int V;
    List<List<Integer>> list;

    boolean isCycleUtilDFS(int src, boolean[] vis, int parent) {

        vis[src] = true;
        List<Integer> neighbors = list.get(src);

        for (Integer v : neighbors) {
            if (!vis[v]) {
                if (isCycleUtilDFS(v, vis, src)) {
                    return true;
                }
            } else if (v != parent) {
                return true;
            }
        }

        return false;
    }

    boolean isCycleUtilBFS(int src, boolean[] vis) {
        Queue<Integer> Q = new LinkedList<>();
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = -1;
        }

        vis[src] = true;
        Q.offer(src);

        while (!Q.isEmpty()) {
            int current = Q.poll();

            for (int v : list.get(current)) {
                if (!vis[v]) {
                    vis[v] = true;
                    parent[v] = current;
                    Q.offer(v);
                } else if (v != parent[current]) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean isCycleDFS() {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (isCycleUtilDFS(i, vis, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean isCycleBFS() {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (isCycleUtilBFS(i, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    static void main() {

        Cycle g = new Cycle();
        g.V = 5;
        g.list = new LinkedList<>();

        for (int i = 0; i < g.V; i++) {
            g.list.add(new LinkedList<>());
        }

        g.list.get(0).add(1);
        g.list.get(1).add(0);

        g.list.get(1).add(2);
        g.list.get(2).add(1);

        g.list.get(2).add(3);
        g.list.get(3).add(2);

        g.list.get(3).add(4);
        g.list.get(4).add(3);

        // Uncomment the below lines to make the non-graph cyclic
        g.list.get(4).add(1);
        g.list.get(1).add(4);

        System.out.println("Is the graph cyclic? " + g.isCycleDFS() + " (DFS) | " + g.isCycleBFS() + " (BFS)");
    }

}
