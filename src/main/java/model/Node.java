package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    // constructor ONLY for first starting node of tree
    public Node() {
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
    }

    protected abstract void addChild(Node child);
    public abstract void generateRandomChildren();
    public abstract void print();

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

    public int getMinDepthRequired() {
        return minDepthRequired;
    }

    public Program getTreeRootNode() {
        return treeRootNode;
    }

}
