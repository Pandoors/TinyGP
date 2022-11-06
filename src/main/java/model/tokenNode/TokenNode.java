package model.tokenNode;

import lombok.ToString;
import model.Node;
import model.Program;

@ToString
public class TokenNode extends Node {
    protected String token;

    public TokenNode(Node parentNode, String name, boolean isCrossable, String token, Program program) {
        super(parentNode, name, isCrossable, program);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    protected void addChild(Node child) {
        throw new UnsupportedOperationException("TokenNode cannot have children");
    }
    @Override
    public void generateRandomChildren() {
        throw new UnsupportedOperationException("TokenNode cannot have children");
    }
    @Override
    public void print() {
        System.out.print(token);
    }
}

