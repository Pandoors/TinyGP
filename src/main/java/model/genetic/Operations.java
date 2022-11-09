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

    public static List<Node> getAllNodes(Node node){
        if (node.getChildren().isEmpty()) {
            return new ArrayList<>() {};
        }
        else
        {
            List<Node> nodes = new ArrayList<>();
            for(Node child : node.getChildren())
            {
                nodes.addAll(getAllNodes(child));
            }
            nodes.addAll(node.getChildren());
            return nodes;
        }
    }

    public static Program cros(Program program, Program program2){
        List<Node> nodeList1 = Operations.getAllNodes(program);
        List<Node> nodeList2 = Operations.getAllNodes(program2);


    }

    public static Program crossowanie(Node program1, Node program2){
        Node p1 = program1;
        Node p2 = program2;

        int randomInt = p1.getMaxDepth();
        int childindex = 0;
        while(randomInt > 0) {
            randomInt--;
            if(!(p1  instanceof TokenNode ) && !p1.getName().equals("rootNode") && !p1.getName().equals("INSTRUCTION_GENERAL")) {
                break;
            }
            Node parent = p1.getParentNode();
            try {
                p1 = parent.getChildren().get(childindex);
            } catch (IndexOutOfBoundsException e) {
                childindex = 0;
                p1 = parent.getChildren().get(childindex);
            }

            childindex++;
        }

        String name = p1.getName();

        int randomInt2 = p2.getMaxDepth();
        while(randomInt2 > 0) {
            randomInt2--;
            if(p2.getName().equals(p1.getName())) {
                break;
            }
            p2 = p2.getChildren().get(new Random().nextInt(p2.getChildren().size()));
        }
        if(p2.getName().equals(p1.getName())) {
            p2.setChildren(new ArrayList<>());
            p2.setChildren(p1.getChildren());

            System.out.println("EUREKA!!!!!!!!!!!!!!!!!!!!!!!!" + p2.getName());
        }
        return p2.getTreeRootNode();

    }

    public static Node crossing(Node node1, Node node2){
        int randomInt = new Random().nextInt(node1.getMaxDepth())/2;
        while(randomInt > 0) {
            randomInt--;
            if(node1.getChildren().isEmpty()) {
                break;
            }
            node1 = node1.getChildren().get(new Random().nextInt(node1.getChildren().size()));
        }
        if(node1 instanceof TokenNode)
            node1 = node1.getParentNode();
        node1.getChildren().clear();
        node1.getTreeRootNode().setMaxReachedDepth(0);

        int randomInt2 = new Random().nextInt(node2.getMaxDepth())/2;
        while(randomInt2 > 0) {
            randomInt2--;
            if(node2.getChildren().isEmpty()) {
                break;
            }
            node2 = node2.getChildren().get(new Random().nextInt(node2.getChildren().size()));
        }
        if( node1.getName().equals(node2.getName())){
            List<Node> children = new ArrayList<>();
            children.addAll(node2.getChildren());
            node1.setChildren(children);
            return node1.getTreeRootNode();
        }
       return null;
    }


//    public static Program crossover(Program program1, Program program2){
//        //exhange two random chosen nodes in tree with the same name
//        // return combined program
//        // if no nodes with the same name are found, return null
//        Node node1 = program1.getTreeRootNode();
//        Node node2 = program2.getTreeRootNode();
//        int randomInt = new Random().nextInt(node1.getMaxDepth())/2;
//        while(randomInt > 0) {
//            randomInt--;
//            if(node1.getChildren().isEmpty()) {
//                break;
//            }
//            node1 = node1.getChildren().get(new Random().nextInt(node1.getChildren().size()));
//        }
//        randomInt = new Random().nextInt(node2.getMaxDepth())/2;
//        while(randomInt > 0) {
//            randomInt--;
//            if(node2.getChildren().isEmpty()) {
//                break;
//            }
//            node2 = node2.getChildren().get(new Random().nextInt(node2.getChildren().size()));
//        }
//        if(node1.getName().equals(node2.getName())){
//            Node temp = node1.getParentNode();
//            node1.getParentNode().getChildren().remove(node1);
//            node2.getParentNode().getChildren().remove(node2);
//            node1.setParentNode(node2.getParentNode());
//            node2.setParentNode(temp);
//            node1.getParentNode().getChildren().add(node1);
//            node2.getParentNode().getChildren().add(node2);
//        }
//        else{
//            return null;
//        }
//        Program program = new Program();
//        program.setTreeRootNode(node1.getTreeRootNode());
//        return program;
//
//    }

//    public static Node crossover(Node node1, Node node2) {
//        int randomInt = new Random().nextInt(node1.getMaxDepth()) / 2;
//        while (randomInt > 0) {
//            randomInt--;
//            if (node1.getChildren().isEmpty()) {
//                break;
//            }
//            node1 = node1.getChildren().get(new Random().nextInt(node1.getChildren().size()));
//        }
//
//        while (node2.getChildren().isEmpty()) {
//            if (node2.getChildren().isEmpty()) {
//                break;
//            }
//            if(node2 instanceof TokenNode)
//                node2 = node2.getParentNode();
//            if(Objects.equals(node2.getName(), node1.getName())){
//                node2.getChildren().clear();
//                node2.setChildren(node1.getChildren());
//                return node2.getTreeRootNode();
//            }
//            node2 = node2.getChildren().get(new Random().nextInt(node2.getChildren().size()));
//        }
//
//        return null;
//
//    }


//    public static List<List<Integer>> cross(Program program1 , Program program2){
//
//        int depth1=0, depth2=0;
//        Node node1 = program1.getTreeRootNode().getChildren().get(0);
//        Node node2 = program2.getTreeRootNode().getChildren().get(0);
//        Node node3 = program1;
//        Node node4 = program2;
//        List<Integer> path1 = new ArrayList<>();
//        List<Integer> path2 = new ArrayList<>();
//
//        System.out.println("\n\n\n XD " + node1.getChildren().size() + " " + node2.getChildren().size());
//        while (node1.getDepth() < program1.getMaxDepth()){
//            if(node1.getChildren().size()==0 || node2.getChildren().size()==0 )
//                break;
//            int choice1 = new Random().nextInt(node1.getChildren().size());
//            node1 = node1.getChildren().get(choice1);
//            path1.add(choice1);
//            while (node2.getDepth() < program2.getMaxDepth()){
//                if(node2.getChildren().size()==0)
//                    break;
//                int choice2 = new Random().nextInt(node2.getChildren().size());
//                node2 = node2.getChildren().get(choice2);
//                path2.add(choice2);
//                if (Operations.doVariablesMatch(node1, node2) && node1.getDepth() + node2.getDepth() <= program1.getMaxDepth()) {
//
//                    if(node1.getChildren().size()==0 || node2.getChildren().size()==0 )
//                        break;
//
//                    // if the var2.size() > var1.size()
//                    int size1 = node1.getTreeRootNode().getVariables().size();
//                    int size2 = node2.getTreeRootNode().getVariables().size();
//                    if (size1 > size2) {
//                        for (int i = size2; i < size1; i++) {
//                            node2.getTreeRootNode().getVariables().add(node1.getTreeRootNode().getVariables().get(i));// dodanie zmiennych
//                        }
//
//                        Node parent = node2.getParentNode();
//
//                        parent.setChildren(List.of(node1));
//
//                        return List.of(path1, path2);
//                    }
//                    Node parent = node2.getParentNode();
//
//                    parent.setChildren(List.of(node1));
//
//                    return List.of(path1, path2);
//                }
//            }
//        }
//        return null;
//    }
//
//    public static Node perform_cross(Program program1, Program program2){
//        List<List<Integer>> paths = Operations.cross(program1, program2);
//        if(paths == null)
//            return null;
//        List<Integer> path1 = paths.get(0);
//        List<Integer> path2 = paths.get(1);
//        Node node1 = program1.getTreeRootNode().getChildren().get(0);
//        Node node2 = program2.getTreeRootNode().getChildren().get(0);
//        for(int i = 0; i < path1.size(); i++){
//            node1 = node1.getChildren().get(path1.get(i));
//        }
//        for(int i = 0; i < path2.size(); i++){
//            node2 = node2.getChildren().get(path2.get(i));
//        }
//        Node parent2 = node2.getParentNode();
//        parent2.setChildren(List.of(node1));
//
//        return program2.copy();
//    }

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

