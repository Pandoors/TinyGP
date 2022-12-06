package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class LogicStatement extends Node {

    public LogicStatement(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(2);
        this.generateRandomChildren();
    }


    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);

    }

    @Override
    public void generateRandomChildren() {//logic_statement: comparison | bool_val;
        Random random = new Random();
        int randomInt = random.nextInt(2);
        // checking if we can add child

        if(this.treeRootNode.getMaxDepth()-this.depth == 2)
            this.addChildrenWithMaxDepth1();
        else this.addChildrenWithMaxDepth2();
    }
    private void addChildrenWithMaxDepth1(){
        this.addChild(new Comparison(this, "COMPARISON", false, treeRootNode));
    }
    private void addChildrenWithMaxDepth2(){
        switch (new Random().nextInt(2)) {
            case 0:
                this.addChild(new Comparison(this, "COMPARISON", false, treeRootNode));
                break;
            case 1:
                this.addChild(new NumVal(this, "NUM_VAL", false, treeRootNode));
                break;
        }
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
