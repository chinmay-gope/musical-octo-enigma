package com.myproject.graphite.api;

import com.myproject.graphite.model.Edge;

import java.util.List;

public interface IGraph {

    void addEdge(int source, int destination);

    void addEdge(int source, int destination, int weight);

    List<Edge> getNeighbours(int vertex);

    List<List<Edge>> getAdjacencyList();

    int getVertices();

    boolean isEmpty();
}