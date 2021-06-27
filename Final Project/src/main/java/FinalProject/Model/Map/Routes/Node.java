/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map.Routes;

import FinalProject.Model.Map.VertexModel;
import java.util.List;

/**
 *
 * @author Richard
 */
class Node {
    private VertexModel vertex;
    private Node parent;
    private List<Tree> children;

    public Node(VertexModel v, Node n){
        this.vertex = v;
        this.parent = n;
    }
    
    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public List<Tree> getChildren() {
        return children;
    }
    
    
    
    public VertexModel getVertex()
    {
        return vertex;
    }
    
    public void addChild(tree child) {
        this.children = children;
    }
}
