package model.genetic;

import model.Node;
import model.Program;

import java.util.List;

public class GpRunner {

    public static void main(String[] args) {

        Program p1 = new Program();
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------\n");
        Program p2 = new Program();
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------\n");
        Program child =   Operations.cross(p1, p2);
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------\n");
        child.print();





    }




}
