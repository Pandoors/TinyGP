package model;

import lombok.Setter;
import model.baseNodes.*;
import model.tokenNode.TokenNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Program extends Node {

    protected List<TokenNode> variables;

    private int maxReachedDepth;

    public void setMaxReachedDepth(int maxReachedDepth) {
        this.maxReachedDepth = maxReachedDepth;
    }

    public Program() {
        super();
        this.variables = new ArrayList<>();

        this.setDepth(0);
        this.setMaxDepth(10);

        this.treeRootNode = this;
        this.maxReachedDepth = 0;
        this.generateRandomChildren();
        this.print();
    }

    public Program(boolean print){
        super();
        this.variables = new ArrayList<>();

        this.setDepth(0);
        this.setMaxDepth(10);

        this.treeRootNode = this;
        this.maxReachedDepth = 0;
        this.generateRandomChildren();

        if(print){
            this.print();
        }
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    @Override
    public void generateRandomChildren() {

//        this.addChild(new InstructionGeneral(this, "INSTRUCTION_GENERAL", true, treeRootNode, true)); todo


        this.addChild(new InstructionGeneral(this, "INSTRUCTION_GENERAL", true, treeRootNode, false));
        addChildrenToSerialisationList();

    }

    public void setVariables(List<TokenNode> variables) {
        this.variables = variables;
    }

    @Override
    public void print() {
        for (Node child : this.getChildren()) {
            child.print();
        }
    }


    public List<TokenNode> getVariables() {
        return variables;
    }


    public void addVariable(TokenNode var) {
        this.variables.add(var);
    }

    public int getMaxReachedDepth() {
        return maxReachedDepth;
    }

    public boolean checkDepth(Node node) {
        if (node.getDepth() > this.maxReachedDepth) {
            this.maxReachedDepth = node.depth;
        }
        return maxReachedDepth < this.maxDepth;
    }



}

