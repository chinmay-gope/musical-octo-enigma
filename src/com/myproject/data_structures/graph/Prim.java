package com.myproject.data_structures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim extends Graph {

    public Prim(int V) {
        super(V);
    }

    public static int primMST(int V, Graph G) {

        List<Boolean> inMST = new ArrayList<>();
        List<List<Edge>> list = G.list;

        for (int i = 0; i < V; i++) {
            inMST.add(false);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int mstCost = 0;

        // Start from node 0
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int u = curr.node;

            if (inMST.get(u)) continue;

            inMST.set(u, true);

            mstCost += curr.dist;

            for (Edge e : list.get(u)) {

                int v = e.v;
                int wt = e.wt;

                if (!inMST.get(v)) {
                    pq.add(new Pair(v, wt));
                }
            }
        }

        return mstCost;
    }

    static void main() {

        Prim g = new Prim(4);

        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 15);
        g.addEdge(0, 3, 30);
        g.addEdge(1, 3, 40);
        g.addEdge(2, 3, 50);

        System.out.println("MST Cost = " + primMST(g.V, g));
    }
}