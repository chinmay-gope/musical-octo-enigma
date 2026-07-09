package com.myproject.graphite.factory;

import com.myproject.graphite.model.DirectedGraph;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.model.UnDirectedGraph;

public final class GraphFactory {
    private GraphFactory() {
    }

    public static Graph create(GraphType type, int vertices) {
        return switch (type) {

            case DIRECTED -> new DirectedGraph(vertices);

            case UNDIRECTED -> new UnDirectedGraph(vertices);
        };
    }
}
