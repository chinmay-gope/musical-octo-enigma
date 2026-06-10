package com.myproject.data_structures.graph;


public class DSU {
    int n;
    int[] par, rank;

    DSU(int n) {
        this.n = n;

        par = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB)
            return;

        // Union by rank
        if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
            rank[parA]++;
        }
    }

    int find(int x) {
        // Path compression
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    void getInfo() {
        for (int i = 0; i < n; i++) {
            System.out.println("Element: " + i + ", Parent: " + par[i] + ", Rank: " + rank[i]);
        }
    }

    static void main() {
        DSU dsu = new DSU(6);

        dsu.union(0, 2);

        System.out.println("Parent of 2: " + dsu.find(2));

        dsu.union(1, 3);
        dsu.union(2, 5);
        dsu.union(0, 3);

        System.out.println("Parent of 2: " + dsu.find(2));

        dsu.union(0, 4);

        dsu.getInfo();
    }
}