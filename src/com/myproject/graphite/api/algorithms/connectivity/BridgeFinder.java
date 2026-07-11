package com.myproject.graphite.api.algorithms.connectivity;

import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.BridgeAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.model.GraphEdge;
import com.myproject.graphite.result.BridgeResult;

import java.util.ArrayList;
import java.util.List;

public class BridgeFinder extends GraphAlgorithm implements BridgeAlgorithm {
    private int time;

    @Override
    public BridgeResult findBridges(IGraph graph) {
        validateGraph(graph);
        requireUndirectedGraph(graph);

        boolean[] visited = createVisitedArray(graph);

        int[] discovery = new int[graph.getVertices()];
        int[] low = new int[graph.getVertices()];

        List<GraphEdge> bridges = new ArrayList<>();

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                dfs(
                        graph,
                        i,
                        -1,
                        visited,
                        discovery,
                        low,
                        bridges
                );
            }
        }
        return new BridgeResult(bridges);
    }

    private void dfs(
            IGraph graph,
            int current,
            int parent,
            boolean[] visited,
            int[] discovery,
            int[] low,
            List<GraphEdge> bridges) {
        visited[current] = true;
        discovery[current] = low[current] = time++;

        for (Edge edge : neighbours(graph, current)) {
            int neighbour = edge.destination();

            if (neighbour == parent) {
                continue;
            }

            if (!visited[neighbour]) {
                dfs(
                        graph,
                        neighbour,
                        current,
                        visited,
                        discovery,
                        low,
                        bridges
                );

                // Update the lowest discovery time reachable.
                low[current] = Math.min(low[current], low[neighbour]);

                // If the neighbor cannot reach an ancestor of current,
                // then current -> neighbor is a bridge.
                if (low[neighbour] > discovery[current]) {
                    bridges.add(new GraphEdge(
                            current,
                            neighbour,
                            edge.weight()
                    ));
                }

            } else {
                // Back edge found.
                low[current] = Math.min(low[current], discovery[neighbour]);
            }
        }
    }
}
