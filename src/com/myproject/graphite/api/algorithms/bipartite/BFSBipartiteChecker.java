package com.myproject.graphite.api.algorithms.bipartite;

import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.BipartiteAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.util.GraphValidator;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSBipartiteChecker
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
                if (!bfs(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(
            IGraph graph,
            int source,
            int[] color) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(source);
        color[source] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Edge edge : neighbours(graph, current)) {
                int neighbour = edge.destination();

                // Not visited yet
                if (color[neighbour] == -1) {
                    // Assign opposite color
                    color[neighbour] = 1 - color[current];
                    queue.offer(neighbour);
                }

                // Already visited and same color
                else if (color[neighbour] == color[current]) {
                    return false;
                }

            }
        }

        return true;
    }
}
