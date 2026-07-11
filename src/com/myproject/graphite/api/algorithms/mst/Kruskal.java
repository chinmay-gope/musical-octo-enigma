package com.myproject.graphite.api.algorithms.mst;

import com.myproject.graphite.api.algorithms.GraphAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.api.algorithms.interfaces.MSTAlgorithm;
import com.myproject.graphite.exceptions.validation.GraphDisconnectedException;
import com.myproject.graphite.model.GraphEdge;
import com.myproject.graphite.result.MSTEdge;
import com.myproject.graphite.result.MSTResult;

import java.util.ArrayList;
import java.util.List;

public class Kruskal extends GraphAlgorithm implements MSTAlgorithm {
    @Override
    public MSTResult findMST(IGraph graph, int source) {
        validateGraph(graph);
        requireUndirectedGraph(graph);

        DSU dsu = new DSU(graph.getVertices());
        List<GraphEdge> edges = getAllEdges(graph);
        List<MSTEdge> mst = new ArrayList<>();

        int cost = 0;

        for (GraphEdge edge : edges) {
            int u = edge.source();
            int v = edge.destination();

            if (!dsu.connected(u, v)) {
                dsu.union(u, v);
                mst.add(new MSTEdge(
                        u,
                        v,
                        edge.weight()
                ));
                cost += edge.weight();
            }
        }

        if (mst.size() != graph.getVertices() - 1) {
            throw new GraphDisconnectedException(
                    "Minimum spanning tree requires a connected graph.");
        }

        return new MSTResult(cost, mst);
    }
}
