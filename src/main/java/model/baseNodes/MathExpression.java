package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class MathExpression extends Node {

    public MathExpression(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);

        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    @Override
    public void generateRandomChildren() {
        Random random = new Random();
        int randomInt = random.nextInt(3);
        switch (randomInt) {
            case 0:
                this.addChild( new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                this.addChild( new MathSymbol(this, "MATH_SYMBOL", true, treeRootNode));
                this.addChild( new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                break;
            case 1:
                this.addChild(new TokenNode(this, "BRACKET_L", false, "(", treeRootNode));
                this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                this.addChild(new TokenNode(this, "BRACKET_R", false, ")", treeRootNode));
                break;
            case 2:
                this.addChild(new NumVal(this, "NUM_VAL", false, treeRootNode));
                break;
        }
    }

    @Override
    public void print() {
        for(Node child : this.getChildren()) {
            child.print();
        }

    }

}
