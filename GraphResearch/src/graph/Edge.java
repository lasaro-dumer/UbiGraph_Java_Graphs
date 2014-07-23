/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import org.ubiety.ubigraph.UbigraphClient;

/**
 *
 * @author coc-dell-u14
 */
public class Edge {

    private int index;
    private boolean mark;
    private Node nodeA;
    private Node nodeB;
    private String input;
    private String output;
    private UbigraphClient drawArea;

    public Edge() {
        this.index = -1;
        this.mark = false;
    }

    Edge(boolean isChecked) {
        this();
        this.mark = isChecked;
    }

    public Edge(boolean mark, Node nodeA, Node nodeB) {
        this(mark);
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public Edge(Node nodeA, Node nodeB) {
        this();
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public Edge(Node nodeA, Node nodeB, String aInput, String aOutput) {
        this(nodeA, nodeB);
        this.input = aInput;
        this.output = aOutput;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return the mark
     */
    public boolean isChecked() {
        return mark;
    }

    /**
     * @param mark the mark to set
     */
    public void Check(boolean mark) {
        this.mark = mark;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the nodeA
     */
    public Node getNodeA() {
        return nodeA;
    }

    /**
     * @return the nodeB
     */
    public Node getNodeB() {
        return nodeB;
    }

    void Check() {
        mark = true;
    }
    void Unheck() {
        mark = false;
    }

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * @return the output
     */
    public String getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(String output) {
        this.output = output;
    }

    /**
     * @return the drawArea
     */
    public UbigraphClient getDrawArea() {
        return drawArea;
    }

    /**
     * @param drawArea the drawArea to set
     */
    public void setDrawArea(UbigraphClient drawArea) {
        this.drawArea = drawArea;
        getNodeA().setDrawArea(drawArea);
        getNodeB().setDrawArea(drawArea);
    }

    public void draw() {
        if (drawArea != null) {
            getNodeA().draw();
            getNodeB().draw();
            if (getIndex() == -1) {
                setIndex(drawArea.newEdge(getNodeA().getIndex(), getNodeB().getIndex()));            
            }else{
                drawArea.newEdge(getIndex(),getNodeA().getIndex(), getNodeB().getIndex());
            }
            int newEdgeStyle;
            newEdgeStyle = drawArea.newEdgeStyle(index, index);
            drawArea.setEdgeStyleAttribute(getIndex(), "label", "label edge");
            drawArea.setEdgeStyleAttribute(getIndex(), "oriented", "true");
            drawArea.setEdgeStyleAttribute(getIndex(), "arrow", "true");
        }
    }
}
