package com.myproject.graphite.model;

import com.myproject.graphite.factory.GraphType;

public class UnDirectedGraph extends Graph {
    public UnDirectedGraph(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int source, int destination, int weight) {
        validateVertex(source);
        validateVertex(destination);

        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight));
    }

    @Override
    public GraphType getGraphType() {
        return GraphType.UNDIRECTED;
    }
}
