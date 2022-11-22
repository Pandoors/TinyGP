package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class InstructionGeneral extends Node {

    public InstructionGeneral(Node parentNode, String name, boolean isCrossable, Program program, boolean programStart) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(1);
        if (programStart) {
            generateSysInAssignments();
        } else {
            this.generateRandomChildren();
        }
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    public void generateSysInAssignments() {
        this.addChild(new Assignment(this, "ASSIGNMENT", true, treeRootNode, false, true));
    }

    @Override
    public void generateRandomChildren() {
        Random random = new Random();
        int randomInt = random.nextInt(3);
        // checking if we can add child

        while(treeRootNode.getMaxReachedDepth() < treeRootNode.getMaxDepth()) {

            switch (this.treeRootNode.getMaxDepth() - this.depth) {
                case 1:
                    // then  we go for just COMMENT
                    this.addChildrenWithMaxDepth0();
                    break;
                case 2:
                    // then we go just for COMMENT and assigment
                    this.addChildrenWithMaxDepth1();
                    break;
                default: // then we go for all
                    this.addChildrenWithMaxDepth2();
                    break;
            }
        }
    }

    private void addChildrenWithMaxDepth0(){
        Random random = new Random();
        int randomInt = random.nextInt(2);
        while (randomInt==0) {
            this.addChild(new TokenNode(this, "COMMENT", false, "//test \n", treeRootNode));
            randomInt = random.nextInt(2);
        }
    }

    private void addChildrenWithMaxDepth1(){
        Random random = new Random();
        int randomInt = random.nextInt(3);
        while(randomInt!=2) {
            switch (randomInt) {
                case 0:
                    this.addChild(new Instruction(this, "INSTRUCTION", true, treeRootNode));
                    break;
                case 1:
                    this.addChild(new TokenNode(this, "COMMENT", false, "//test \n", treeRootNode));
                    break;
                case 2:
                    break;
            }
            randomInt = random.nextInt(3);
            if(randomInt==2)
                break;
        }
    }
    private void addChildrenWithMaxDepth2(){
        Random random = new Random();
        int randomInt = random.nextInt(4);
        while(randomInt!=3) {
            switch (randomInt) {
                case 0:
                    this.addChild(new Instruction(this, "INSTRUCTION", true, treeRootNode));
                    break;
                case 1:
                    this.addChild(new TokenNode(this, "COMMENT", false, "//test \n", treeRootNode));
                    break;
                case 2:
                    this.addChild(new Assignment(this, "ASSIGNMENT", true, treeRootNode, false, false));
                    this.addChild(new TokenNode(this, "SEMICOLON", false, ";\n", treeRootNode));
                    break;
                case 3:
                    break;
            }
            randomInt = random.nextInt(4);
            if(randomInt==3)
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
