package com.myproject.data_structures.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KEdge implements Comparable<KEdge> {
    int src, dest, wt;

    KEdge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    @Override // ASCENDING ORDER
    public int compareTo(KEdge other) {
        return this.wt - other.wt;
    }
}

public class Kruskal {

    static void kruskal(int V, List<KEdge> edges) {

        Collections.sort(edges);

        DSU dsu = new DSU(V);

        int mstCost = 0;
        List<KEdge> mst = new ArrayList<>();

        for (KEdge e : edges) {

            int u = e.src;
            int v = e.dest;

            if (dsu.find(u) != dsu.find(v)) {

                dsu.union(u, v);

                mst.add(e);
                mstCost += e.wt;
            }
        }

        System.out.println("MST Cost = " + mstCost);

        System.out.println("edges in MST:");

        for (KEdge e : mst) {
            System.out.println(e.src + " -> " + e.dest + " : " + e.wt);
        }
    }

    static void main() {

        int V = 4;

        List<KEdge> edges = new ArrayList<>();

        edges.add(new KEdge(0, 1, 10));
        edges.add(new KEdge(0, 2, 6));
        edges.add(new KEdge(0, 3, 5));
        edges.add(new KEdge(1, 3, 15));
        edges.add(new KEdge(2, 3, 4));

        kruskal(V, edges);
    }
}