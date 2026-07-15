package com.myproject.graphite.demo.stress;

import com.myproject.graphite.api.algorithms.bipartite.BFSBipartiteChecker;
import com.myproject.graphite.api.algorithms.bipartite.DFSBipartiteChecker;
import com.myproject.graphite.api.algorithms.connectivity.APFinder;
import com.myproject.graphite.api.algorithms.connectivity.BiconnectedComponents;
import com.myproject.graphite.api.algorithms.connectivity.BridgeFinder;
import com.myproject.graphite.api.algorithms.connectivity.Kosaraju;
import com.myproject.graphite.api.algorithms.cycle.DirectedCycleDetector;
import com.myproject.graphite.api.algorithms.cycle.UndirectedCycleDetector;
import com.myproject.graphite.api.algorithms.interfaces.*;
import com.myproject.graphite.api.algorithms.mst.Kruskal;
import com.myproject.graphite.api.algorithms.mst.Prim;
import com.myproject.graphite.api.algorithms.shortestpath.BellmanFord;
import com.myproject.graphite.api.algorithms.shortestpath.Dijkstra;
import com.myproject.graphite.api.algorithms.shortestpath.FloydWarshall;
import com.myproject.graphite.api.algorithms.topo.DFSTopologicalSort;
import com.myproject.graphite.api.algorithms.topo.KahnTopologicalSort;
import com.myproject.graphite.api.algorithms.traversal.BFS;
import com.myproject.graphite.api.algorithms.traversal.DFS;
import com.myproject.graphite.factory.GraphFactory;
import com.myproject.graphite.model.Graph;

import java.util.concurrent.ThreadLocalRandom;

public class StressTestRunner {

    private StressTestRunner() {
    }

    static void main() {
        executeThemAll();
    }


    static void executeThemAll() {
        stressBFS();
        stressDFS();
        stressCycleDetection(); // both dir & un-dir
        stressPrim();
        stressKruskal();
        stressDijkstra();
        stressBellmanFord();
        stressTestTopo();
        stressTestFloydWarshall();
        stressBipartite(); // both bfs &n dfs

        //  sparse, traversal, mst, dense
        stressBiConnected();
        stressBridges();
        stressSCCs();
        stressAP();
    }


    private static void stressBFS() {

        TraversalAlgorithm bfs = new BFS();

        StressRunner.run(
                "BFS Stress Test",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::traversalGraph,
                graph -> bfs.traverse(graph, randomSource(graph))
        );
    }

    private static void stressDFS() {

        TraversalAlgorithm dfs = new DFS();

        StressRunner.run(
                "DFS Stress Test",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::traversalGraph,
                graph -> dfs.traverse(graph, randomSource(graph))
        );
    }

    private static void stressCycleDetection() {

        CycleDetectionAlgorithm cycleDetector = new DirectedCycleDetector();

        StressRunner.run(
                "CycleDetection Stress Test (directed)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::weightedGraph,
                cycleDetector::hasCycle
        );

        cycleDetector = new UndirectedCycleDetector();
        StressRunner.run(
                "CycleDetection Stress Test (un-directed)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::directedGraph,
                cycleDetector::hasCycle
        );
    }

    private static void stressPrim() {
        MSTAlgorithm prim = new Prim();

        StressRunner.run(
                "Prim Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::mstGraph,
                graph -> prim.findMST(graph, randomSource(graph))
        );
    }

    private static void stressKruskal() {
        MSTAlgorithm kruskal = new Kruskal();

        StressRunner.run(
                "Kruskal Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::weightedGraph,
                graph -> kruskal.findMST(graph, randomSource(graph))
        );
    }

    private static void stressDijkstra() {
        ShortestPathAlgorithm dijkstra = new Dijkstra();

        StressRunner.run(
                "Dijkstra Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::weightedGraph,
                graph -> dijkstra.shortestPath(graph, randomSource(graph))
        );
    }

    private static void stressBellmanFord() {
        ShortestPathAlgorithm bellmanFord = new BellmanFord();

        StressRunner.run(
                "BellmanFord Stress Test",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::weightedGraph,
                graph -> bellmanFord.shortestPath(graph, randomSource(graph))
        );
    }

    private static void stressTestFloydWarshall() {
        AllPairsShortestPathAlgorithm floydWarshall = new FloydWarshall();
        StressRunner.run(
                "FloydWarshall Stress Test",
                StressConfig.FLOYD_CONFIG,
                GraphFactory::denseWeightedGraph,
                floydWarshall::shortestPaths
        );
    }

    private static void stressBipartite() {
        BipartiteAlgorithm bipartite = new BFSBipartiteChecker();

        StressRunner.run(
                "Bipartite Stress Test (bfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::weightedGraph,
                bipartite::isBipartite
        );

        bipartite = new DFSBipartiteChecker();
        StressRunner.run(
                "Bipartite Stress Test (dfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::weightedGraph,
                bipartite::isBipartite
        );

    }

    private static void stressTestTopo() {
        TopologicalAlgorithm topo = new DFSTopologicalSort();
        StressRunner.run(
                "Topological Stress Test (dfs)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::dag,
                topo::sort
        );

        topo = new KahnTopologicalSort();
        StressRunner.run(
                "Topological Stress Test (Kahn)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::dag,
                topo::sort
        );

    }

    private static void stressBiConnected() {

        BiconnectedAlgorithm components = new BiconnectedComponents();

        StressRunner.run(
                "Biconnected Components Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::sparseGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::traversalGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::mstGraph,
                components::findBiconnectedComponents
        );

        StressRunner.run(
                "Biconnected Components Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::denseGraph,
                components::findBiconnectedComponents
        );
    }

    private static void stressAP() {
        APAlgorithm finder = new APFinder();

        StressRunner.run(
                "ArticulationPoint Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::sparseGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::traversalGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::mstGraph,
                finder::findArticulationPoints
        );

        StressRunner.run(
                "ArticulationPoint Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::denseGraph,
                finder::findArticulationPoints
        );
    }

    private static void stressBridges() {
        BridgeAlgorithm bridges = new BridgeFinder();

        StressRunner.run(
                "Bridge Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::sparseGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (traversal)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::traversalGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (mst)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::mstGraph,
                bridges::findBridges
        );

        StressRunner.run(
                "Bridge Stress Test (dense)",
                StressConfig.WEIGHTED_CONFIG,
                GraphFactory::denseGraph,
                bridges::findBridges
        );
    }

    private static void stressSCCs() {

        SCCAlgorithm scc = new Kosaraju();

        StressRunner.run(
                "SCC Stress Test (sparse)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::directedSparseGraph,
                scc::findSCCs
        );

        StressRunner.run(
                "SCC Stress Test (dag)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::dag,
                scc::findSCCs
        );

        StressRunner.run(
                "SCC Stress Test (dense)",
                StressConfig.DEFAULT_CONFIG,
                GraphFactory::directedDenseGraph,
                scc::findSCCs
        );
    }

    private static int randomSource(Graph graph) {

        return ThreadLocalRandom.current().nextInt(graph.getVertices());
    }
}
