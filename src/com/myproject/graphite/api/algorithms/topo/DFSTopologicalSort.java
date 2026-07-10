package com.myproject.graphite.api.algorithms.topo;

import com.myproject.graphite.api.IGraph;
import com.myproject.graphite.api.algorithms.interfaces.CycleDetectionAlgorithm;
import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.TopologicalAlgorithm;
import com.myproject.graphite.api.algorithms.cycle.DirectedCycleDetector;
import com.myproject.graphite.exceptions.GraphCycleException;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.result.TopologicalSortResult;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DFSTopologicalSort extends GraphAlgorithm implements TopologicalAlgorithm {
    @Override
    public TopologicalSortResult sort(IGraph graph) {
        validateGraph(graph);
        requireDirectedGraph(graph);

        CycleDetectionAlgorithm detector = new DirectedCycleDetector();

        if (detector.hasCycle(graph)) {
            throw new GraphCycleException("Topological sort requires a Directed Acyclic Graph (DAG).");
        }

        boolean[] visited = createVisitedArray(graph);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visited[i]) {
                topo(graph, i, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return new TopologicalSortResult(result);
    }

    private void topo(IGraph graph, int i, boolean[] visited, Deque<Integer> stack) {
        visited[i] = true;
        for (Edge edge : neighbours(graph, i)) {
            int neighbor = edge.destination();
            if (!visited[neighbor]) {
                topo(graph, neighbor, visited, stack);
            }
        }
        stack.push(i);
    }
}
