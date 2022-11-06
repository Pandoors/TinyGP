package model.tokenNode;

import model.Node;

public class TokenNode extends Node {
    private String token;

    public TokenNode(Node parentNode, String name, boolean isCrossable, String token) {
        super(parentNode, name, isCrossable);
        this.token = token;
    }

    @Override
    protected void addChild(Node child) {
        throw new UnsupportedOperationException("TokenNode cannot have children");
    }
}

