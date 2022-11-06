package model.baseNodes;

import model.Node;
import model.Program;


public class IfStatement extends Node {

    public IfStatement(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
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
