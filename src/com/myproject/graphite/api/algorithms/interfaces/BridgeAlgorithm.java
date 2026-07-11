package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.result.BridgeResult;

public interface BridgeAlgorithm {
    BridgeResult findBridges(IGraph graph);
}
