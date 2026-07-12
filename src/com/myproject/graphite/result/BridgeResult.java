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
            int source = edge.source();
            int destination = edge.destination();
            builder.append(CYAN)
                    .append("Bridge: ")
                    .append(RESET)
                    .append(MAGENTA)
                    .append(source)
                    .append((" -- "))
                    .append(destination)
                    .append(RESET)
                    .append('\n');
        }
        return builder.toString();
    }

}
