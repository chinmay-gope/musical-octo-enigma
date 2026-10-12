package com.myproject.poc.graphite.api.algorithms.interfaces;

import com.myproject.poc.graphite.result.BiConnectedResult;

public interface BiconnectedAlgorithm {
    BiConnectedResult findBiconnectedComponents(IGraph graph);
}
