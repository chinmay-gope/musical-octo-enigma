package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.result.AllPairsShortestPathResult;

public interface AllPairsShortestPathAlgorithm {
    AllPairsShortestPathResult shortestPaths(IGraph graph);
}
