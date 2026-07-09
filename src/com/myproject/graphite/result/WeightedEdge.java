package com.myproject.graphite.result;

public record WeightedEdge(int source, int destination, int weight) {

    @Override
    public String toString() {
        return source + " -> " + destination + " (" + weight + ")";
    }
}
