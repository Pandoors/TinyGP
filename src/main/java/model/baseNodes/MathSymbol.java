package model.baseNodes;

import model.Node;
import model.tokenNode.TokenNode;

import java.util.Random;

public class MathSymbol extends Node {

    public MathSymbol(Node parentNode, String name, Boolean isCrossable) {
        super(parentNode, name, isCrossable);
    }

    public MathSymbol(Node parentNode, String name) {
        super(parentNode, name);
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
                this.addChild( new TokenNode(this, "ADD_", false, "+"));
                break;
            case 1:
                this.addChild( new TokenNode(this, "SUBTRACT_", false, "-"));
                break;
            case 2:
                this.addChild( new TokenNode(this, "MULTIPLY", false, "*"));
                break;
            case 3:
                this.addChild( new TokenNode(this, "DIVIDE", false, "/"));
                break;
        }
    }

    @Override
    public void print() {
        System.out.println("|");
        this.getChildren().get(0).print();
    }


}
