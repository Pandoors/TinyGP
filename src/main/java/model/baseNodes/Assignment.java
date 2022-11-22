package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class Assignment extends Node {

    private boolean fromForLoop;

    public Assignment(Node parentNode, String name, boolean isCrossable, Program program, boolean fromForLoop, boolean startProgram) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(1);
        this.fromForLoop = fromForLoop;
        if (startProgram) {
            this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
        } else {
            this.generateRandomChildren();

        }

    }
//assignment: INT IDENTIFIER EQUAL (math_expr [3] | readOrIn [0] )
//| STRING IDENTIFIER EQUAL (STRING_VAL [4] | readOrIn [1] )
//| BOOL IDENTIFIER EQUAL (bool_val [5] | readOrIn [2] );

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    @Override
    public void generateRandomChildren() {

        boolean goShort = this.treeRootNode.getMaxDepth() - this.depth == 1;

        Random random = new Random();
        int randInt = fromForLoop ? 0 : random.nextInt(3);
        switch (randInt) {
            case 0: //1. INT IDENTIFIER EQUAL
                int index = this.treeRootNode.getVariables().size() + 1;
                String newVar = "x".concat(String.valueOf(index));
                this.addChild(new TokenNode(this, "INT", false, "int ", treeRootNode));
                TokenNode tn = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
                this.addChild(tn);
                this.treeRootNode.addVariable(tn);
                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                if (goShort)
                    this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                else { // b (math_expr | READ_OR_IN)
                    this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                }
                break;
            case 1://2. STRING IDENTIFIER EQUAL (STRING_VAL | READ_OR_IN )
                this.addChild(new TokenNode(this, "STRING", false, "string ", treeRootNode));
                int index1 = this.treeRootNode.getVariables().size() + 1;
                String newVar1 = "x".concat(String.valueOf(index1));
                TokenNode tn1 = new TokenNode(this, "IDENTIFIER", false, newVar1, treeRootNode);
                this.addChild(tn1);
                this.treeRootNode.addVariable(tn1);
                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                Random random2 = new Random();
                this.addChild(new TokenNode(this, "STRING_VAL", false, "\"test\"", treeRootNode));

                break;
            case 2://3. BOOL IDENTIFIER EQUAL
                this.addChild(new TokenNode(this, "BOOL", false, "boolean ", treeRootNode));
                int index2 = this.treeRootNode.getVariables().size() + 1;
                String newVar2 = "x".concat(String.valueOf(index2));
                TokenNode tn2 = new TokenNode(this, "IDENTIFIER", false, newVar2, treeRootNode);
                this.addChild(tn2);
                this.treeRootNode.addVariable(tn2);
                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));

                this.addChild(new BoolVal(this, "BOOL_VAL", true, treeRootNode));

                break;
        }

    }


    public boolean isFromForLoop() {
        return fromForLoop;
    }

    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }

    }
}
