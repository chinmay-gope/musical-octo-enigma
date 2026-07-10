package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.result.MSTResult;

public interface MSTAlgorithm {
    MSTResult findMST(IGraph graph, int source);
}
