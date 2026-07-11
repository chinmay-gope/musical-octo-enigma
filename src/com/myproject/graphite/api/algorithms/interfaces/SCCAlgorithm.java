package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.result.SCCResult;

public interface SCCAlgorithm {
    SCCResult findSCCs(IGraph graph);
}
