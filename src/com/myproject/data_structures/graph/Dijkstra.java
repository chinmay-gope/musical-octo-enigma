package com.myproject.data_structures.graph;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra extends Graph {

    public Dijkstra(int V) {
        super(V);
    }

    static void dijkstra(int src, List<List<Edge>> g, int V) {

        List<Integer> dist = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            dist.add(Integer.MAX_VALUE);
        }

        dist.set(src, 0);

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int u = curr.node;

            for (Edge edge : g.get(u)) {

                int v = edge.v;
                int wt = edge.wt;

                if (dist.get(u) + wt < dist.get(v)) {

                    dist.set(v, dist.get(u) + wt);

                    pq.add(new Pair(v, dist.get(v)));
                }
            }
        }

        System.out.println("Shortest distances from source " + src);

        for (int i = 0; i < V; i++) {
            System.out.println(src + " : " + i + " = " + dist.get(i));
        }
    }

    static void main() {

        Dijkstra g = new Dijkstra(6);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 3, 7);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 4, 3);
        g.addEdge(4, 3, 2);
        g.addEdge(3, 5, 1);
        g.addEdge(4, 5, 1);

        System.out.println("Adjacency List:");
        g.printAdjacencyList();

        dijkstra(0, g.adjacencyList, g.V);
    }
}