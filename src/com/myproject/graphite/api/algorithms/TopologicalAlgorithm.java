package com.myproject.graphite.api.algorithms;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.result.TopologicalSortResult;

public interface TopologicalAlgorithm {
    TopologicalSortResult sort(IGraph graph);
}
