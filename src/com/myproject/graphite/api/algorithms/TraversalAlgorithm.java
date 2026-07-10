package com.myproject.graphite.api.algorithms;

import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.TraversalResult;

public interface TraversalAlgorithm {
    TraversalResult traverse(Graph graph, int source);
}
