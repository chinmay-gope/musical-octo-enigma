package com.myproject.graphite.api.algorithms.shortestpath;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.ShortestPathAlgorithm;
import com.myproject.graphite.exceptions.cycle.NegativeCycleException;
import com.myproject.graphite.model.GraphEdge;
import com.myproject.graphite.result.ShortestPathResult;

import java.util.List;

public class BellmanFord extends GraphAlgorithm implements ShortestPathAlgorithm {
    @Override
    public ShortestPathResult shortestPath(IGraph graph, int source) {
        validateGraph(graph);
        validateVertex(graph, source);

        int[] distance = createDistanceArray(graph);

        distance[source] = 0;

        List<GraphEdge> edges = getAllEdges(graph);

        relaxEdges(edges, distance, graph.getVertices());

        detectNegativeCycle(edges, distance);

        return new ShortestPathResult(source, distance);
    }

    private void relaxEdges(List<GraphEdge> edges,
                            int[] distance,
                            int vertices) {

        for (int i = 1; i < vertices; i++) {
            for (GraphEdge edge : edges) {

                int u = edge.source();
                int v = edge.destination();
                int wt = edge.weight();

                if (distance[u] != Integer.MAX_VALUE &&
                        distance[u] + wt < distance[v]) {

                    distance[v] = distance[u] + wt;
                }
            }
        }
    }

    private void detectNegativeCycle(List<GraphEdge> edges, int[] distance) {
        for (GraphEdge edge : edges) {
            int u = edge.source();
            int v = edge.destination();
            int wt = edge.weight();

            if (distance[u] + wt < distance[v] && distance[u] != Integer.MAX_VALUE) {

                throw new NegativeCycleException();
            }
        }
    }
}
