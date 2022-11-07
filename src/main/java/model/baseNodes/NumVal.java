package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class NumVal extends Node {


    public NumVal(Node parentNode, String name, Boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);

        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }


    @Override
    public void generateRandomChildren() {
        Random random = new Random();
        int randomInt_1 = random.nextInt(2);
        int randomInt_2 = random.nextInt(3);

        if (randomInt_1 == 1 && this.treeRootNode.getVariables().isEmpty()) {
            randomInt_1 = 0;
        }

        switch (randomInt_2) {
            case 1:
                this.addChild(new TokenNode(this, "SUBTRACT_", false, "-", treeRootNode));
                break;
        }

        switch (randomInt_1) {
            case 0:
                this.addChild(new TokenNode(this, "INT_VAL", false, String.valueOf(Math.abs(random.nextInt())), treeRootNode));
                break;
            case 1:
                int randomInt_3 = random.nextInt(this.treeRootNode.getVariables().size());
                this.addChild(new TokenNode(this, "IDENTIFIER", false, this.treeRootNode.getVariables().get(randomInt_3).getToken(), treeRootNode));
                break;
        }

    }

    @Override
    public void print() {
        for(Node child : this.getChildren()) {
            child.print();
        }
    }
}
