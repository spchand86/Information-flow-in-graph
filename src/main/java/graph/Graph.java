package graph;

import org.graphstream.graph.implementations.SingleGraph;

import java.util.*;

/**
 * Graph implementation
 *
 */
public class Graph  extends SingleGraph {

    private HashMap<Integer, Vertex> vertices;

    /**
     * Create new empty graph
     * @param id the (single) graph id
     */
    public Graph(String id) {
        super(id);
        this.vertices = new HashMap<>();
    }

    /**
     * Add a vertex with the given id number to the graph
     * @param num the vertex id
     */
    public void addVertex(int num) {
        super.addNode(String.valueOf(num));

        if (! vertices.containsKey(num)) {
            Vertex vertex = new Vertex(this, String.valueOf(num));
            vertices.put(num, vertex);
        }
    }

    /**
     * Add an edge from a vertex to another
     * @param from the origin vertex id
     * @param to the destination verted id
     */
    public void addEdge(int from, int to) {
        String edgeId = String.valueOf(from) + "-" + String.valueOf(to);
        super.addEdge(edgeId, String.valueOf(from), String.valueOf(to));

        Vertex start = vertices.get(from);
        if (start != null) {
            Edge edge = new Edge(from, to);
            start.addEdge(edge);
        }
    }

}
