package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;


public class IfStatement extends Node {

    public IfStatement(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(4);
        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }
//if_statement: IF logic_condition PARENT_L  (instruction | COMMENT )*  PARENT_R; // minDepth = 4
    @Override
    public void generateRandomChildren() {
        this.addChild(new TokenNode(this, "IF", false, "if", treeRootNode));
        this.addChild(new LogicCondition(this, "LOGIC_CONDITION", true, treeRootNode));
        this.addChild(new TokenNode(this, "PARENT_L", false, "{", treeRootNode));

        Random random = new Random();
        int randomInt = random.nextInt(2);

        while (randomInt != 0) {
            this.addChild(new Instruction(this, "INSTRUCTION", true, treeRootNode));

            this.addChild(new TokenNode(this, "COMMENT", false, "//test \n", treeRootNode));

            random = new Random();
            randomInt = random.nextInt(2);
        }

        this.addChild(new TokenNode(this, "PARENT_R", false, "}", treeRootNode));

    }

    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }
    }

}
