package model;

import model.baseNodes.*;
import model.tokenNode.TokenNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program extends Node {

    protected List<TokenNode> variables;

    private int maxReachedDepth;

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

    @Override
    protected void addChild(Node child) {
        this.getChildren().add(child);
    }

    @Override
    public void generateRandomChildren() {
//          todo koniecznie jesli to jest empty nie przechodzimy do modification! tu jest ten check
//todo boro tutaj jakis depth ? moze do while-a proponuje dodac warunek z glebokoscia oprocz tego random inta

        this.addChild(new InstructionGeneral(this, "INSTRUCTION_GENERAL", true, treeRootNode));
        addChildrenToSerialisationList();
        this.print();
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
