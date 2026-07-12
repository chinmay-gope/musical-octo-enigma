package com.myproject.graphite.demo;

import com.myproject.graphite.api.algorithms.connectivity.ArticulationPointFinder;
import com.myproject.graphite.api.algorithms.connectivity.Kosaraju;
import com.myproject.graphite.api.algorithms.interfaces.ArticulationPointAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.SCCAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.ShortestPathAlgorithm;
import com.myproject.graphite.api.algorithms.interfaces.TraversalAlgorithm;
import com.myproject.graphite.api.algorithms.shortestpath.BellmanFord;
import com.myproject.graphite.api.algorithms.shortestpath.Dijkstra;
import com.myproject.graphite.api.algorithms.topo.KahnTopologicalSort;
import com.myproject.graphite.api.algorithms.traversal.BFS;
import com.myproject.graphite.api.algorithms.traversal.DFS;
import com.myproject.graphite.exceptions.GraphException;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.ArticulationPointResult;
import com.myproject.graphite.result.SCCResult;
import com.myproject.graphite.result.ShortestPathResult;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;

public class ZComplexGraphDemo {
    static void main() {
        Graph complexGraph = GraphBuilder
                .directed(10)
                // Negative cycle
                .addEdge(0, 1, 4)
                .addEdge(1, 2, -5)
                .addEdge(2, 0, 2)
                // Zero-weight edge + cycle
                .addEdge(3, 4, 0)
                .addEdge(4, 5, 7)
                .addEdge(5, 3, 1)
                // SCC (6,7,8)
                .addEdge(6, 7, 3)
                .addEdge(7, 8, 2)
                .addEdge(8, 6, 1)
                // Self-loop
                .addEdge(9, 9, 10)
                // Parallel edges
                .addEdge(0, 2, 100)
                .addEdge(0, 2, 1)
                .build();

        GraphDemoPrinter.printHeader("Complex Graph Demo", complexGraph);

        System.out.println(complexGraph.getAdjacencyList());

        System.out.println("Neighbors of 0 : "+complexGraph.getNeighbours(0));
        System.out.println("Neighbors of 1 : "+complexGraph.getNeighbours(1));
        System.out.println("Neighbors of 2 : "+complexGraph.getNeighbours(2));
        System.out.println("Neighbors of 3 : "+complexGraph.getNeighbours(3));
        System.out.println("Neighbors of 4 : "+complexGraph.getNeighbours(4));
        System.out.println("Neighbors of 5 : "+complexGraph.getNeighbours(5));
        System.out.println("Neighbors of 6 : "+complexGraph.getNeighbours(6));
        System.out.println("Neighbors of 7 : "+complexGraph.getNeighbours(7));
        System.out.println("Neighbors of 8 : "+complexGraph.getNeighbours(8));
        System.out.println("Neighbors of 9 : "+complexGraph.getNeighbours(9));

        GraphPrinter.printEdges(complexGraph);

        try {
            TraversalAlgorithm bfs = new BFS();
            TraversalAlgorithm dfs = new DFS();

            GraphDemoPrinter.printHeader("Breadth First Search", complexGraph);
            IO.println(bfs.traverse(complexGraph, 0));
            IO.println(bfs.traverse(complexGraph, 1));
            IO.println(bfs.traverse(complexGraph, 2));
            IO.println(bfs.traverse(complexGraph, 3));
            IO.println(bfs.traverse(complexGraph, 4));
            IO.println(bfs.traverse(complexGraph, 5));
            IO.println(bfs.traverse(complexGraph, 6));
            IO.println(bfs.traverse(complexGraph, 7));
            IO.println(bfs.traverse(complexGraph, 8));
            IO.println(bfs.traverse(complexGraph, 9));

            GraphDemoPrinter.printHeader("Depth First Search", complexGraph);
            IO.println(dfs.traverse(complexGraph, 0));

            IO.println(bfs.traverse(complexGraph, 1));
            IO.println(dfs.traverse(complexGraph, 2));
            IO.println(dfs.traverse(complexGraph, 3));
            IO.println(dfs.traverse(complexGraph, 4));
            IO.println(dfs.traverse(complexGraph, 5));
            IO.println(dfs.traverse(complexGraph, 6));
            IO.println(dfs.traverse(complexGraph, 7));
            IO.println(dfs.traverse(complexGraph, 8));
            IO.println(dfs.traverse(complexGraph, 9));
        } catch (GraphException e) {
            System.err.println(e.getMessage());
        }

        try {
            GraphDemoPrinter.printHeader("Kosaraju SCC", complexGraph);
            SCCAlgorithm alg = new Kosaraju();
            SCCResult scRes = alg.findSCCs(complexGraph);
            IO.println(scRes);
        } catch (GraphException e) {
            System.err.println("Kosaraju Error: " + e.getMessage());
        }

        try {
            GraphDemoPrinter.printHeader("Kahn Topological Sort", complexGraph);

            KahnTopologicalSort algorithm = new KahnTopologicalSort();
            IO.println(algorithm.sort(complexGraph));
        } catch (GraphException e) {
            System.err.println("Kahn Topological Error: " + e.getMessage());
        }

        try {
            ArticulationPointAlgorithm ap = new ArticulationPointFinder();
            ap.findArticulationPoints(complexGraph);
            ArticulationPointResult apRes = ap.findArticulationPoints(complexGraph);
            IO.println(apRes);
        } catch (GraphException e) {
            System.err.println("Articulation Points Error: " + e.getMessage());
        }

        try {
            ShortestPathAlgorithm bellman = new BellmanFord();
            ShortestPathResult spRes = bellman.shortestPath(complexGraph, 0);
            IO.println(spRes);
        } catch (GraphException e) {
            System.err.println("Bellman-Ford Error: " + e.getMessage());
        }

        try {
            ShortestPathAlgorithm dijkstra = new Dijkstra();
            ShortestPathResult spRes2 = dijkstra.shortestPath(complexGraph, 0);
            IO.println(spRes2);
        } catch (GraphException e) {
            System.err.println("Dijkstra Error: " + e.getMessage());
        }
    }
}
