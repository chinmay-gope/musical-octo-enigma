package com.myproject.graphite.api.algorithms.interfaces;

import java.util.List;

public interface SCCAlgorithm {
    List<List<Integer>> findSCC(IGraph graph);
}
