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
        // XDD 5 gestosc kodu
        this.treeRootNode = this;
        this.maxReachedDepth = 0;
        this.generateRandomChildren();
    }

    public Program(boolean x){
        super();
        this.variables = new ArrayList<>();

        this.setDepth(0);
        this.setMaxDepth(10);
        // XDD 5 gestosc kodu
        this.treeRootNode = this;
        this.maxReachedDepth = 0;
    }

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    @Override
    public void generateRandomChildren() {
//          todo koniecznie jesli to jest empty nie przechodzimy do modification! tu jest ten check
//todo boro tutaj jakis depth ? moze do while-a proponuje dodac warunek z glebokoscia oprocz tego random inta

        this.addChild(new InstructionGeneral(this, "INSTRUCTION_GENERAL", true, treeRootNode));
        this.print();
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

    public Program copy(){
        Program program = new Program(true);
        program.setDepth(this.depth);
        program.setMaxDepth(this.maxDepth);
        program.setMaxReachedDepth(this.maxReachedDepth);
        program.setTreeRootNode(this.treeRootNode);
        program.setVariables(this.variables);
        program.setChildren(this.children);
        return program;
    }

}

