package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class Comparison extends Node {

    public Comparison(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(2);
        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    //comparison: num_val comparator num_val; //minDepth: 2
    @Override
    public void generateRandomChildren() {
        // checking if we can add child

        this.addChild(new NumVal(this, "NUM_VAL", false, treeRootNode));
        this.addChild(new Comparator(this, "COMPARATOR", false, treeRootNode));
        this.addChild(new NumVal(this, "NUM_VAL", false, treeRootNode));

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
