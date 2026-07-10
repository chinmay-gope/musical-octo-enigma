package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.result.TopologicalSortResult;

public interface TopologicalAlgorithm {
    TopologicalSortResult sort(IGraph graph);
}
