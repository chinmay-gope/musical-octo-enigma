package com.myproject.data_structures.graph;


import java.util.ArrayList;
import java.util.List;

public class BellmanFord extends Graph {

    public BellmanFord(int V) {
        super(V);
    }

    @Override // Directed edge
    public void addEdge(int src, int dest, int wt) {
        adjacencyList.get(src).add(new Edge(dest, wt));
    }

    static void bellmanFord(int src, List<List<Edge>> g, int V) {

        List<Integer> dist = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            dist.add(Integer.MAX_VALUE);
        }

        dist.set(src, 0);

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {

            for (int u = 0; u < V; u++) {

                for (Edge e : g.get(u)) {

                    int v = e.v;
                    int wt = e.wt;

                    if (dist.get(u) != Integer.MAX_VALUE &&
                            dist.get(u) + wt < dist.get(v)) {

                        dist.set(v, dist.get(u) + wt);
                    }

                }
            }
        }

        detectNegativeCycle(g, dist);

        System.out.println("Shortest distances from source " + src);

        for (int i = 0; i < V; i++) {
            System.out.println(src + " : " + i + " = " + dist.get(i));
        }
    }

    private static void detectNegativeCycle(List<List<Edge>> g, List<Integer> dist) {
        for (int u = 0; u < g.size(); u++) {

            for (Edge e : g.get(u)) {

                int v = e.v;
                int wt = e.wt;

                if (dist.get(u) != Integer.MAX_VALUE &&
                        dist.get(u) + wt < dist.get(v)) {

                    System.out.println("Negative weight cycle detected");
                    return;
                }
            }
        }

    }

    static void main() {

        BellmanFord g = new BellmanFord(5);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 4);
        g.addEdge(2, 3, 2);
        g.addEdge(1, 2, -4);
        g.addEdge(1, 4, -1);
        g.addEdge(3, 4, 4);

        bellmanFord(0, g.adjacencyList, g.V);
    }
}