package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.result.WeightedEdge;

import java.util.List;

public interface BridgeAlgorithm {
    List<WeightedEdge> findBridges(IGraph graph);
}
