package com.myproject.graphite.model;

import com.myproject.graphite.api.algorithms.interfaces.IGraph;
import com.myproject.graphite.exception.validation.InvalidVertexException;
import com.myproject.graphite.factory.GraphType;
import com.myproject.graphite.util.GraphUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Graph implements IGraph {

    protected final int vertices;
    protected final List<List<Edge>> adjacencyList;
    protected int edgeCount;
    public static final int UNDIRECTED_GRAPH_DEFAULT_WEIGHT = 1;

    protected Graph(int vertices) {
        this.vertices = vertices;

        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    protected void validateVertex(int vertex) {
        if (vertex < 0 || vertex >= vertices) {
            throw new InvalidVertexException(vertex);
        }
    }

    @Override
    public void addEdge(int source, int destination) {
        addEdge(source, destination, UNDIRECTED_GRAPH_DEFAULT_WEIGHT);
        edgeCount++;
    }

    @Override
    public abstract void addEdge(int source, int destination, int weight);

    @Override
    public abstract GraphType getGraphType();

    @Override
    public List<Edge> getNeighbours(int vertex) {
        validateVertex(vertex);
        return Collections.unmodifiableList(adjacencyList.get(vertex));
    }

    @Override
    public List<List<Edge>> getAdjacencyList() {
        return Collections.unmodifiableList(adjacencyList);
    }

    @Override
    public int getVertices() {
        return vertices;
    }

    @Override
    public int edgeCount() {
        return edgeCount;
    }

    @Override
    public boolean isEmpty() {
        return vertices == 0;
    }

    @Override
    public IGraph transpose(IGraph graph) {
        return GraphUtils.transpose(graph);
    }
}
