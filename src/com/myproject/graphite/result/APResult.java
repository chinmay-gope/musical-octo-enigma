package com.myproject.graphite.result;

import java.util.List;

public record APResult(List<Integer> articulationPoints) {

    public APResult {
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
