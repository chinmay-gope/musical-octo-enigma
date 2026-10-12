package com.myproject.poc.graphite.api.algorithms.interfaces;

import com.myproject.poc.graphite.result.TraversalResult;

public interface TraversalAlgorithm {
    TraversalResult traverse(IGraph graph, int source);
}
