package model.baseNodes;

import model.Node;
import model.Program;

public class ReadOrIn extends Node {

    public ReadOrIn(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(1);
        this.setDepth(this.parentNode.getDepth() + 1);

        this.generateRandomChildren();
    }
    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);

    }

    @Override
    public void generateRandomChildren() {
    }

    @Override
    public void print() {

    }
}
