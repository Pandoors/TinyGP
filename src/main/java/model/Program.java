package model;

import model.baseNodes.MathExpression;
import model.baseNodes.MathSymbol;
import model.baseNodes.NumVal;
import model.tokenNode.TokenNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program extends Node {

    protected List<TokenNode> variables;

    public Program() {
        super();
        this.variables = new ArrayList<>();

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
        this.addChild(new MathExpression(this, "MATH_EXPRESSION", true, treeRootNode));
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
}
