package model.baseNodes;

import model.Node;
import model.tokenNode.TokenNode;

import java.util.Random;

public class MathExpression extends Node {

    public MathExpression(Node parentNode, String name, boolean isCrossable) {
        super(parentNode, name, isCrossable);
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
                this.addChild( new MathExpression(this, "MATH_EXPRESSION", true));
                this.addChild( new MathSymbol(this, "MATH_SYMBOL", true));
                this.addChild( new MathExpression(this, "MATH_EXPRESSION", true));
                break;
            case 1:
                this.addChild(new TokenNode(this, "BRACKET_L", false, "("));
                this.addChild(new MathExpression(this, "MATH_EXPRESSION", true));
                this.addChild(new TokenNode(this, "BRACKET_R", false, ")"));
                break;
            case 2:
                // TODO: add num_val
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
