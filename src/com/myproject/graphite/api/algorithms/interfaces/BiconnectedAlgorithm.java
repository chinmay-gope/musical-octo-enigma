package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.result.BiConnectedResult;

public interface BiconnectedAlgorithm {
    BiConnectedResult findBiconnectedComponents(IGraph graph);
}
