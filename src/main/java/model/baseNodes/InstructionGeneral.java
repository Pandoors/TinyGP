package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class InstructionGeneral extends Node {

    public InstructionGeneral(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(1);
        this.setDepth(this.parentNode.getDepth() + 1);
        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }


    @Override
    public void generateRandomChildren() { // TODO:powinno to działać ale trzeba przerobić wygląd tej klasy, żeby była podobna do InstructionGeneral
        Random random = new Random();
        int randomInt = random.nextInt(4);
        // checking if we can add child
        if (this.treeRootNode.getMaxDepth() - this.depth < minDepthRequired)
            throw new RuntimeException("Cannot add child to node " + this.name + " because maxDepth - depth < minDepthRequired - 1");


        switch (this.treeRootNode.getMaxDepth() - this.depth){
            case 1:
                // then  we go for just COMMENT
                while(randomInt!=3) {
                    switch (randomInt) {
                        case 0:
                            break;
                        case 1:
                            this.addChild(new TokenNode(this, "COMMENT", false, "//test", treeRootNode));
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    randomInt = random.nextInt(4);
                }
                break;


            case 2:
                // then we go just for COMMENT and assigment
                while(randomInt!=3) {
                    switch (randomInt) {
                        case 0:
                            break;
                        case 1:
                            this.addChild(new TokenNode(this, "COMMENT", false, "//test", treeRootNode));
                            break;
                        case 2:
                            this.addChild(new Assignment(this, "ASSIGNMENT", true, treeRootNode));
                            this.addChild(new TokenNode(this, "SEMICOLON", false, ";", treeRootNode));
                            break;
                        case 3:
                            break;
                    }
                    randomInt = random.nextInt(4);
                }
                break;


            default: // then we go for all
                while(randomInt!=3) {
                    switch (randomInt) {
                        case 0:
                            this.addChild(new Instruction(this, "INSTRUCTION", true, treeRootNode));
                            break;
                        case 1:
                            this.addChild(new TokenNode(this, "COMMENT", false, "//test", treeRootNode));
                            break;
                        case 2:
                            this.addChild(new Assignment(this, "ASSIGNMENT", true, treeRootNode));
                            this.addChild(new TokenNode(this, "SEMICOLON", false, ";", treeRootNode));
                            break;
                        case 3:
                            break;
                    }
                    randomInt = random.nextInt(4);
                }
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
