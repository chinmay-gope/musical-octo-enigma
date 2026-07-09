package com.myproject.graphite.api.algorithm;

import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.WeightedEdge;

import java.util.List;

public interface BridgeAlgorithm {
    List<WeightedEdge> findBridges(Graph graph);
}
