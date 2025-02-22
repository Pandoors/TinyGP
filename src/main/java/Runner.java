import definition.TinyGp;
import definition.TinyGpExtended;
import model.Node;
import model.Program;
import model.genetic.Operations;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import utils.Evaluator;
import utils.ParserXLSX;
import visitor.BobaroLexer;
import visitor.BobaroParser;
import visitor.own.BobaroVisitor;

import java.io.*;

public class Runner {

    public static void main(String[] args) throws IOException {
        String fname = null;
        String log = null;

        if (args.length == 2) {
            fname = args[1];
            log = args[0];
        }

        Program p1 = new Program(false);

        Operations.mutation(p1);



//        CharStream in = CharStreams.fromFileName("/Users/bartosz/IdeaProjects/TinyGP/src/main/resources/example_1.txt");
//        BobaroLexer lexer = new BobaroLexer(in);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        BobaroParser parser = new BobaroParser(tokens);
//
//        String str = new BobaroVisitor().visit(parser.program());
//        System.out.println(str);
//
//        try (PrintWriter out = new PrintWriter("output.txt")) {
//            out.println(str);
//        }

    }

    private static void antlrScan(){

    }

    private static void evolve(String name, String log) {
        // passing some example files if arguments empty
        String fname = name != null ? name : "src/main/resources/values/tan_w_d_tan.dat";
        String logName = log != null ? log : "src/main/resources/output-functions/tan_w_d_tan.txt";
        long s = 402456;

        TinyGp gp = new TinyGp(fname, s, logName);
        gp.evolve();
    }

    private static void evolveExtended(String name, String log) {
        // passing some example files if arguments empty 1,4
        String fname = name != null ? name : "src/main/resources/values/val6_4.dat";
        String logName = log != null ? log : "src/main/resources/output-functions/val6_4_ext.txt";
        long s = 402456;

        TinyGpExtended gpe = new TinyGpExtended(fname, s, logName);
        gpe.evolve();


    }

    private static void parse() {
        ParserXLSX parserXLSX = new ParserXLSX();
        parserXLSX.parseAllExistingLogs();
    }

    private static void evaluateFunctions() {
        Evaluator ev = new Evaluator();
        String dirName = "src/main/resources/final-functions-not-simplified";
        String dirName2 = "src/main/resources/final-functions-simplified";
        File dir = new File(dirName);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                String optimized = null;
                try (BufferedReader br = new BufferedReader(new FileReader(child))) {
                    String func = null;
                    while ((func = br.readLine()) != null) {

                        optimized = ev.optimize(func);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (optimized != null) {
                    try {
                        Writer output;
                        output = new BufferedWriter(new FileWriter(dirName2
                                .concat("/")
                                .concat(child.getName()), true));

                        output.append(optimized);
                        output.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
        }

    }

    private static void testEvaluate() {
        Evaluator ev = new Evaluator();
        String dirName = "src/main/resources/final-functions-not-simplified";
        String dirName2 = "src/main/resources/final-functions-simplified";
        File f1 = new File("src/main/resources/final-functions-not-simplified/val1_2_ext.txt");
        File f2 = new File("src/main/resources/final-functions-not-simplified/val1_2.txt");


        String optimized = null;
        try (BufferedReader br = new BufferedReader(new FileReader(f1))) {
            String func = null;
            while ((func = br.readLine()) != null) {

                optimized = ev.optimize(func);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (optimized != null) {
            try {
                Writer output;
                output = new BufferedWriter(new FileWriter(dirName2
                        .concat("/")
                        .concat(f1.getName()), true));

                output.append(optimized);
                output.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }


    }
}



