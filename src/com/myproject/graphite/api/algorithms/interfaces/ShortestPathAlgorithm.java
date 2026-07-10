package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.result.ShortestPathResult;

public interface ShortestPathAlgorithm {
    ShortestPathResult shortestPath(IGraph graph, int source);
}
