package com.myproject.data_structures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Edge {
    int v;
    int wt;

    Edge(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}

class Pair implements Comparable<Pair> {
    int node, dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Pair o) {
        return this.dist - o.dist; // Min Heap
    }
}

public class Graph {
    int V;
    List<List<Edge>> adjacencyList;

    public Graph(int V) {
        this.V = V;
        adjacencyList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    /**
     * Adds an undirected weighted edge between two vertices.
     *
     * @param src  source vertex
     * @param dest destination vertex
     *
     *             <p>
     *             This method creates an edge from {@code src} to {@code dest}
     *             and another edge from {@code dest} to {@code src}.
     *             <p>
     *             To create a directed graph, override this method and add
     *             only one edge:
     *             </p>
     *
     *             <pre>
     *                                                                                                 {@code
     *                                                                                                 @Override
     *                                                                                                 public void addEdge(int src, int dest, int wt) {
     *                                                                                                   adjacencyList.get(src).add(new Edge(dest, wt));
     *                                                                                                 }
     *                                                                                                 }
     *                                                                                                 </pre>
     */
    public void addEdge(int src, int dest) {
        addEdge(src, dest, 1);
    }

    /**
     * Adds an undirected weighted edge between two vertices.
     *
     * @param src  source vertex
     * @param dest destination vertex
     * @param wt   weight of the edge
     *
     *             <p>
     *             This method creates an edge from {@code src} to {@code dest}
     *             and another edge from {@code dest} to {@code src}.
     *             <p>
     *             To create a directed graph, override this method and add
     *             only one edge:
     *             </p>
     *
     *             <pre>
     *                                                                                                 {@code
     *                                                                                                 @Override
     *                                                                                                 public void addEdge(int src, int dest, int wt) {
     *                                                                                                   adjacencyList.get(src).add(new Edge(dest, wt));
     *                                                                                                 }
     *                                                                                                 }
     *                                                                                                 </pre>
     */
    public void addEdge(int src, int dest, int wt) {
        adjacencyList.get(src).add(new Edge(dest, wt));
        adjacencyList.get(dest).add(new Edge(src, wt));
    }

    public void printAdjacencyList() {

        for (int i = 0; i < V; i++) {

            System.out.print(i + " : ");

            for (Edge e : adjacencyList.get(i)) {

                System.out.print("(" + e.v + "," + e.wt + ") ");
            }

            System.out.println();
        }
    }

    public void bfs(int src) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];

        vis[src] = true;
        q.offer(src);

        while (!q.isEmpty()) {

            int curr = q.poll();

            System.out.print(curr + " ");

            for (Edge e : adjacencyList.get(curr)) {

                int v = e.v;

                if (!vis[v]) {
                    vis[v] = true;
                    q.offer(v);
                }
            }
        }

        System.out.println();
    }

    public void dfsUtil(int u, boolean[] vis) {

        vis[u] = true;
        System.out.print(u + " ");

        for (Edge e : adjacencyList.get(u)) {

            int v = e.v;

            if (!vis[v]) {
                dfsUtil(v, vis);
            }
        }
    }

    public void dfs(int src) {

        boolean[] vis = new boolean[V];

        dfsUtil(src, vis);

        System.out.println();
    }

    static void main() {

        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

//         g.addEdge(1, 3, 7);
//         g.addEdge(2, 4, 2);

        System.out.print("BFS : ");
        g.bfs(0);

        System.out.print("DFS : ");
        g.dfs(0);

        System.out.println("Adjacency List:");
        g.printAdjacencyList();
    }
}
