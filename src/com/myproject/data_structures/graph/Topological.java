package com.myproject.data_structures.graph;

import java.util.*;

public class Topological extends Graph {

    public Topological(int V) {
        super(V);
    }

    @Override // Directed edge
    public void addEdge(int src, int dest) {

        list.get(src).add(new Edge(dest, 1));
    }

    void dfs(int curr, boolean[] vis, Stack<Integer> s) {

        vis[curr] = true;

        for (Edge e : list.get(curr)) {

            int v = e.v;

            if (!vis[v]) {
                dfs(v, vis, s);
            }
        }

        s.push(curr);
    }

    void topoSort() {

        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

        System.out.println();
    }

    void khansAlgo() {

        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[V];

        // calculate indegree
        for (int u = 0; u < V; u++) {

            for (Edge e : list.get(u)) {

                int v = e.v;

                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {

            int curr = q.poll();

            result.add(curr);

            for (Edge e : list.get(curr)) {

                int v = e.v;

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        if (result.size() != V) {
            System.out.println(
                    "Cycle detected");
            return;
        }

        for (Integer x : result) {
            System.out.print(x + " ");
        }

        System.out.println();
    }

    static void main() {

        Topological g = new Topological(6);

        g.addEdge(4, 0);
        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(4, 1);

        g.topoSort();
        g.khansAlgo();
    }
}