package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class WhileLoop extends Node {

    public WhileLoop(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(3);
        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    //for_loop: FOR BRACKET_L assignment SEMICOLON comparison SEMICOLON modification BRACKET_R PARENT_L (instruction | COMMENT )* PARENT_R; // minDepth: 3
    //this.addChild(new IfStatement(this, "IF_STATEMENT", true, treeRootNode));
    @Override
    public void generateRandomChildren() {
        this.addChild(new TokenNode(this, "WHILE", false, "while", treeRootNode));
        this.addChild(new TokenNode(this, "BRACKET_L", false, "(", treeRootNode));
        this.addChild(new LogicCondition(this, "LOGIC_CONDITION", true, treeRootNode));
        this.addChild(new TokenNode(this, "BRACKET_R", false, ")", treeRootNode));
        this.addChild(new TokenNode(this, "PARENT_L", false, "{ \n", treeRootNode));

        Random random = new Random();
        int randomInt = random.nextInt(2);

        while (randomInt != 0) {
            this.addChild(new Instruction(this, "INSTRUCTION", true, treeRootNode));
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
