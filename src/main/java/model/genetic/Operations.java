package model.genetic;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.*;

public class Operations {


    public static Node mutation(Node node) {
        int randomInt = new Random().nextInt(node.getMaxDepth())/2;
        while(randomInt > 0) {
            randomInt--;
            if(node.getChildren().isEmpty()) {
                break;
            }
            node = node.getChildren().get(new Random().nextInt(node.getChildren().size()));
        }
        if(node instanceof TokenNode)
            node = node.getParentNode();
        node.getChildren().clear();
        node.getTreeRootNode().setMaxReachedDepth(0);
        node.generateRandomChildren();
        return node.getTreeRootNode();
    }

    public static Program cross(Program program1 , Program program2){

        int depth1=0, depth2=0;
        Node node1 = program1.getTreeRootNode().getChildren().get(0);
        Node node2 = program2.getTreeRootNode().getChildren().get(0);
        Node node3 = program1;
        Node node4 = program2;
        System.out.println("\n\n\n XD " + node1.getChildren().size() + " " + node2.getChildren().size());
        while (node1.getDepth() < program1.getMaxDepth()){
            if(node1.getChildren().size()==0 || node2.getChildren().size()==0 )
                break;
            node1 = node1.getChildren().get(new Random().nextInt(node1.getChildren().size()));
            while (node2.getDepth() < program2.getMaxDepth()){
                node2 = node2.getChildren().get(new Random().nextInt(node2.getChildren().size()));
                if (Operations.doVariablesMatch(node1, node2) && node1.getDepth() + node2.getDepth() <= program1.getMaxDepth()) {

                    if(node1.getChildren().size()==0 || node2.getChildren().size()==0 )
                        break;

                    // if the var2.size() > var1.size()
                    int size1 = node1.getTreeRootNode().getVariables().size();
                    int size2 = node2.getTreeRootNode().getVariables().size();
                    if (size1 > size2) {
                        for (int i = size2; i < size1; i++) {
                            node2.getTreeRootNode().getVariables().add(node1.getTreeRootNode().getVariables().get(i));// dodanie zmiennych
                        }

                        Node parent = node2.getParentNode();

                        parent.setChildren(List.of(node1));

                        return parent.getTreeRootNode();
                    }
                    Node parent = node2.getParentNode();

                    parent.setChildren(List.of(node1));

                    return parent.getTreeRootNode();
                }
            }

        }
        return null;
    }

    public static List<TokenNode> getVarsInBranch(Node node){
        List<TokenNode> branchVars = new ArrayList<>();
        for (Node child : node.getChildren()){
            branchVars.addAll(Operations.getVarsInBranch(child));
        }
        if(node instanceof TokenNode && ((TokenNode) node).getName().equals("IDENTIFIER")){
            branchVars.add((TokenNode)node);
        }
        return branchVars;
    }
    public static boolean doVariablesMatch(Node node1, Node node2){
        List<TokenNode> node1Tokens = Operations.getVarsInBranch(node1);
        List<TokenNode> node2Tokens = Operations.getVarsInBranch(node2);
        for(int i=0; i<Math.min(node1Tokens.size(), node2Tokens.size()); i++){
            if(!node2Tokens.get(i).getName().equals(node1Tokens.get(i).getName())) {
                return false;
            }
        }
        return true;
    }

    public static void swapNodes(Node node1, Node node2){

    }
    public static void serialize() {

    }

    public static void deserialize() {

    }

}

