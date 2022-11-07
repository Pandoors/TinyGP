package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

public class WriteOrOut extends Node {

    public WriteOrOut(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(2); //todo @Boro tyle tu?
        this.setDepth(this.parentNode.getDepth() + 1);
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
        this.addChild(new TokenNode(this, "STRING_VAL", false, " \" test \" ", treeRootNode));
        this.addChild(new TokenNode(this, ")", false, ")", treeRootNode));
        this.addChild(new TokenNode(this, "SEMICOLON", false, ";", treeRootNode));
    }

    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }

    }
}
