/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author coc-dell-u14
 */
public enum NodeShape {

    SPHERE("sphere"),
    CONE("cone"),
    CUBE("cube"),
    TORUS("torus"),
    DODECAHEDRON("dodecahedron"),
    ICOSAHEDRON("icosahedron"),
    OCTAHEDRON("octahedron"),
    TETRAHEDRON("tetrahedron"),
    NONE("none");
    private String value;
    
    private NodeShape(String value) {    
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
