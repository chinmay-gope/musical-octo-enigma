package com.myproject.poc.graphite.api.algorithms.interfaces;

import com.myproject.poc.graphite.result.MSTResult;

public interface MSTAlgorithm {
    MSTResult findMST(IGraph graph, int source);
}
