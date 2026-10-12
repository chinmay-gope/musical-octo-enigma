package com.myproject.poc.graphite.api.algorithms.interfaces;

import com.myproject.poc.graphite.result.SCCResult;

public interface SCCAlgorithm {
    SCCResult findSCCs(IGraph graph);
}
