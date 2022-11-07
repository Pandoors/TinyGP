package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class Assignment extends Node {

    public Assignment(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(1);
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
        if (this.treeRootNode.getMaxDepth() - this.depth < minDepthRequired)
            throw new RuntimeException("Cannot add child to node " + this.name + " because maxDepth - depth < minDepthRequired - 1");

        boolean goShort = this.treeRootNode.getMaxDepth() - this.depth == 1;

            Random random = new Random();
            switch (random.nextInt(3)) {
                case 0: //1. INT IDENTIFIER EQUAL
                    int index = this.treeRootNode.getVariables().size() + 1;
                    String newVar = "x".concat(String.valueOf(index));
                    this.addChild(new TokenNode(this, "INT", false, "int", treeRootNode));
                    TokenNode tn = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
                    this.addChild(tn);
                    this.treeRootNode.addVariable(tn);
                    this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                    if(goShort)// a READ_OR_IN
                        this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
                    else // b (math_expr | READ_OR_IN)
                        switch (random.nextInt(2)) {
                            case 0:
                                this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
                                break;
                            case 1:
                                this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
                                break;
                        }

                    break;
                case 1://2. STRING IDENTIFIER EQUAL (STRING_VAL | READ_OR_IN )
                    this.addChild(new TokenNode(this, "STRING", false, "string", treeRootNode));
                    int index1 = this.treeRootNode.getVariables().size() + 1;
                    String newVar1 = "x".concat(String.valueOf(index1));
                    TokenNode tn1 = new TokenNode(this, "IDENTIFIER", false, newVar1, treeRootNode);
                    this.addChild(tn1);
                    this.treeRootNode.addVariable(tn1);
                    this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
                    Random random2 = new Random();
                    switch (random2.nextInt(2)) {
                        case 0:
                            this.addChild(new TokenNode(this, "STRING_VAL", false, "a", treeRootNode));
                            break;
                        case 1:
                            this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
                            break;
                    }
                case 2://3. BOOL IDENTIFIER EQUAL
                    this.addChild(new TokenNode(this, "BOOL", false, "bool", treeRootNode));
                    int index2 = this.treeRootNode.getVariables().size() + 1;
                    String newVar2 = "x".concat(String.valueOf(index2));
                    TokenNode tn2 = new TokenNode(this, "IDENTIFIER", false, newVar2, treeRootNode);
                    this.addChild(tn2);
                    this.treeRootNode.addVariable(tn2);
                    if(goShort)
                        this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
                    else //(bool_val | READ_OR_IN )
                        switch (random.nextInt(2)) {
                            case 0:
                                this.addChild(new BoolVal(this, "BOOL_VAL", true, treeRootNode));
                                break;
                            case 1:
                                this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
                                break;
                        }
                    break;
            }

    }

//            assigment -> INT IDENTIFIER EQUAL    -> math_expr
//                                                 -> READ_OR_IN
//                      -> STRING IDENTIFIER EQUAL -> STRING_VAL
//                                                 -> READ_OR_IN
//                      -> BOOL IDENTIFIER EQUAL   -> bool_val
//                                                 -> READ_OR_IN

            // else we have production like
            //1. INT IDENTIFIER EQUAL (math_expr | READ_OR_IN)
            //2. STRING IDENTIFIER EQUAL (STRING_VAL | READ_OR_IN )
            //3. BOOL IDENTIFIER EQUAL (bool_val | READ_OR_IN )
//             int index = this.treeRootNode.getVariables().size() + 1;
//                    String newVar = "x".concat(String.valueOf(index));
//                    switch (randomInt) {
//                        case 0:
//                            this.addChild(new TokenNode(this, "INT", false, "int", treeRootNode));
//
//                            TokenNode tn = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
//                            this.addChild(tn);
//                            this.treeRootNode.addVariable(tn);
//
//                            this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
//                            this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
//                            break;
//                        case 1:
//                            this.addChild(new TokenNode(this, "STRING", false, "string", treeRootNode));
//
//                            TokenNode tn2 = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
//                            this.addChild(tn2);
//                            this.treeRootNode.addVariable(tn2);
//
//                            this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
//                            this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
//                            break;
//                        case 2:
//                            this.addChild(new TokenNode(this, "BOOL", false, "boolean", treeRootNode));
//
//                            TokenNode tn3 = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
//                            this.addChild(tn3);
//                            this.treeRootNode.addVariable(tn3);
//
//                            this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
//                            this.addChild(new TokenNode(this, "READ_OR_IN", false, "sysIn()", treeRootNode));
//                            break;
//                        case 3:
//                            this.addChild(new TokenNode(this, "INT", false, "int", treeRootNode));
//
//                            TokenNode tn4 = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
//                            this.addChild(tn4);
//                            this.treeRootNode.addVariable(tn4);
//
//                            this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
//                            this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
//                            break;
//                        case 4:
//                            this.addChild(new TokenNode(this, "STRING", false, "string", treeRootNode));
//
//                            TokenNode tn5 = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
//                            this.addChild(tn5);
//                            this.treeRootNode.addVariable(tn5);
//
//                            this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
//                            this.addChild(new TokenNode(this, "STRING_VAL", false, " \" test \" ", treeRootNode));
//                            break;
//                        case 5:
//                            this.addChild(new TokenNode(this, "BOOL", false, "boolean", treeRootNode));
//
//                            TokenNode tn6 = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
//                            this.addChild(tn6);
//                            this.treeRootNode.addVariable(tn6);
//
//                            this.addChild(new TokenNode(this, "EQUAL", false, "=", treeRootNode));
//                            this.addChild(new BoolVal(this, "bool_val", true, treeRootNode));
//                            break;
//








    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }

    }
}
