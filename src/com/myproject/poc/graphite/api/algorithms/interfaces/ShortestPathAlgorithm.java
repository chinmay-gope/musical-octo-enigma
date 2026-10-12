package com.myproject.poc.graphite.api.algorithms.interfaces;

import com.myproject.poc.graphite.result.ShortestPathResult;

public interface ShortestPathAlgorithm {
    ShortestPathResult shortestPath(IGraph graph, int source);
}
