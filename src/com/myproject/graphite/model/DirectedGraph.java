package com.myproject.graphite.model;

public class DirectedGraph extends Graph {
    public DirectedGraph(int vertices) {
        super(vertices);
    }

    @Override
    public void addEdge(int source, int destination, int weight) {
        validateVertex(source);
        validateVertex(destination);

        adjacencyList.get(source).add(new Edge(destination, weight));
    }
}
