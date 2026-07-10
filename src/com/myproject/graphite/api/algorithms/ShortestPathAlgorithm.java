package com.myproject.graphite.api.algorithms;

import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.ShortestPathResult;

public interface ShortestPathAlgorithm {
    ShortestPathResult shortestPath(Graph graph, int source);
}
