package com.myproject.graphite.result;

import java.util.Objects;

public record ShortestPathResult(int source, int[] distance) {

    public ShortestPathResult {
        Objects.requireNonNull(distance, "distance cannot be null");
        distance = distance.clone();
    }

    @Override
    public int[] distance() {
        return distance.clone();
    }
}