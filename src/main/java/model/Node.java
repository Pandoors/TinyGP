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
    private Node parentNode;
    private String name;
    private List<Node> children;
    private boolean isCrossable;
    private int depth;
    private int maxDepth;
    private int minDepthRequired;

    public static final Random RANDOM = new Random();

    public Node(Node parentNode, String name, Boolean isCrossable) {
        this.parentNode = parentNode;
        this.name = name;
        this.isCrossable = Boolean.TRUE.equals(isCrossable);
        this.children = new ArrayList<>();
    }

    public Node(Node parentNode, String name) {
        this.parentNode = parentNode;
        this.name = name;
        this.children = new ArrayList<>();
    }

    protected abstract void addChild(Node child);
    public abstract void generateRandomChildren();
    public abstract void print();

}
