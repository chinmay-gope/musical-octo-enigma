package com.myproject.graphite.api.algorithm;

import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.MSTResult;

public interface MSTAlgorithm {
    MSTResult findMST(Graph graph, int source);
}
