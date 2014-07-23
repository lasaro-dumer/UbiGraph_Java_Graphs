/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphresearch;

import graph.DirectedGraph;
import graph.Node;
import graph.Edge;
import GUI.GraphGUI;
import java.io.IOException;
import java.util.List;
import org.ubiety.ubigraph.UbigraphClient;

/**
 *
 * @author coc-dell-u14
 */
public class GraphResearch {

    private static List<Edge> edges;

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here
        UbigraphClient graph = new UbigraphClient();

        graph.clear();
        DirectedGraph d = createGraph3();
        d.writeAt(graph,0);
        //Thread.sleep(1000 * 10);
        System.in.read();
        //graph.clear();
        d.writeDFSAt(graph, 500,false);
    }

    private static DirectedGraph createGraph1() {
        DirectedGraph g = new DirectedGraph();

        Node n1 = new Node("Act 1", "#ffffff");
        Node n2 = new Node("Act 2", "#ffffff");
        Node n3 = new Node("Act 3", "#ffffff");
        Node n4 = new Node("Act 4", "#ffffff");
        Node n5 = new Node("Act 5", "#ffffff");
        Node n6 = new Node("Act 6", "#ffffff");
        Node n7 = new Node("Act 7", "#ffffff");

        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);
        g.addNode(n6);
        g.addNode(n7);

        g.addEdge(new Edge(n1, n2, "1->2", ""));
        g.addEdge(new Edge(n2, n3, "2->3", ""));
        g.addEdge(new Edge(n3, n4, "3->4", ""));
        g.addEdge(new Edge(n3, n5, "3->5", ""));
        g.addEdge(new Edge(n4, n6, "4->6", ""));
        g.addEdge(new Edge(n5, n6, "5->6", ""));
        g.addEdge(new Edge(n6, n7, "6->7", ""));
        //g.addEdge(new Edge(n4, n2,"4->2",""));        

        g.checkFinal(n7);

        return g;
    }

    private static DirectedGraph createGraph2() {
        DirectedGraph g = new DirectedGraph();

        Node n1 = new Node("Act 1", "#ffffff");
        Node n2 = new Node("Act 2", "#ffffff");
        Node n3 = new Node("Act 3", "#ffffff");
        Node n4 = new Node("Act 4", "#ffffff");
        Node n5 = new Node("Act 5", "#ffffff");
        Node n6 = new Node("Act 6", "#ffffff");
        Node n7 = new Node("Act 7", "#ffffff");

        Node n8 = new Node("Act 8", "#ffffff");
        Node n9 = new Node("Act 9", "#ffffff");
        Node n10 = new Node("Act 10", "#ffffff");
        Node n11 = new Node("Act 11", "#ffffff");
        Node n12 = new Node("Act 12", "#ffffff");
        Node n13 = new Node("Act 13", "#ffffff");
        Node n14 = new Node("Act 14", "#ffffff");

        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);
        g.addNode(n6);
        g.addNode(n7);
        g.addNode(n8);
        g.addNode(n9);
        g.addNode(n10);
        g.addNode(n11);
        g.addNode(n12);
        g.addNode(n13);
        g.addNode(n14);

        g.addEdge(new Edge(n1, n2, "1->2", ""));
        g.addEdge(new Edge(n2, n3, "2->3", ""));
        g.addEdge(new Edge(n3, n4, "3->4", ""));
        g.addEdge(new Edge(n3, n5, "3->5", ""));
        g.addEdge(new Edge(n3, n8, "3->8", ""));
        g.addEdge(new Edge(n4, n6, "4->6", ""));
        g.addEdge(new Edge(n5, n6, "5->6", ""));
        g.addEdge(new Edge(n6, n7, "6->7", ""));

        g.addEdge(new Edge(n8, n9,  "8->9", ""));
        g.addEdge(new Edge(n8, n12,"8->12", ""));
        g.addEdge(new Edge(n9, n10, "9->10", ""));
        g.addEdge(new Edge(n10, n11,"10->11", ""));
        g.addEdge(new Edge(n11, n13,"11->13", ""));
        g.addEdge(new Edge(n12, n13,"12->13", ""));
        g.addEdge(new Edge(n13, n7, "13->7", ""));
        
        g.addEdge(new Edge(n7, n14, "7->14", ""));

        g.checkFinal(n14);

        return g;
    }

    private static DirectedGraph createGraph3() {
        DirectedGraph g = new DirectedGraph();

        Node n1 = new Node("Act 1", "#ffffff");
        Node n2 = new Node("Act 2", "#ffffff");
        Node n3 = new Node("Act 3", "#ffffff");
        Node n4 = new Node("Act 4", "#ffffff");
        Node n5 = new Node("Act 5", "#ffffff");
        Node n6 = new Node("Act 6", "#ffffff");
        Node n7 = new Node("Act 7", "#ffffff");

        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);
        g.addNode(n6);
        g.addNode(n7);

        g.addEdge(new Edge(n1, n2, "1->2", ""));
        g.addEdge(new Edge(n2, n3, "2->3", ""));
        g.addEdge(new Edge(n3, n4, "3->4", ""));
        g.addEdge(new Edge(n4, n5, "4->5", ""));
        g.addEdge(new Edge(n5, n6, "5->6", ""));
        g.addEdge(new Edge(n6, n7, "6->7", ""));
        
        
        g.addEdge(new Edge(n6, n2, "6->2", ""));

        g.checkFinal(n7);

        return g;
    }
}
