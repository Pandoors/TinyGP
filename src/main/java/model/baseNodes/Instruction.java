package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class Instruction extends Node {

    public Instruction(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(2);
        this.setDepth(this.parentNode.getDepth() + 1);
        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    @Override
    public void generateRandomChildren() {
        Random random = new Random();
        int randomInt = random.nextInt(4);
        if(randomInt == 0 && this.treeRootNode.getVariables().isEmpty()){
            randomInt = random.nextInt(3) + 1;
        }
        // checking if we can add child
        if (this.treeRootNode.getMaxDepth() - this.depth < minDepthRequired - 1)
            throw new RuntimeException("Cannot add child to node " + this.name + " because maxDepth - depth < minDepthRequired - 1");
        if (this.treeRootNode.getMaxDepth() - this.depth == 0)
            randomInt = 2; // we have no choice if , we add NumVal , still - 1 is quite ugly



        switch (randomInt) {
            case 0:
                this.addChild(new Modification(this, "MODIFICATION", true, treeRootNode, false));
                this.addChild(new TokenNode(this, "SEMICOLON", false, ";", treeRootNode));
                break;
            case 1:
                this.addChild(new IfStatement(this, "IF_STATEMENT", true, treeRootNode));
                break;
            case 2:
                this.addChild(new ForLoop(this, "FOR_LOOP", true, treeRootNode));
                break;
            case 3:
                this.addChild(new WriteOrOut(this, "WRITE_OR_OUT", true, treeRootNode));

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
