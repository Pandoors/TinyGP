package model;

import model.baseNodes.*;
import model.tokenNode.TokenNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program extends Node {

    protected List<TokenNode> variables;

    public Program() {
        super();
        this.variables = new ArrayList<>();

        this.setDepth(0);
        this.setMaxDepth(100);
        // XDD 5 gestosc kodu
        this.treeRootNode = this;

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
        Random random = new Random();
        int randomInt = random.nextInt(2);
        while(randomInt != 1) { // todo to jest gwiazdka wieeec w sumie to moze byc pusty program
            this.addChild(new InstructionGeneral(this, "INSTRUCTION_GENERAL", true, treeRootNode));
            randomInt = random.nextInt(2);
        }
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

}
