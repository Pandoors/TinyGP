package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class Comparator extends Node {

    public Comparator(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(1);
        this.setDepth(this.parentNode.getDepth() + 1);
        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    @Override
    public void generateRandomChildren() {
        Random random = new Random();
        int randomInt = random.nextInt(6);
        // checking if we can add child
        if(this.treeRootNode.getMaxDepth() - this.depth < minDepthRequired)
            throw new RuntimeException("Cannot add child to node " + this.name + " because maxDepth - depth < minDepthRequired - 1");
        switch (randomInt) {
            case 0:
                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                break;
            case 1:
                this.addChild(new TokenNode(this, "GREATER", false, ">", treeRootNode));
                break;
            case 2:
                this.addChild(new TokenNode(this, "LESS", false, "<", treeRootNode));
                break;
            case 3:
                this.addChild(new TokenNode(this, "GREATER_EQUAL", false, ">=", treeRootNode));
                break;
            case 4:
                this.addChild(new TokenNode(this, "LESS_EQUAL", false, "<=", treeRootNode));
                break;
            case 5:
                this.addChild(new TokenNode(this, "NOT_EQUAL", false, "!=", treeRootNode));
                break;
        }
    }

    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }
    }
}
