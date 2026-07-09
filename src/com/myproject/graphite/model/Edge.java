package com.myproject.graphite.model;

import java.util.Objects;

public final class Edge {
    private final int destination;
    private final int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge edge)) return false;

        return destination == edge.destination && weight == edge.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, weight);
    }

    @Override
    public String toString() {
        return "(" + destination + ", " + weight + ")";
    }
}
