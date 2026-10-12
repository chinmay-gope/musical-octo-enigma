package com.myproject.poc.graphite.api.algorithms.interfaces;

import com.myproject.poc.graphite.result.EulerResult;

public interface EulerAlgorithm {
    EulerResult findEulerPath(IGraph graph);

    EulerResult findEulerCircuit(IGraph graph);
}
