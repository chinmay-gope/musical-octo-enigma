package com.myproject.graphite.examples;

import com.myproject.graphite.api.algorithms.bipartite.BFSBipartiteChecker;
import com.myproject.graphite.api.algorithms.bipartite.DFSBipartiteChecker;
import com.myproject.graphite.api.algorithms.interfaces.BipartiteAlgorithm;
import com.myproject.graphite.model.Graph;
import com.myproject.graphite.result.ResultColors;
import com.myproject.graphite.util.GraphBuilder;
import com.myproject.graphite.util.GraphPrinter;
import com.myproject.graphite.util.GraphValidator;

public class BipartiteDemo {
    static void main() {
        Graph graph = GraphBuilder
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .build();

        GraphDemoPrinter.printHeader("Bipartite Even Cycle", graph);
        GraphPrinter.print(graph);

        BipartiteAlgorithm bfsBipartiteChecker = new BFSBipartiteChecker();
        BipartiteAlgorithm dfsBipartiteChecker = new DFSBipartiteChecker();

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);


        graph = GraphBuilder
                .undirected(3)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .build();
        GraphDemoPrinter.printHeader("Bipartite Odd Cycle", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(2)
                .addEdge(0, 0)
                .addEdge(0, 1)
                .build();
        GraphDemoPrinter.printHeader("SelfLoop", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(6)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(2, 5)
                .build();
        GraphDemoPrinter.printHeader("Bipartite Tree", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(0, 3)
                .addEdge(1, 2)
                .addEdge(1, 3)
                .addEdge(2, 3)
                .build();
        GraphDemoPrinter.printHeader("Bipartite K4", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(6)
                .addEdge(0, 1)
                .addEdge(2, 3)
                .addEdge(4, 5)
                .build();
        GraphDemoPrinter.printHeader("Disconnected Bipartite", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(7)
                .addEdge(0, 1)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .addEdge(4, 2)
                .addEdge(5, 6)
                .build();
        GraphDemoPrinter.printHeader("Disconnected (One Bad Component)", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(4)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 0)
                .addEdge(0, 2)
                .build();
        GraphDemoPrinter.printHeader("Square With Diagonal", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);

        graph = GraphBuilder
                .undirected(9)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(3, 4)
                .addEdge(4, 5)
                .addEdge(6, 7)
                .addEdge(7, 8)
                .addEdge(0, 3)
                .addEdge(3, 6)
                .addEdge(1, 4)
                .addEdge(4, 7)
                .addEdge(2, 5)
                .addEdge(5, 8)
                .build();
        GraphDemoPrinter.printHeader("Large Grid", graph);
        GraphPrinter.print(graph);

        checkIsBipartite(graph, dfsBipartiteChecker, bfsBipartiteChecker);
    }

    private static String colorizeResult(boolean isBipartite, Graph graph) {
        if (GraphValidator.hasSelfLoop(graph)) {
            return ResultColors.YELLOW + "self-loop detected" + ResultColors.RESET;
        }
        if (!isBipartite) {
            return ResultColors.RED + "false" + ResultColors.RESET;
        }
        return ResultColors.GREEN + "true" + ResultColors.RESET;
    }

    private static void checkIsBipartite(Graph graph,
                                         BipartiteAlgorithm dfsChecker,
                                         BipartiteAlgorithm bfsChecker) {
        boolean dfsResult = dfsChecker.isBipartite(graph);
        boolean bfsResult = bfsChecker.isBipartite(graph);
        System.out.println("isBipartite (dfs): " + colorizeResult(dfsResult, graph));
        System.out.println("isBipartite (bfs): " + colorizeResult(bfsResult, graph));
    }

}
