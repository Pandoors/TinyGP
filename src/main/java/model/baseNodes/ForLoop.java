package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class ForLoop extends Node {

    public ForLoop(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(3);
        this.generateRandomChildren();
    }
    @Override
    public String getTreeProgTxt() {
        StringBuilder sb = new StringBuilder();
        for (Node child : this.getChildren()) {
            sb.append(child.getTreeProgTxt());
        }
        return sb.toString();
    }
    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    //for_loop: FOR BRACKET_L assignment SEMICOLON comparison SEMICOLON modification BRACKET_R PARENT_L (instruction | COMMENT )* PARENT_R; // minDepth: 3
    //this.addChild(new IfStatement(this, "IF_STATEMENT", true, treeRootNode));
    @Override
    public void generateRandomChildren() {
        this.addChild(new TokenNode(this, "FOR", false, "for", treeRootNode));
        this.addChild(new TokenNode(this, "BRACKET_L", false, "(", treeRootNode));
        this.addChild(new Assignment(this, "ASSIGNMENT", true, treeRootNode, true));
        this.addChild(new TokenNode(this, "SEMICOLON", false, ";", treeRootNode));
        this.addChild(new Comparison(this, "COMPARISON", true, treeRootNode));
        this.addChild(new TokenNode(this, "SEMICOLON", false, ";", treeRootNode));
        this.addChild(new Modification(this, "MODIFICATION", true, treeRootNode, true));
        this.addChild(new TokenNode(this, "BRACKET_R", false, ")", treeRootNode));
        this.addChild(new TokenNode(this, "PARENT_L", false, "{ \n", treeRootNode));

        Random random = new Random();
        int randomInt = random.nextInt(2);

        while (randomInt != 0) {
            int randomInt2 = random.nextInt(2);
            switch (randomInt2) {
                case 0:
                    this.addChild(new Instruction(this, "INSTRUCTION", true, treeRootNode));
                    break;
                case 1:
                    this.addChild(new TokenNode(this, "COMMENT", false, "//test \n", treeRootNode));
                    break;
            }
            random = new Random();
            randomInt = random.nextInt(2);
        }

        this.addChild(new TokenNode(this, "PARENT_R", false, "} \n", treeRootNode));


    }

    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }
    }
}
