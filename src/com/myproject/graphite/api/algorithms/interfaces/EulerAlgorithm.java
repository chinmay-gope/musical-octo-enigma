package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.result.EulerResult;

public interface EulerAlgorithm {
    EulerResult findEulerPath(IGraph graph);

    EulerResult findEulerCircuit(IGraph graph);
}
