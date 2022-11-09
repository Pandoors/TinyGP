package model.genetic;

import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import java.util.*;
import java.util.stream.Collectors;

public class Operations {


    public static Node mutation(Node node) {

        System.out.println("\n---------------------------------------BEFORE-MUTATION----------------------------------------\n");
        node.getTreeRootNode().print();
        System.out.println("\n---------------------------------------BEFORE-MUTATION-END----------------------------------------\n");


        int randomInt = new Random().nextInt(node.getMaxDepth()/2);
        while (randomInt > 0 || !(List.of("rootNode", "INSTRUCTION_GENERAL").contains(node.getName())) ) {
            randomInt--;
            if (node.getChildren().isEmpty()) {
                break;
            }
            node = node.getChildren().get(new Random().nextInt(node.getChildren().size()));
        }
        if (node instanceof TokenNode)
            node = node.getParentNode();
        node.getChildren().clear();
        node.getTreeRootNode().setMaxReachedDepth(0);
        node.generateRandomChildren();
        System.out.println("\n---------------------------------------MUTATION----------------------------------------\n");
        node.getTreeRootNode().print();
        System.out.println("\n---------------------------------------MUTATION-END----------------------------------------\n");

        return node.getTreeRootNode();
    }

    public static List<Node> getAllNodes(Node node) {
        if (node.getChildren().isEmpty()) {
            return new ArrayList<>() {
            };
        } else {
            List<Node> nodes = new ArrayList<>();
            for (Node child : node.getChildren()) {
                nodes.addAll(getAllNodes(child));
            }
            nodes.addAll(node.getChildren());
            return nodes;
        }
    }

    public static Program cross(Program program1, Program program2) {
        List<Node> nodeList1 = Operations.getAllNodes(program1)
                .stream().filter(n -> List.of("INSTRUCTION").contains(n.getName())).collect(Collectors.toList());
        List<Node> nodeList2 = Operations.getAllNodes(program2)
                .stream().filter(n -> List.of("INSTRUCTION").contains(n.getName())).collect(Collectors.toList());



        if (nodeList1.isEmpty() || nodeList2.isEmpty()) {
            return null;
        }

        System.out.println("\n---------------------------------------CROSS P1----------------------------------------\n");
        program1.getTreeRootNode().print();
        System.out.println("\n---------------------------------------CROSS P1 END----------------------------------------\n");
        System.out.println("\n---------------------------------------CROSS P2----------------------------------------\n");
        program2.getTreeRootNode().print();
        System.out.println("\n---------------------------------------CROSS P2 END----------------------------------------\n");



        Random random = new Random();
        int r_1 = random.nextInt(nodeList1.size());
        int r_2 = random.nextInt(nodeList2.size());

        Node p1 = nodeList1.get(r_1);
        Node p2 = nodeList2.get(r_2);
        p2.setChildren(new ArrayList<>());
        p2.setChildren(p1.getChildren());

        System.out.println("\n---------------------------------------CROSS-RESULT----------------------------------------\n");
        p2.getTreeRootNode().print();
        System.out.println("\n---------------------------------------CROSS-RESULT-END----------------------------------------\n");

        return p2.getTreeRootNode();
    }


    public static List<TokenNode> getVarsInBranch(Node node) {
        List<TokenNode> branchVars = new ArrayList<>();
        for (Node child : node.getChildren()) {
            branchVars.addAll(Operations.getVarsInBranch(child));
        }
        if (node instanceof TokenNode && ((TokenNode) node).getName().equals("IDENTIFIER")) {
            branchVars.add((TokenNode) node);
        }
        return branchVars;
    }

    public static boolean doVariablesMatch(Node node1, Node node2) {
        List<TokenNode> node1Tokens = Operations.getVarsInBranch(node1);
        List<TokenNode> node2Tokens = Operations.getVarsInBranch(node2);
        for (int i = 0; i < Math.min(node1Tokens.size(), node2Tokens.size()); i++) {
            if (!node2Tokens.get(i).getName().equals(node1Tokens.get(i).getName())) {
                return false;
            }
        }
        return true;
    }


}

