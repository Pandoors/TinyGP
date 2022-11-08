package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class LogicCondition extends Node {

    public LogicCondition(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(3);
        this.setDepth(this.parentNode.getDepth() + 1);
        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    //logic_condition: BRACKET_L logic_statement (logic_operator logic_statement)* BRACKET_R; // minDepth = 3
    @Override
    public void generateRandomChildren() {

        this.addChild(new TokenNode(this, "BRACKET_L", false, "(", treeRootNode));
        this.addChild(new LogicStatement(this, "LOGIC_STATEMENT", true, treeRootNode));
        Random random = new Random();
        int randomInt = random.nextInt(2);

        while (randomInt != 0) { // to jest gitówa
            this.addChild(new LogicOperator(this, "LOGIC_OPERATOR", true, treeRootNode));
            this.addChild(new LogicStatement(this, "LOGIC_STATEMENT", true, treeRootNode));

            random = new Random();
            randomInt = random.nextInt(2);
        }
        this.addChild(new TokenNode(this, "BRACKET_R", false, ")", treeRootNode));

    }

    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }
    }
}
