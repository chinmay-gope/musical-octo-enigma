package com.myproject.graphite.api.algorithms.bipartite;

import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.BipartiteAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.util.GraphValidator;

public class DFSBipartiteChecker
        extends GraphAlgorithm
        implements BipartiteAlgorithm {

    @Override
    public boolean isBipartite(IGraph graph) {
        validateGraph(graph);
        requireUndirectedGraph(graph);

        if (GraphValidator.hasSelfLoop(graph)) {
            return false;
        }

        int[] color = createDistanceArray(graph, -1);

        for (int i = 0; i < graph.getVertices(); i++) {
            if (color[i] == -1) {
                if (dfs(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(
            IGraph graph,
            int current,
            int[] color) {

        for (Edge edge : neighbours(graph, current)) {

            int neighbour = edge.destination();

            if (color[neighbour] == -1) {

                color[neighbour] = 1 - color[current];

                if (dfs(graph, neighbour, color)) {
                    return true;
                }
            } else if (color[neighbour] == color[current]) {
                return true;
            }
        }

        return false;
    }
}
