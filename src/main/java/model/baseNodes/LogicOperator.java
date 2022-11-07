package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class LogicOperator extends Node {

    public LogicOperator(Node parentNode, String name, boolean isCrossable, Program program) {
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
        int randomInt = random.nextInt(2);
        // checking if we can add child
        if (this.treeRootNode.getMaxDepth() - this.depth < minDepthRequired - 1)
            throw new RuntimeException("Cannot add child to node " + this.name + " because maxDepth - depth < minDepthRequired - 1");
        switch (randomInt) {
            case 0:
                this.addChild(new TokenNode(this, "OR", false, "||", treeRootNode));
                break;
            case 1:
                this.addChild(new TokenNode(this, "AND", false, "&&", treeRootNode));
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
