package com.myproject.graphite.api.algorithms;

import com.myproject.graphite.model.Graph;

public interface CycleDetectionAlgorithm {
    boolean hasCycle(Graph graph);
}
