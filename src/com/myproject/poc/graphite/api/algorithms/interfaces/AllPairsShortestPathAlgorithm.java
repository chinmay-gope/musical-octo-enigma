package com.myproject.poc.graphite.api.algorithms.interfaces;

import com.myproject.poc.graphite.result.AllPairsShortestPathResult;

public interface AllPairsShortestPathAlgorithm {
    AllPairsShortestPathResult shortestPaths(IGraph graph);
}
