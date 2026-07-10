package com.myproject.graphite.api.algorithms.traversal;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.TraversalAlgorithm;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.result.TraversalResult;

import java.util.ArrayList;
import java.util.List;

public final class DFS extends GraphAlgorithm implements TraversalAlgorithm {

    @Override
    public TraversalResult traverse(IGraph graph, int source) {
        validateGraph(graph);
        validateVertex(graph, source);

        boolean[] visited = createVisitedArray(graph);
        List<Integer> traversalOrder = new ArrayList<>();

        dfs(graph, source, visited, traversalOrder);

        return new TraversalResult(source, traversalOrder);
    }

    private void dfs(IGraph graph,
                     int source,
                     boolean[] visited,
                     List<Integer> traversalOrder) {
        visited[source] = true;
        traversalOrder.add(source);

        for (Edge edge : neighbours(graph, source)) {
            int neighbor = edge.destination();

            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, traversalOrder);
            }
        }
    }
}
