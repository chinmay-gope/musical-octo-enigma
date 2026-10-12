package com.myproject.poc.graphite.result;

import com.myproject.poc.graphite.factory.EulerType;

import java.util.List;

public record EulerResult(
        EulerType type,
        List<Integer> traversal) {

    public EulerResult {
        traversal = List.copyOf(traversal);
    }

    @Override
    public List<Integer> traversal() {
        return List.copyOf(traversal);
    }

    @Override
    public String toString() {
        return type + ": " + traversal;
    }
}
