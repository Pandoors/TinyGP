package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class InstructionGeneral extends Node {

    public InstructionGeneral(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(1);
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

        while(treeRootNode.getMaxReachedDepth() < treeRootNode.getMaxDepth()) {

            switch (this.treeRootNode.getMaxDepth() - this.depth) {
                case 1:
                    // then  we go for just COMMENT
//                    break;
                case 2:
                    // then we go just for COMMENT and assigment
                    this.addChildrenWithMaxDepth1();
                    break;
                default: // then we go for all
                    this.addChildrenWithMaxDepth1();
                    break;
            }
        }
    }



    private void addChildrenWithMaxDepth1(){
        Random random = new Random();
        int randomInt = random.nextInt(3);
        while(randomInt!=2) {
            switch (randomInt) {
                case 0:
                case 1:
                    this.addChild(new Instruction(this, "INSTRUCTION", true, treeRootNode));
                    break;
                case 2:
                    break;
            }
            randomInt = random.nextInt(3);
            if(randomInt==2)
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
