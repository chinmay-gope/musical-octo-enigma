package com.myproject.graphite.result;

import java.util.List;

public record SCCResult(List<List<Integer>> components) {
    private static final String RESET = "\u001B[0m";
    private static final String CYAN_BRIGHT = "\u001B[96m";
    private static final String MAGENTA_BRIGHT = "\u001B[95m";

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
        for (int i = 0; i < components.size(); i++) {
            builder.append(CYAN_BRIGHT)
                    .append("Component ")
                    .append(i + 1)
                    .append(": ")
                    .append(RESET)
                    .append(MAGENTA_BRIGHT)
                    .append(components.get(i))
                    .append(RESET)
                    .append('\n');
        }
        return builder.toString();
    }
}
