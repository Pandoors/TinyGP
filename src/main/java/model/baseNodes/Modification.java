package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class Modification extends Node {

    public Modification(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(4); //todo @Boro tyle tu?
        this.setDepth(this.parentNode.getDepth() + 1);
        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }


//  modification: IDENTIFIER EQUAL (math_expr | READ_OR_IN);
    @Override
    public void generateRandomChildren() {
        Random random = new Random();
        int randomInt = random.nextInt(2);
        switch (randomInt) {
            case 0:
                int randomInt_2 = random.nextInt(this.treeRootNode.getVariables().size());
                this.addChild(new TokenNode(this, "IDENTIFIER", false, this.treeRootNode.getVariables().get(randomInt_2).getToken(), treeRootNode));
                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                break;
            case 1:
                int randomInt_3 = random.nextInt(this.treeRootNode.getVariables().size());
                this.addChild(new TokenNode(this, "IDENTIFIER", false, this.treeRootNode.getVariables().get(randomInt_3).getToken(), treeRootNode));
                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));

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
