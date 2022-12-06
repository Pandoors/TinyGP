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
        this.addChild(new TokenNode(this, "PARENT_L", false, "{ \n", treeRootNode));
        this.addChild(new InstructionGeneral(this, "INSTRUCTION_GENERAL", true, treeRootNode));
        this.addChild(new TokenNode(this, "PARENT_R", false, "} \n", treeRootNode));

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
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }
    }

}
