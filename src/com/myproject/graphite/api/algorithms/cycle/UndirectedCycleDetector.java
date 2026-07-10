package com.myproject.graphite.api.algorithms.cycle;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.api.algorithms.CycleDetectionAlgorithm;
import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.model.Graph;

public class UndirectedCycleDetector extends GraphAlgorithm implements CycleDetectionAlgorithm {
    @Override
    public boolean hasCycle(IGraph graph) {
        validateGraph(graph);

        boolean[] visited = createVisitedArray(graph);

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasCycle(
            IGraph graph,
            int current,
            int parent,
            boolean[] visited) {
        visited[current] = true;

        for (Edge edge : neighbours(graph, current)) {
            int neighbour = edge.destination();

            if (!visited[neighbour]) {
                if (hasCycle(graph, neighbour, current, visited)) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
