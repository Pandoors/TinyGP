package visitor.own;

import org.antlr.v4.runtime.tree.TerminalNode;
import visitor.BobaroBaseVisitor;
import visitor.BobaroParser;

public class BobaroVisitor extends BobaroBaseVisitor<String> {

    @Override
    public String visitProgram(BobaroParser.ProgramContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("#include <iostream>;#include <fstream>; using namespace std; int main(int argc, char *argv[]) {");
        sb.append("int rotations = 0; int i=0;  ofstream myfile; output.open(\"output.txt\");");

        sb.append("int max = argv[0];");
        sb.append(visitInstruction_general(ctx.instruction_general()));

        sb.append("output.close();return 0;}");
        return sb.toString();
    }

    @Override
    public String visitWriteOrOut(BobaroParser.WriteOrOutContext ctx) {
        StringBuilder sb = new StringBuilder();

        if (ctx.IDENTIFIER() != null) {
            sb.append("output<< " + ctx.IDENTIFIER() + "<< endl" + ctx.SEMICOLON());
        } else if (ctx.INT_VAL() != null) {
            sb.append("output<< " + ctx.INT_VAL() + "<< endl" + ctx.SEMICOLON());
        }
        return sb.toString();

    }

    @Override
    public String visitMath_symbol(BobaroParser.Math_symbolContext ctx) {
        StringBuilder sb = new StringBuilder();

        if (ctx.ADD_() != null) {
            sb.append(ctx.ADD_());

        } else if (ctx.SUBTRACT_() != null) {
            sb.append(ctx.SUBTRACT_());

        } else if (ctx.MULTIPLY() != null) {
            sb.append(ctx.MULTIPLY());

        } else if (ctx.DIVIDE() != null) {
            sb.append(ctx.DIVIDE());

        }
        return sb.toString();
    }

    @Override
    public String visitNum_val(BobaroParser.Num_valContext ctx) {
        StringBuilder sb = new StringBuilder();

        if (ctx.INT_VAL() != null) {
            if (ctx.ADD_() != null) {
                sb.append(ctx.ADD_());
            } else if (ctx.SUBTRACT_() != null) {
                sb.append(ctx.SUBTRACT_());
            }
            sb.append(ctx.INT_VAL());
        } else if (ctx.IDENTIFIER() != null) {
            if (ctx.ADD_() != null) {
                sb.append(ctx.ADD_());
            } else if (ctx.SUBTRACT_() != null) {
                sb.append(ctx.SUBTRACT_());
            }
            sb.append(ctx.IDENTIFIER());
        }

        return sb.toString();
    }

    @Override
    public String visitMath_expr(BobaroParser.Math_exprContext ctx) {
        StringBuilder sb = new StringBuilder();

        if (ctx.math_expr().size() == 2) {
            sb.append(visitMath_expr(ctx.math_expr().get(0)));
            sb.append(visitMath_symbol(ctx.math_symbol()) + " ");
            sb.append(visitMath_expr(ctx.math_expr().get(1)));
        } else if (ctx.num_val() != null) {
            sb.append(visitNum_val(ctx.num_val()) + " ");
        } else if (ctx.BRACKET_L() != null) {
            sb.append(ctx.BRACKET_L() + " ");
            sb.append(visitMath_expr(ctx.math_expr().get(0)));
            sb.append(ctx.BRACKET_R() + " ");
        }


        return sb.toString();
    }

    @Override
    public String visitIf_statement(BobaroParser.If_statementContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append(ctx.IF());
        sb.append(visitLogic_condition(ctx.logic_condition()));
        sb.append((ctx.PARENT_L()) + "\n");
//        for (BobaroParser.InstructionContext ic : ctx.instruction()){
//            sb.append(visitInstruction(ic));
//        }
        sb.append(visitInstruction_general(ctx.instruction_general()));
        sb.append(ctx.PARENT_R() + "\n");
        return sb.toString();

    }

    @Override
    public String visitLogic_condition(BobaroParser.Logic_conditionContext ctx) {
        StringBuilder sb = new StringBuilder();

        sb.append(ctx.BRACKET_L());
        if (ctx.logic_statement().size() == 1) {
            sb.append(visitLogic_statement(ctx.logic_statement().get(0)));
        } else if (ctx.logic_statement().size() > 1) {
            sb.append(visitLogic_statement(ctx.logic_statement().get(0)));
            for (int i = 0; i < ctx.logic_operator().size(); i++) {
                sb.append(visitLogic_operator(ctx.logic_operator().get(i)));
                sb.append(" " + visitLogic_statement(ctx.logic_statement().get(i + 1)));
            }
        }
        sb.append(ctx.BRACKET_R());
        return sb.toString();
    }

    @Override
    public String visitComparison(BobaroParser.ComparisonContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append(visitNum_val(ctx.num_val().get(0)));
        sb.append(" " + visitComparator(ctx.comparator()));
        sb.append(" " + visitNum_val(ctx.num_val().get(1)) + " ");
        return sb.toString();
    }

    @Override
    public String visitLogic_statement(BobaroParser.Logic_statementContext ctx) {
        StringBuilder sb = new StringBuilder();
        if (ctx.comparison() != null) sb.append(visitComparison(ctx.comparison()));
        else if (ctx.num_val() != null) sb.append(visitNum_val(ctx.num_val()));

        return sb.toString();
    }

    @Override
    public String visitLogic_operator(BobaroParser.Logic_operatorContext ctx) {
        StringBuilder sb = new StringBuilder();
        if (ctx.AND() != null) sb.append(ctx.AND());
        else if (ctx.OR() != null) sb.append(ctx.OR());

        return sb.toString();
    }

    @Override
    public String visitComparator(BobaroParser.ComparatorContext ctx) {
        StringBuilder sb = new StringBuilder();

        if (ctx.EQUAL() != null) {
            for (TerminalNode tn : ctx.EQUAL()) {
                sb.append(tn);
            }
        } else if (ctx.NOT_EQUAL() != null) {
            sb.append(ctx.NOT_EQUAL());
        } else if (ctx.GREATER() != null) {
            sb.append(ctx.GREATER());
        } else if (ctx.LESS() != null) {
            sb.append(ctx.LESS());
        } else if (ctx.GREATER_EQUAL() != null) {
            sb.append(ctx.GREATER_EQUAL());
        } else if (ctx.LESS_EQUAL() != null) {
            sb.append(ctx.LESS_EQUAL());
        }

        return sb.toString();
    }

    @Override
    public String visitWhile_loop(BobaroParser.While_loopContext ctx) {
        StringBuilder sb = new StringBuilder();

        sb.append(ctx.WHILE());
        sb.append(visitLogic_condition(ctx.logic_condition()));
        sb.append(ctx.PARENT_L() + "\n");
        sb.append(visitInstruction_general(ctx.instruction_general()));
        sb.append("if(rotatitons>max)break;");
        sb.append(ctx.PARENT_R() + "\n");

        return sb.toString();
    }

    @Override
    public String visitInstruction(BobaroParser.InstructionContext ctx) {

        StringBuilder sb = new StringBuilder();
        //sb.append(ctx.SEMICOLON() + "\n");

        if (ctx.modification() != null) {
            sb.append(visitModification(ctx.modification()));
            sb.append(ctx.SEMICOLON() + "\n");
        } else if (ctx.if_statement() != null) {
            sb.append(visitIf_statement(ctx.if_statement()));
        } else if (ctx.while_loop() != null) {
            sb.append(ctx.while_loop());
        } else if (ctx.writeOrOut() != null) {
            sb.append(visitWriteOrOut(ctx.writeOrOut()));
        }

        return sb.toString();

    }

    @Override
    public String visitInstruction_general(BobaroParser.Instruction_generalContext ctx) {

        StringBuilder sb = new StringBuilder();
        for (BobaroParser.InstructionContext ic : ctx.instruction()) {
            sb.append(visitInstruction(ic));
        }
        return sb.toString();
    }

    @Override
    public String visitModification(BobaroParser.ModificationContext ctx) {

        StringBuilder sb = new StringBuilder();
        if (ctx.math_expr() != null) {
            sb.append(ctx.IDENTIFIER());
            sb.append(ctx.EQUAL());
            sb.append(visitMath_expr(ctx.math_expr()));
        } else if (ctx.READ_OR_IN() != null) {
            sb.append("if(++i>=argc){output<<\"ERROR\"<<endl;output.close();return 0;");
            sb.append(ctx.IDENTIFIER());
            sb.append(ctx.EQUAL());
            sb.append("argv[i]");
        }

        return sb.toString();

    }
}
