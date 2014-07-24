/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.awt.Color;
import org.ubiety.ubigraph.UbigraphClient;

/**
 *
 * @author coc-dell-u14
 */
public class Node {

    private int index;
    private String label;
    private boolean mark;
    private int degree;
    private UbigraphClient drawArea;
    private NodeShape shape;
    private Color color;

    public Node(int index, String label, String color) {
        this.index = index;
        this.label = label;
        this.mark = false;
        this.degree = 0;
        this.drawArea = null;
        this.shape = NodeShape.SPHERE;
        setColor(color);
    }

    public Node(String label, String color) {
        this(-1, label, color);
    }

    public Node(String label, Color color) {
        this(-1, label, "#" + Integer.toHexString(color.getRGB()).substring(2));
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return "#" + Integer.toHexString(color.getRGB()).substring(2);
    }
    /**
     * @return the color
     */
    public Color getColorObj() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        int r = Integer.parseInt(color.substring(1, 3), 16);
        int g = Integer.parseInt(color.substring(3, 5), 16);
        int b = Integer.parseInt(color.substring(5, 7), 16);
        this.color = new Color(r, g, b);
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isChecked() {
        return mark;
    }

    public void check() {
        mark = true;
    }

    public void uncheck() {
        mark = false;
    }

    public void promote() {
        degree++;
        recalcColor();
    }

    public void demote() {
        degree--;
        recalcColor();
    }

    private void recalcColor() {
        //System.out.println("Nodo: " + label + " Color: " + color);
        String c = getColor();
        String R = c.substring(1, 3);
        String G = c.substring(3, 5);
        String B = c.substring(5, 7);
        //System.out.println("#" + R + "." + G + "." + B);
        if (degree <= 0) {
            R = "FF";
            G = "FF";
            B = "FF";
        } else if (degree == 1) {
            B = "00";
        } else if (degree == 2) {
            G = "00";
        } else if (degree == 3) {
            G = "40";
            B = "80";
        } else if (degree == 4) {
            R = "40";
            G = "50";
            B = "90";
        } else if (degree == 5) {
            R = "20";
            G = "78";
            B = "90";
        }

        setColor("#" + R + G + B);
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
    }

    public void draw() {
        if (drawArea != null) {
            if (getIndex() == -1) {
                setIndex(drawArea.newVertex());
            } else {
                drawArea.newVertex(getIndex());
            }
            drawArea.setVertexAttribute(getIndex(), "label", getLabel());
            drawArea.setVertexAttribute(getIndex(), "color", getColor());
            drawArea.setVertexAttribute(getIndex(), "shape", shape.toString());
        }
    }

    @Override
    public String toString() {
        return getLabel() + " " + getColor();
    }

    public void setShape(NodeShape newShape) {
        this.shape = newShape;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) {
            return false;
        }
        Node n = (Node) obj;
        if (!n.getLabel().equals(this.getLabel())) {
            return false;
        }
        if (n.getIndex() != this.getIndex()) {
            return false;
        }

        return true;
    }
}
