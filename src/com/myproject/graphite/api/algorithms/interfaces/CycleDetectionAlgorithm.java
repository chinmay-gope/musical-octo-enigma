package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.api.IGraph;

public interface CycleDetectionAlgorithm {
    boolean hasCycle(IGraph graph);
}
