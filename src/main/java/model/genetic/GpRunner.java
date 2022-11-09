package model.genetic;

import model.Node;
import model.Program;

import java.util.List;

public class GpRunner {

    public static void main(String[] args) {

        Program program = new Program();

        List<Node> nodes = Operations.getAllNodes(program);
        for(Node node: nodes)
        {
            System.out.println(node.getDepth() + " " + node.getName() + " " + node.getParentNode().getName()+ " \n");
        }
    }




}
