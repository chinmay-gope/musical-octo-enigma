package com.myproject.poc.graphite.api.algorithms.interfaces;

import com.myproject.poc.graphite.result.TopologicalSortResult;

public interface TopologicalAlgorithm {
    TopologicalSortResult sort(IGraph graph);
}
