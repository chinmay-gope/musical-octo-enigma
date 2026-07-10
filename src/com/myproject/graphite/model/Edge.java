package com.myproject.graphite.model;

public record Edge(int destination, int weight) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge(int destination1, int weight1))) return false;

        return destination == destination1 && weight == weight1;
    }

    @Override
    public String toString() {
        return "(" + destination + ", " + weight + ")";
    }
}
