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
        // todo narazie testowo daje tutaj mathExpression
//        this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
//        this.addChild(new Assignment(this, "ASSIGNMENT", true, treeRootNode));

//          todo koniecznie jesli to jest empty nie przechodzimy do modification! tu jest ten check
//        if (randomInt_1 == 1 && this.treeRootNode.getVariables().isEmpty()) {
//            randomInt_1 = 0;
//        }>>>>
        this.addChild(new Modification(this, "MODIFICATION", true, treeRootNode));
        this.print();
    }

    @Override
    public void print() {
        for(Node child : this.getChildren()) {
            child.print();
        }
    }


    public List<TokenNode> getVariables() {
        return variables;
    }


    public void addVariable(TokenNode var){
        this.variables.add(var);
    }

}
