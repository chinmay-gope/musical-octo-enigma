package com.myproject.graphite.result;

import com.myproject.graphite.model.GraphEdge;

import java.util.List;

import static com.myproject.graphite.result.ResultColors.*;

public record BridgeResult(List<GraphEdge> bridges) {
    public BridgeResult {
        bridges = List.copyOf(bridges);
    }

    @Override
    public List<GraphEdge> bridges() {
        return List.copyOf(bridges);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (GraphEdge edge : bridges) {
            builder.append(CYAN_BRIGHT)
                    .append("Bridge: ")
                    .append(RESET)
                    .append(MAGENTA_BRIGHT)
                    .append(edge)
                    .append(RESET)
                    .append('\n');
        }
        return builder.toString();
    }

}
