package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class Assignment extends Node {

    public Assignment(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(4); //todo @Boro tyle tu?
        this.setDepth(this.parentNode.getDepth() + 1);
        this.generateRandomChildren();
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
        Random random = new Random();
        int randomInt = random.nextInt(6);
//        if (this.treeRootNode.getMaxDepth() - this.depth < minDepthRequired - 1)
//            throw new RuntimeException("Cannot add child to node " + this.name + " because maxDepth - depth < minDepthRequired - 1");
//        if (this.treeRootNode.getMaxDepth() - this.depth == 4) randomInt = random.nextInt(3);
        int index = this.treeRootNode.getVariables().size() + 1;
        String newVar = "x".concat("_").concat(String.valueOf(index));
        switch (randomInt) {
            case 0:
                this.addChild(new TokenNode(this, "INT", false, "int", treeRootNode));

                TokenNode tn = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
                this.addChild(tn);
                this.treeRootNode.addVariable(tn);

                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
                break;
            case 1:
                this.addChild(new TokenNode(this, "STRING", false, "string", treeRootNode));

                TokenNode tn2 = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
                this.addChild(tn2);
                this.treeRootNode.addVariable(tn2);

                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
                break;
            case 2:
                this.addChild(new TokenNode(this, "BOOL", false, "boolean", treeRootNode));

                TokenNode tn3 = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
                this.addChild(tn3);
                this.treeRootNode.addVariable(tn3);

                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
                break;
            case 3:
                this.addChild(new TokenNode(this, "INT", false, "int", treeRootNode));

                TokenNode tn4 = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
                this.addChild(tn4);
                this.treeRootNode.addVariable(tn4);

                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                break;
            case 4:
                this.addChild(new TokenNode(this, "STRING", false, "string", treeRootNode));

                TokenNode tn5 = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
                this.addChild(tn5);
                this.treeRootNode.addVariable(tn5);

                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                this.addChild(new TokenNode(this, "STRING_VAL", false, " \" test \" ", treeRootNode));
                break;
            case 5:
                this.addChild(new TokenNode(this, "BOOL", false, "boolean", treeRootNode));

                TokenNode tn6 = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
                this.addChild(tn6);
                this.treeRootNode.addVariable(tn6);

                this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                this.addChild(new BoolVal(this, "bool_val", true, treeRootNode));
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
