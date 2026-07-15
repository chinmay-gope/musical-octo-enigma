package com.myproject.graphite.result;

import java.util.List;

public record MSTResult(int cost, List<MSTEdge> edges) {
    public MSTResult {
        edges = List.copyOf(edges);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(ResultColors.CYAN)
                .append("═══════════════ Minimum Spanning Tree ═══════════════")
                .append(ResultColors.RESET)
                .append('\n');

        builder.append("Total Cost : ")
                .append(ResultColors.GREEN)
                .append(cost)
                .append(ResultColors.RESET)
                .append('\n');

        builder.append("Edges")
                .append(ResultColors.MAGENTA)
                .append(" (")
                .append(edges.size())
                .append(")")
                .append(ResultColors.RESET)
                .append('\n');


        if (!edges.isEmpty()) {
            int maxWeightWidth = edges.stream()
                    .map(MSTEdge::weight)
                    .map(String::valueOf)
                    .mapToInt(String::length)
                    .max()
                    .orElse(1);

            builder
                    .append("─────────────────────────────────────────────────────")
                    .append('\n');

            for (MSTEdge edge : edges) {
                builder.append("  ")
                        .append(ResultColors.YELLOW)
                        .append("• ")
                        .append(String.format(
                                "%d ──(%" + maxWeightWidth + "d)──> %d",
                                edge.source(),
                                edge.weight(),
                                edge.destination())
                        )
                        .append(ResultColors.RESET)
                        .append('\n');
            }
            builder.append("─────────────────────────────────────────────────────");
        }

        return builder.toString();
    }
}
