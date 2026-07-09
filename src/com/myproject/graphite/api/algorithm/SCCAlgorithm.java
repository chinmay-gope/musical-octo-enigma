package com.myproject.graphite.api.algorithm;

import com.myproject.graphite.model.Graph;

import java.util.List;

public interface SCCAlgorithm {
    List<List<Integer>> findSCC(Graph graph);
}
