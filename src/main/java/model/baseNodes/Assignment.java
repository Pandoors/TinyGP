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
//assignment: INT IDENTIFIER EQUAL (math_expr | readOrIn [0] )
//| STRING IDENTIFIER EQUAL (STRING_VAL | readOrIn [1] )
//| BOOL IDENTIFIER EQUAL (bool_val | readOrIn );

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
//        if (this.treeRootNode.getMaxDepth() - this.depth == 4) randomInt = random.nextInt(2);
        int index = this.treeRootNode.getVariables().size() + 1;
        String newVar = "x".concat("_").concat(String.valueOf(index));
        switch (randomInt) {
            case 0:
                this.addChild(new TokenNode(this, "INT", false, "int", treeRootNode));
                TokenNode tn = new TokenNode(this, "IDENTIFIER", false, newVar, treeRootNode);
                this.addChild(tn);
                this.treeRootNode.addVariable(tn);

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

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
