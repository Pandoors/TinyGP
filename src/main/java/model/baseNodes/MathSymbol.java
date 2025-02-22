package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class MathSymbol extends Node {

    public MathSymbol(Node parentNode, String name, Boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(1);

        this.generateRandomChildren();
    }


    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    @Override
    public void generateRandomChildren() {
        Random random = new Random();
        int randomInt = random.nextInt(4);
        switch (randomInt) {
            case 0:
                this.addChild(new TokenNode(this, "ADD_", false, "+", treeRootNode));
                break;
            case 1:
                this.addChild(new TokenNode(this, "SUBTRACT_", false, "-", treeRootNode));
                break;
            case 2:
                this.addChild(new TokenNode(this, "MULTIPLY", false, "*", treeRootNode));
                break;
            case 3:
                this.addChild(new TokenNode(this, "DIVIDE", false, "/", treeRootNode));
                break;
        }
    }

    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }
    }
    @Override
    public String getTreeProgTxt() {
        StringBuilder sb = new StringBuilder();
        for (Node child : this.getChildren()) {
            sb.append(child.getTreeProgTxt());
        }
        return sb.toString();
    }
}
