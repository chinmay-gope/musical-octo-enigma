package com.myproject.graphite.api.algorithm;

import com.myproject.graphite.model.Graph;

import java.util.List;

public interface ArticulationPointAlgorithm {
    List<Integer> findArticulationPoints(Graph graph);
}
