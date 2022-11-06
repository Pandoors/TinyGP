package model.baseNodes;

import model.Node;


public class IfStatement extends Node {

    public IfStatement(Node parentNode, String name, boolean isCrossable) {
        super(parentNode, name, isCrossable);
    }

    @Override
    protected void addChild(Node child) {

    }

    @Override
    public void generateRandomChildren() {
    }

    @Override
    public void print() {
    }

}
