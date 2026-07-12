package com.myproject.graphite.api.algorithms.shortestpath;

import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.api.algorithms.interfaces.ShortestPathAlgorithm;
import com.myproject.graphite.exceptions.validation.NegativeWeightException;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.model.VertexCost;
import com.myproject.graphite.result.ShortestPathResult;
import com.myproject.graphite.util.GraphValidator;

import java.util.PriorityQueue;

public class Dijkstra extends GraphAlgorithm implements ShortestPathAlgorithm {
    @Override
    public ShortestPathResult shortestPath(IGraph graph, int source) {
        validateGraph(graph);
        validateVertex(graph, source);

        if (GraphValidator.hasNegativeEdges(graph)) {
            throw new NegativeWeightException("Dijkstra cannot be applied to graphs with negative edge weights.");
        }

        int[] distance = createDistanceArray(graph);
        distance[source] = 0;

        PriorityQueue<VertexCost> queue = new PriorityQueue<>();

        queue.offer(new VertexCost(source, 0));

        while (!queue.isEmpty()) {
            VertexCost current = queue.poll();

            int u = current.vertex();

            /*
             *   Java's PriorityQueue doesn't support decrease-key.
             *   Instead of updating an existing entry, a new one is added.
             *   Ignore stale entries whose cost is no longer optimal.
             */
            if (current.cost() > distance[u]) {
                continue;
            }

            for (Edge edge : neighbours(graph, u)) {
                int v = edge.destination();
                int wt = edge.weight();

                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;

                    queue.offer(new VertexCost(v, distance[v]));
                }
            }
        }

        return new ShortestPathResult(source, distance);
    }
}
