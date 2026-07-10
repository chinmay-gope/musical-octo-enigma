package com.myproject.graphite.api.algorithms.traversal;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.TraversalAlgorithm;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.result.TraversalResult;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class BFS extends GraphAlgorithm implements TraversalAlgorithm {
    @Override
    public TraversalResult traverse(IGraph graph, int source) {

        validateGraph(graph);
        validateVertex(graph, source);

        boolean[] visited = createVisitedArray(graph);

        Queue<Integer> queue = new ArrayDeque<>();

        List<Integer> traversalOrder = createTraversalList();

        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            traversalOrder.add(current);

            for (Edge edge : neighbours(graph, current)) {
                int neighbor = edge.destination();

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return new TraversalResult(source, traversalOrder);
    }
}
