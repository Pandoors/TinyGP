package model.genetic;

import lombok.NoArgsConstructor;
import model.Program;
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

            //string to charsteam
            Stream<Character> charStream = program_txt.chars().mapToObj(c -> (char) c);


            CharStream charStream1 = CharStreams.fromString(program_txt);
            BobaroLexer lexer = new BobaroLexer(charStream1);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BobaroParser parser = new BobaroParser(tokens);

            String str = new BobaroVisitor().visit(parser.program());
            System.out.println(str);

            try (PrintWriter out = new PrintWriter("/Users/mikolajborowicz/Documents/Local/ProgramowanieGenetyczne/TinyGP/program.cpp")) {
                out.println(str);
            }catch (Exception e){
                e.printStackTrace();
            }

            List<String> commands = Arrays.asList(
                    "g++ /Users/mikolajborowicz/Documents/Local/ProgramowanieGenetyczne/TinyGP/program.cpp\n",
                    "./Users/mikolajborowicz/Documents/Local/ProgramowanieGenetyczne/TinyGP/a.out " + input + "\n");

            // create the process
            ProcessBuilder build = new ProcessBuilder(commands);
            Process process = build.start();
            process.waitFor();

            }catch (Exception e){
            e.printStackTrace();
        }




    }

    private void printEpoch(){
        System.out.println("Epoch: " + epoch++ + "score: ");
    }
}
