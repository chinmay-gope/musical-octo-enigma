package com.myproject.poc.graphite.api.algorithms.interfaces;

import com.myproject.poc.graphite.result.APResult;

public interface APAlgorithm {
    APResult findArticulationPoints(IGraph graph);
}
