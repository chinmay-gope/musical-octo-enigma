package com.myproject.graphite.model;

public class Pair implements Comparable<Pair> {

    private final int vertex;
    private final int cost;

    public Pair(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() {
        return vertex;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(cost, other.cost);
    }
}
