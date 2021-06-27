/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map.Routes;

/**
 *
 * @author Richard
 */

import FinalProject.Model.Map.VertexModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Tree {

  private VertexModel head;
  private ArrayList<VertexModel> subTrees = new ArrayList<>();
  private Tree parent = null;
  private HashMap<VertexModel, Tree> routeTree = new HashMap<>();

  public Tree(VertexModel head) {
    this.head = head;
    routeTree.put(head, this);
  }

  public void addChild(T root, T child) {
    if (routeTree.containsKey(root)) 
    {
      routeTree.get(root).addChild(child);
    } 
    else 
    {
      this.addChildren(root).addChildren(child);
    }
  }

  public Tree<T> addChildren(T child) {
    Tree<T> t = new Tree<>(child);
    subTrees.add(t);
    t.parent = this;
    t.routeTree = this.routeTree;
    routeTree.put(child, t);
    return t;
  }

  public Tree<T> setParent(T parent) {
    Tree<T> t = new Tree<T>(parent);
    t.subTrees.add(this);
    this.parent = t;
    t.routeTree = this.routeTree;
    t.routeTree.put(head, this);
    t.routeTree.put(parent, t);
    return t;
  }

  public T getHead() {
    return head;
  }

  public Tree<T> getTree(T tree) {
    return routeTree.get(tree);
  }

  public Tree<T> getParent() {
    return parent;
  }

  public Collection<T> getSubTree(T root) {
    Collection<T> subTree = new ArrayList<T>();
    Tree<T> tree = getTree(root);
    if (tree!=null) 
    {
      for (Tree<T> child : tree.subTrees) 
      {
        subTree.add(child.head);
      }
    }
    return subTree;
  }

  public Collection<Tree<T>> getSubTrees() {
    return subTrees;
  }
}
