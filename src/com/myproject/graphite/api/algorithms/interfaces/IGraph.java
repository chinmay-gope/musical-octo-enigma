package com.myproject.graphite.api.algorithms.interfaces;

import com.myproject.graphite.factory.GraphType;
import com.myproject.graphite.model.Edge;

import java.util.List;

public interface IGraph {

    void addEdge(int source, int destination);

    void addEdge(int source, int destination, int weight);

    List<Edge> getNeighbours(int vertex);

    List<List<Edge>> getAdjacencyList();

    int getVertices();

    boolean isEmpty();

    GraphType getGraphType();
}