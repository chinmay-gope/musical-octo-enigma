package com.myproject.poc.graphite.api.algorithms.interfaces;

import com.myproject.poc.graphite.result.BridgeResult;

public interface BridgeAlgorithm {
    BridgeResult findBridges(IGraph graph);
}
