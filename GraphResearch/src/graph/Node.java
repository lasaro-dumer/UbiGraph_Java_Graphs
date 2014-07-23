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
    private String name;
    private String color;
    private boolean mark;
    private int degree;
    private UbigraphClient drawArea;
    private NodeShape shape;

    public Node(int index, String name, String color) {
        this.index = index;
        this.name = name;
        this.color = color;
        this.mark = false;
        this.degree = 0;
        this.drawArea = null;
        this.shape = NodeShape.SPHERE;
    }

    public Node(String name, String color) {
        this(-1, name, color);
    }
    public Node(String name, Color color) {
        this(-1, name, "#"+Integer.toHexString(color.getRGB()).substring(2));
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
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
        //System.out.println("Nodo: " + name + " Color: " + color);
        String R = color.substring(1, 3);
        String G = color.substring(3, 5);
        String B = color.substring(5, 7);
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

        color = "#" + R + G + B;
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
            }else{
                drawArea.newVertex(getIndex());
            }
            drawArea.setVertexAttribute(getIndex(), "label", getName());
            drawArea.setVertexAttribute(getIndex(), "color", getColor());
            drawArea.setVertexAttribute(getIndex(), "shape", shape.toString());
        }
    }

    @Override
    public String toString() {
        return getName()+" "+ getColor();
    }

    public void setShape(NodeShape newShape) {
        this.shape = newShape;
    }
}
