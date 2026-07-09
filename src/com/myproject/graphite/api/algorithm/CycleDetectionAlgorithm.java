package com.myproject.graphite.api.algorithm;

import com.myproject.graphite.model.Graph;

public interface CycleDetectionAlgorithm {
    boolean hasCycle(Graph graph);
}
