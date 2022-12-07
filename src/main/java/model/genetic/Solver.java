package model.genetic;

import lombok.NoArgsConstructor;
import model.Program;
import model.tokenNode.TokenNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.math3.util.IntegerSequence;
import visitor.BobaroLexer;
import visitor.BobaroParser;
import visitor.own.BobaroVisitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


public class Solver {
    private int epoch=0;
    private final Integer eps = 1;
    private List<Program> programs = new ArrayList<>();



    public Solver() {
        int reachedFitness = 0;

        for (int i : new IntegerSequence.Range(0, 100, 1)) {
            programs.add(new Program(false));
        }


    }

    public void solve() {
        evaluate();
        saveAndCompile(programs.get(0), " 0 0 0 0 0 0 0 0 ");
    }

    public void evaluate() {
        // tournament -> crossover2 best -> negative tournament -> mutation
        switch (new Random().nextInt(2)) {
            case 0:
                mutation();
                break;
            case 1:
                List<Program> tournamentResult = tournament(2);
                Program program = Operations.cross(tournamentResult.get(0), tournamentResult.get(1));
                for (int i = 0; i < negative_tournament(1).size(); i++) {
                    programs.set(i, program);

                }

        }
    }

    public List<Program> tournament(int a) {
        List<Program> winners = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            winners.add(programs.get(new Random().nextInt(programs.size())));

        }
        return winners;
    }

    public List<Integer> negative_tournament(int a) {
        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            winners.add(i);
        }
        return winners;
    }

    public void mutation() {
        int a = run();
        this.programs.set(a, (Program) Operations.mutation(programs.get(a)));

    }

    private int run() {
        return new Random().nextInt(programs.size());
    }

    private void calculateEvaluation() {

        for (Program program : this.programs) {
            ;
        }

    }

    private void saveAndCompile(Program program, String input)  {
        try{
            String program_txt = program.getTreeProgTxt();
            System.out.println("\n ------- program txt in Bobaro-------\n");
            System.out.println(program_txt);
            System.out.println("\n ------- program txt end -------\n");
            //string to charsteam
//            Stream<Character> charStream = program_txt.chars().mapToObj(c -> (char) c);


            CharStream charStream1 = CharStreams.fromString(program_txt);
            BobaroLexer lexer = new BobaroLexer(charStream1);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BobaroParser parser = new BobaroParser(tokens);
            String str = new BobaroVisitor().visit(parser.program());
            StringBuilder sb = new StringBuilder();
            if(program.getVariables()!=null && !program.getVariables().isEmpty()) {

                sb.append("int ");
                boolean first = true;
                for (TokenNode tn : program.getVariables()) {
                    if(!first){
                        sb.append(", ");
                    }
                    sb.append(tn.getToken());
                    first=false;
                }
                sb.append(";");
            }
            String toInsert = sb.toString();
            String searchPhrase = "char *argv[]) {";
            int pos_str = str.indexOf(searchPhrase)+searchPhrase.length();
            str = new StringBuilder(str).insert(pos_str, toInsert).toString();


            System.out.println("\n ------- program txt in Cpp -------\n");
            System.out.println(str);
            System.out.println("\n ------- program txt in Cpp end -------\n");

            try (PrintWriter out = new PrintWriter("/Users/bartosz/IdeaProjects/TinyGP/program.cpp")) {
                out.println(str);
            }catch (Exception e){
                e.printStackTrace();
            }

            ProcessBuilder build =
                    new ProcessBuilder("g++", "/Users/bartosz/IdeaProjects/TinyGP/program.cpp");

            // create the process
            Process process = build.start();
            process.waitFor();
            ProcessBuilder build2 =
                    new ProcessBuilder("/Users/bartosz/IdeaProjects/TinyGP/a.out");

            // create the process
            Process process2 = build2.start();
            process2.waitFor();
            }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void printEpoch(){
        System.out.println("Epoch: " + epoch++ + "score: ");
    }
}
