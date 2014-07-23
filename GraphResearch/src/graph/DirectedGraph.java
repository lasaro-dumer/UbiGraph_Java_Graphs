/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.ListModel;
import org.ubiety.ubigraph.UbigraphClient;

/**
 *
 * @author coc-dell-u14
 */
public class DirectedGraph {

    private List<Node> nodes;
    private List<Edge> edges;
    private List<Node> finals;
    private Stack<String> pilha;

    public DirectedGraph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.finals = new ArrayList<>();
    }

    public void addNode(Node n) {
        nodes.add(n);
    }

    public void checkFinal(Node n) {
        if (!nodes.contains(n)) {
            addNode(n);
        }
        finals.add(n);
        n.setShape(NodeShape.TORUS);
    }

    public void addEdge(Edge e) {
        if (!nodes.contains(e.getNodeA())) {
            addNode(e.getNodeA());
        }
        if (!nodes.contains(e.getNodeB())) {
            addNode(e.getNodeB());
        }
        edges.add(e);
    }

    public void addEdge(Node nA, Node nB) {
        Edge e = new Edge(nA, nB);
        addEdge(e);
    }

    /**
     * @return the nodes
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * @return the edges
     */
    public List<Edge> getEdges() {
        return edges;
    }

    public void writeAt(UbigraphClient graph, long miliseconds) throws InterruptedException {
        graph.clear();

        for (Node node : nodes) {
            Thread.sleep(miliseconds);
            node.setDrawArea(graph);
            node.draw();
        }

        for (Edge edge : edges) {
            Thread.sleep(miliseconds);
            edge.setDrawArea(graph);
            edge.draw();
        }
    }

    public void writeDFSAt(UbigraphClient graph, long miliseconds, boolean avoidCycles) throws InterruptedException {
        writeAt(graph, 0);
        if (nodes.size() > 0) {
            pilha = new Stack<>();
            DFS(graph, nodes.get(0), miliseconds, avoidCycles);
        }
    }

    private void DFS(UbigraphClient G, Node v, long miliseconds, boolean avoidCycles) throws InterruptedException {
        List<Edge> vEdges;
        //System.out.println("Node: " + v.getName());
        if (finals.contains(v)) {
            System.out.println("Final: " + v.getName() + " Input: " + printStack(pilha));
        }

        if (v != null) {
            //System.out.println("v in : " + v.getName());
            v.promote();
            G.setVertexAttribute(v.getIndex(), "color", v.getColor());
            //v.Check();
            Thread.sleep(miliseconds);

            vEdges = allEdgesFrom(v);
            for (Edge edge : vEdges) {
                Node w = edge.getNodeB();
                if (!(edge.isChecked() && avoidCycles)) {
                    edge.Check();
                    if (!w.isChecked()) {
                        pilha.push(edge.getInput());
                        DFS(G, w, miliseconds, avoidCycles);
                        pilha.pop();
                    }
                    edge.Unheck();
                }
            }
            //System.out.println("v out : " + v.getName());
            v.demote();
            G.setVertexAttribute(v.getIndex(), "color", v.getColor());
        }
    }

    private List<Edge> allEdgesFrom(Node v) {
        List<Edge> ret = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getNodeA() == v) {
                ret.add(edge);
            }
        }

        return ret;
    }

    private String printStack(Stack<String> pilha) {
        String ret = "";
        for (String s : pilha) {
            ret += " " + s + " ";
        }
        return ret;
    }

    public ListModel getNodesListModel() {
        ListModel l = new javax.swing.AbstractListModel() {
            //String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
            List<Node> list = nodes;
            public int getSize() {
                return list.size();
            }

            public Object getElementAt(int i) {
                return list.get(i);
            }
        };

        return l;
    }
}
