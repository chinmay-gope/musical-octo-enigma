package com.myproject.data_structures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SCC extends TarjanGraph {

    public SCC(int V) {
        super(V);
    }

    @Override
    public void addEdge(int src, int dest) {
        list.get(src).add(new Edge(dest, 1));
    }

    private static void topSort(
            List<List<Edge>> graph,
            int curr,
            boolean[] visited,
            Stack<Integer> stack) {

        visited[curr] = true;

        for (Edge edge : graph.get(curr)) {
            if (!visited[edge.v]) {
                topSort(graph, edge.v, visited, stack);
            }
        }

        stack.push(curr);
    }

    private static void dfs(
            List<List<Edge>> graph,
            int curr,
            boolean[] visited) {

        visited[curr] = true;

        System.out.print(curr + " ");

        for (Edge edge : graph.get(curr)) {
            if (!visited[edge.v]) {
                dfs(graph, edge.v, visited);
            }
        }
    }

    static void kosaraju(List<List<Edge>> graph, int V) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSort(graph, i, visited, stack);
            }
        }

        Graph transpose = new Graph(V);

        for (int i = 0; i < V; i++) {
            transpose.list.set(i, new ArrayList<>());
            visited[i] = false;
        }

        for (int u = 0; u < V; u++) {
            for (Edge edge : graph.get(u)) {
                int v = edge.v;

                // Reverse edge
                transpose.list.get(v).add(new Edge(u, 1));
            }
        }

        while (!stack.isEmpty()) {

            int curr = stack.pop();

            if (!visited[curr]) {
                dfs(transpose.list, curr, visited);
                System.out.println();
            }
        }
    }

    static void main() {

        SCC g = new SCC(8);

        /*
         * SCC 1: 0 -> 1 -> 2 -> 0
         */
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);

        /*
         * SCC 2: 3 -> 4 -> 5 -> 3
         */
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 3);

        /*
         * SCC 3: 6 <-> 7
         */
        g.addEdge(6, 7);
        g.addEdge(7, 6);

        /*
         * Connections between SCCs
         */
        g.addEdge(2, 3);
        g.addEdge(5, 6);

        System.out.println("Strongly Connected Components:");
        kosaraju(g.list, g.V);

        System.out.println();
        findBridgesAndArticulationPoints(g.list, g.V);
    }
}