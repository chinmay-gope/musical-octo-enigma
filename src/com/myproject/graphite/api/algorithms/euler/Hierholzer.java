package com.myproject.graphite.api.algorithms.euler;

import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.EulerAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.exception.cycle.GraphCycleException;
import com.myproject.graphite.exception.validation.GraphDisconnectedException;
import com.myproject.graphite.factory.EulerType;
import com.myproject.graphite.model.Edge;
import com.myproject.graphite.result.EulerResult;
import com.myproject.graphite.util.GraphUtils;

import java.util.*;

import static com.myproject.graphite.util.GraphUtils.degree;
import static com.myproject.graphite.util.GraphUtils.isConnected;

public class Hierholzer extends GraphAlgorithm implements EulerAlgorithm {


    @Override
    public EulerResult findEulerPath(IGraph graph) {
        validateGraph(graph);
        requireUndirectedGraph(graph);

        if (!isConnected(graph)) {
            throw new GraphDisconnectedException("Euler path requires a connected graph.");
        }

        int odd = countOddVertices(graph);

        if (odd != 0 && odd != 2) {
            throw new GraphCycleException("Graph does not contain an Euler circuit.");
        }

        int start = findStartVertex(graph);

        return new EulerResult(EulerType.PATH, buildEulerTraversal(graph, start));
    }


    @Override
    public EulerResult findEulerCircuit(IGraph graph) {
        validateGraph(graph);
        requireUndirectedGraph(graph);

        if (!isConnected(graph)) {
            throw new GraphDisconnectedException(
                    "Euler circuit requires a connected graph."
            );
        }

        if (countOddVertices(graph) != 0) {
            throw new GraphCycleException(
                    "Graph does not contain an Euler circuit."
            );
        }

        int start = findStartVertex(graph);

        return new EulerResult(
                EulerType.CIRCUIT,
                buildEulerTraversal(graph, start)
        );

    }

    private int countOddVertices(IGraph graph) {
        int odd = 0;

        for (int i = 0; i < graph.getVertices(); i++) {

            if (degree(graph, i) % 2 != 0) {
                odd++;
            }
        }

        return odd;
    }

    private int findStartVertex(IGraph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            if (degree(graph, i) % 2 != 0) {
                return i;
            }

        }

        for (int i = 0; i < graph.getVertices(); i++) {
            if (degree(graph, i) > 0) {
                return i;
            }
        }

        return 0;
    }

    private List<Integer> hierholzer(IGraph graph, int start) {

        IGraph clone = GraphUtils.cloneGraph(graph);

        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.peek();

            Edge edge = GraphUtils.getFirstNeighbour(clone, current);

            if (edge != null) {
                stack.push(edge.destination());

                clone.removeEdge(current, edge.destination());
            } else {
                path.add(stack.pop());
            }
        }

        Collections.reverse(path);
        return path;
    }

    private List<Integer> buildEulerTraversal(
            IGraph graph,
            int start) {

        List<Integer> traversal = hierholzer(graph, start);

        if (traversal.size() != GraphUtils.edgeCount(graph) + 1) {
            throw new GraphCycleException(
                    "Invalid Euler traversal."
            );
        }

        return traversal;
    }
}
