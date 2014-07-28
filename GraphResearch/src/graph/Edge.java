/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Objects;
import org.ubiety.ubigraph.UbigraphClient;

/**
 *
 * @author coc-dell-u14
 */
public class Edge {

    private int index;
    private boolean mark;
    private Node source;
    private Node target;
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

    public Edge(boolean mark, Node source, Node target) {
        this(mark);
        this.source = source;
        this.target = target;
    }

    public Edge(Node source, Node target) {
        this();
        this.source = source;
        this.target = target;
    }

    public Edge(Node source, Node target, String aInput, String aOutput) {
        this(source, target);
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
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the source
     */
    public Node getSource() {
        return source;
    }

    /**
     * @return the target
     */
    public Node getTarget() {
        return target;
    }

    public void check() {
        mark = true;
    }

    public void unheck() {
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
        getSource().setDrawArea(drawArea);
        getTarget().setDrawArea(drawArea);
    }

    public void draw() {
        if (drawArea != null) {
            getSource().draw();
            getTarget().draw();
            if (getIndex() == -1) {
                setIndex(drawArea.newEdge(getSource().getIndex(), getTarget().getIndex()));
            } else {
                drawArea.newEdge(getIndex(), getSource().getIndex(), getTarget().getIndex());
            }
            /*
            int newEdgeStyle;
            newEdgeStyle = drawArea.newEdgeStyle(index, index);
            drawArea.setEdgeStyleAttribute(getIndex(), "label", "label edge");
            drawArea.setEdgeStyleAttribute(getIndex(), "oriented", "true");
            drawArea.setEdgeStyleAttribute(getIndex(), "arrow", "true");
            //*/
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (this.index != other.index) {
            return false;
        }
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        if (!Objects.equals(this.target, other.target)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.index;
        hash = 79 * hash + Objects.hashCode(this.source);
        hash = 79 * hash + Objects.hashCode(this.target);
        return hash;
    }
}
