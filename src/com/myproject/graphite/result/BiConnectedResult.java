package com.myproject.graphite.result;

import com.myproject.graphite.model.GraphEdge;

import java.util.List;

import static com.myproject.graphite.result.ResultColors.*;

public record BiConnectedResult(
        List<List<GraphEdge>> components,
        int componentCount
) {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(BOLD)
                .append(CYAN)
                .append("========== BICONNECTED COMPONENTS ==========\n")
                .append(RESET);

        sb.append(GREEN)
                .append("Total Components : ")
                .append(componentCount)
                .append(RESET)
                .append("\n\n");

        for (int i = 0; i < components.size(); i++) {

            sb.append(YELLOW)
                    .append("BCC ")
                    .append(i + 1)
                    .append(":")
                    .append(RESET)
                    .append("\n");

            for (GraphEdge edge : components.get(i)) {
                sb.append("  ")
                        .append(MAGENTA)
                        .append(edge.source())
                        .append(" ──(")
                        .append(edge.weight())
                        .append(")── ")
                        .append(edge.destination())
                        .append(RESET)
                        .append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
