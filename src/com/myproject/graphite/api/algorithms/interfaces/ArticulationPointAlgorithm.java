package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.result.ArticulationPointResult;

public interface ArticulationPointAlgorithm {
    ArticulationPointResult findArticulationPoints(IGraph graph);
}
