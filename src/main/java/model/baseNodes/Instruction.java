package model.baseNodes;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.Random;

public class Instruction extends Node {

    public Instruction(Node parentNode, String name, boolean isCrossable, Program program) {
        super(parentNode, name, isCrossable, program);
        this.setMinDepthRequired(2);
        this.generateRandomChildren();
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    @Override
    public void generateRandomChildren() {

        int depthChoice;

        switch (this.treeRootNode.getMaxDepth() - this.depth){
            case 0:
            case 1:
                return;
            case 2:
                depthChoice = 1;
                break;
            case 3:
                depthChoice = 2;
                break;
            default:
                depthChoice = 3;
                break;
        }

        switch (depthChoice){
            case 1:
                this.addChildrenWithMaxDepth1();
                break;
            case 2: // we can choose between writeOrOut | modification SEMICOLON | ifStatement
                this.addChildrenWithMaxDepth3();
                break;
            case 3:
                this.addChildrenWithMaxDepth4();
                break;
        }
    }


    private void addChildrenWithMaxDepth1(){ // we can choose between writeOrOut | modification SEMICOLON
        // we need to check if we have any variables
        if(this.treeRootNode.getVariables().isEmpty()) // then we can just got for writeOrOut
            this.addChild(new WriteOrOut(this, "WRITE_OR_OUT", true, this.treeRootNode));
        else { //we can choose between writeOrOut | modifiscation SEMICOLON
            switch (new Random().nextInt(2)) {
                case 0:
                    this.addChild(new WriteOrOut(this, "WRITE_OR_OUT", true, this.treeRootNode));
                    break;
                case 1:
                    this.addChild(new Modification(this, "MODIFICATION", true, treeRootNode, false));
                    this.addChild(new TokenNode(this, "SEMICOLON", false, ";\n", this.treeRootNode));
                    break;
            }
        }
    }
    private void addChildrenWithMaxDepth3(){
        switch (new Random().nextInt(2)) {
            case 0:
                this.addChildrenWithMaxDepth1();
            case 1:
                this.addChild(new WhileLoop(this, "WHILE_LOOP", true, treeRootNode));
                break;
        }
    }
    private void addChildrenWithMaxDepth4(){
        switch (new Random().nextInt(3)) {
            case 0:
                this.addChildrenWithMaxDepth1();
            case 1:
                this.addChild(new WhileLoop(this, "WHILE_LOOP", true, treeRootNode));
                break;
            case 2:
                this.addChild(new IfStatement(this, "IF_STATEMENT", true, treeRootNode));
                break;
        }
    }

    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }
    }
}
