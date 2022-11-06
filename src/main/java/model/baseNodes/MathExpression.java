package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class MathExpression extends Node {

    public MathExpression(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(2);
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
        int randomInt = random.nextInt(3);
        // checking if we can add child
        if(this.treeRootNode.getMaxDepth() - this.depth < minDepthRequired - 1) throw new RuntimeException("Cannot add child to node " + this.name + " because maxDepth - depth < minDepthRequired - 1");
        if(this.treeRootNode.getMaxDepth() - this.depth - 1 == 1) randomInt = 2; // we have no choice if , we add NumVal , still - 1 is quite ugly
        switch (randomInt) {
            case 0:
                this.addChild( new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));// min required depth = 2
                this.addChild( new MathSymbol(this, "MATH_SYMBOL", true, treeRootNode));
                this.addChild( new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                break;
            case 1:
                this.addChild(new TokenNode(this, "BRACKET_L", false, "(", treeRootNode));// min required depth = 2
                this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                this.addChild(new TokenNode(this, "BRACKET_R", false, ")", treeRootNode));
                break;
            case 2:
                this.addChild(new NumVal(this, "NUM_VAL", false, treeRootNode)); // min required depth = 1
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
