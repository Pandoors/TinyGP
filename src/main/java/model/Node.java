package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.tokenNode.TokenNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@ToString
public abstract class Node {
    protected Node parentNode;
    protected String name;
    protected List<Node> children;
    protected boolean isCrossable;
    protected int depth;
    protected int maxDepth;
    protected int minDepthRequired;
    protected Program treeRootNode;
    public static final Random RANDOM = new Random();
    protected List<Node> allNodesForSerial = null;
    // constructor ONLY for first starting node of tree
    public Node() {
        this.allNodesForSerial = new ArrayList<>();
        this.parentNode = this;
        this.name = "rootNode";
        this.isCrossable = false;
        this.children = new ArrayList<>();
    }
    // constructor for all other nodes
    public Node(Node parentNode, String name, Boolean isCrossable, Program program) {
        this.parentNode = parentNode;
        this.name = name;

        this.isCrossable = Boolean.TRUE.equals(isCrossable);
        this.children = new ArrayList<>();
        this.treeRootNode = program;
        this.setDepth(this.parentNode.getDepth() + 1);
        treeRootNode.checkDepth(this);
        this.checKTheMinDepth();
    }

    protected abstract void addChild(Node child);
    public abstract void generateRandomChildren();
    public abstract void print();
    public abstract String getTreeProgTxt();

    public Node getParentNode() {
        return parentNode;
    }

    public String getName() {
        return name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public boolean isCrossable() {
        return isCrossable;
    }

    public int getDepth() {
        return depth;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public Program getTreeRootNode() {
        return treeRootNode;
    }

    private void checKTheMinDepth(){
//        if(this.treeRootNode.getMaxDepth() - this.getDepth() < this.minDepthRequired){
//            System.out.println("ERROR: " + this.getClass().getName() +  " MAXDEPTH " + this.treeRootNode.getMaxDepth() + " DEPTH " + this.depth + "WITH PARENT: " + this.parentNode.getClass().getName() +  "\n");
//        }
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void cross(Node toCross){
        this.children.add(toCross);
    }
    protected void addChildrenToSerialisationList(){

        for (Node child : this.getChildren()) {
            child.addChildrenToSerialisationList();
        }

    }

    public void appendAllNodes(Node tn){
        this.treeRootNode.allNodesForSerial.add(tn);
    }

}
