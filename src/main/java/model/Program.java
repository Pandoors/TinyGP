package model;

import model.baseNodes.*;
import model.tokenNode.TokenNode;

import java.util.ArrayList;
import java.util.List;


public class Program extends Node {

    protected List<TokenNode> variables;
    private Double evaluateResult;
    private int maxReachedDepth;
    private double reachedFitness;

    public void setMaxReachedDepth(int maxReachedDepth) {
        this.maxReachedDepth = maxReachedDepth;
    }

    public Program() {
        super();
        this.variables = new ArrayList<>();
        this.evaluateResult = 0d;
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
        this.evaluateResult = 0d;

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

        this.addChild(new InstructionGeneral(this, "INSTRUCTION_GENERAL", true, treeRootNode));
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

    @Override
    public String getTreeProgTxt() {
        StringBuilder sb = new StringBuilder();
        for (Node child : this.getChildren()) {
            sb.append(child.getTreeProgTxt());
        }
        return sb.toString();
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

    public Double getEvaluateResult() {
        return evaluateResult;
    }

    public void setEvaluateResult(Double evaluateResult) {
        this.evaluateResult = evaluateResult;
    }

    public double getReachedFitness() {
        return reachedFitness;
    }

    public void setReachedFitness(double avgFitness) {
        this.reachedFitness = avgFitness;
    }
}

