package com.myproject.graphite.api.algorithms.topo;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.TopologicalAlgorithm;
import com.myproject.graphite.exceptions.GraphCycleException;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.result.TopologicalSortResult;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnTopologicalSort extends GraphAlgorithm implements TopologicalAlgorithm {
    @Override
    public TopologicalSortResult sort(IGraph graph) {
        validateGraph(graph);
        requireDirectedGraph(graph);

        int vertices = graph.getVertices();

        int[] indegree = new int[vertices];
//        Step 1:Calculate indegree of every vertex
        for (int u = 0; u < vertices; u++) {
            indegree[u] = 0;
            for (Edge edge : graph.getAdjacencyList().get(u)) {
                indegree[edge.destination()]++;
            }
        }
//        Step 2: Add all vertices with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new LinkedList<>();

//         Step 3: Queue Processing
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (Edge edge : graph.getAdjacencyList().get(u)) {
                indegree[edge.destination()]--;

                if (indegree[edge.destination()] == 0) {
                    queue.add(edge.destination());
                }

            }
        }

//         Step 4: Cycle detection
        if (order.size() != vertices) {
            throw new GraphCycleException();
        }

        return new TopologicalSortResult(order);
    }
}
