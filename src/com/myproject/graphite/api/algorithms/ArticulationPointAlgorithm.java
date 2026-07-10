package com.myproject.graphite.api.algorithms;

import com.myproject.graphite.api.IGraph;

import java.util.List;

public interface ArticulationPointAlgorithm {
    List<Integer> findArticulationPoints(IGraph graph);
}
