package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.result.TraversalResult;

public interface TraversalAlgorithm {
    TraversalResult traverse(IGraph graph, int source);
}
