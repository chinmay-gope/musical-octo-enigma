package com.myproject.graphite.api.algorithms;

import com.myproject.graphite.model.Graph;

import java.util.List;

public interface TopologicalAlgorithm {
    List<Integer> sort(Graph graph);
}
