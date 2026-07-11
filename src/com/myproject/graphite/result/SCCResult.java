package com.myproject.graphite.result;

import java.util.List;

public record SCCResult(List<List<Integer>> components) {
    public SCCResult {
        components = List.copyOf(components);
    }

    @Override
    public List<List<Integer>> components() {
        return components.stream()
                .map(List::copyOf)
                .toList();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
/*
        builder.append("Strongly Connected Components\n");
        builder.append("-----------------------------\n");
*/
        for (int i = 0; i < components.size(); i++) {
            builder.append("Component ")
                    .append(i + 1)
                    .append(": ")
                    .append(components.get(i))
                    .append('\n');
        }
        return builder.toString();
    }
}
