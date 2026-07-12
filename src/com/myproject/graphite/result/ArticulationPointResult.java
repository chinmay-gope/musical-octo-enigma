package com.myproject.graphite.result;

import java.util.List;

public record ArticulationPointResult(List<Integer> articulationPoints) {

    public ArticulationPointResult {
        articulationPoints = List.copyOf(articulationPoints);
    }

    @Override
    public List<Integer> articulationPoints() {
        return List.copyOf(articulationPoints);
    }

    @Override
    public String toString() {
        return ResultColors.CYAN + "Articulation Points: " + ResultColors.RESET +
                ResultColors.MAGENTA + articulationPoints + ResultColors.RESET;
    }
}
