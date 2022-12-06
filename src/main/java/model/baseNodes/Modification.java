package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class Modification extends Node {
    private boolean fromForLoop;


    public Modification(Node parentNode, String name, boolean isCrossable, Program program, boolean fromForLoop) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(1);
        this.generateRandomChildren();
        this.fromForLoop = fromForLoop;
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }


//  modification: IDENTIFIER EQUAL (math_expr | READ_OR_IN); minDepthRequired = 1
    @Override
    public void generateRandomChildren() {

        Random random = new Random();
        int randomInt = random.nextInt(2);

        if(this.treeRootNode.getMaxDepth() - this.depth == 2)
            randomInt = 1;
        switch (randomInt) {
            case 0:
                int randomInt_2 = random.nextInt(this.treeRootNode.getVariables().size());
                this.addChild(new TokenNode(this, "IDENTIFIER", false,fromForLoop ? this.treeRootNode.getVariables().get(treeRootNode.getVariables().size()-1).getToken() : this.treeRootNode.getVariables().get(randomInt_2).getToken(), treeRootNode));
                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                break;
            case 1:
                int randomInt_3 = random.nextInt(this.treeRootNode.getVariables().size());
                this.addChild(new TokenNode(this, "IDENTIFIER", false,fromForLoop ? this.treeRootNode.getVariables().get(treeRootNode.getVariables().size()-1).getToken() : this.treeRootNode.getVariables().get(randomInt_3).getToken(), treeRootNode));
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
    @Override
    public String getTreeProgTxt() {
        StringBuilder sb = new StringBuilder();
        for (Node child : this.getChildren()) {
            sb.append(child.getTreeProgTxt());
        }
        return sb.toString();
    }
}
