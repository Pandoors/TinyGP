package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class WriteOrOut extends Node {

    public WriteOrOut(Node parentNode, String name, boolean isCrossable, Program program) {
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
        // not so random but it is what it is :D
        this.addChild(new TokenNode(this, "printl(", false, "printl(", treeRootNode));

        Random random = new Random();
        int randomInt = random.nextInt(2);

        if(this.treeRootNode.getVariables() == null || this.treeRootNode.getVariables().size() < 1){
            randomInt = 1;
        }

        switch (randomInt) {
            case 0:
                int randomInt_2 = random.nextInt(this.treeRootNode.getVariables().size());
                this.addChild(new TokenNode(this, "IDENTIFIER", false, this.treeRootNode.getVariables().get(randomInt_2).getToken(), treeRootNode));
                break;
            case 1:
                this.addChild(new TokenNode(this, "INT_VAL", false, String.valueOf(Math.abs(random.nextInt())), treeRootNode));
                break;
        }


        this.addChild(new TokenNode(this, ")", false, ")", treeRootNode));
        this.addChild(new TokenNode(this, "SEMICOLON", false, ";\n", treeRootNode));
    }

    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }

    }
}
