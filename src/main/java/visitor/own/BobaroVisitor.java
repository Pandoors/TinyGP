package visitor.own;

import visitor.BobaroBaseVisitor;
import visitor.BobaroParser;

public class BobaroVisitor  extends BobaroBaseVisitor<String> {

    @Override
    public String visitProgram(BobaroParser.ProgramContext ctx) {
        StringBuilder sb = new StringBuilder();

        sb.append(visitInstruction_general(ctx.instruction_general()));

        return sb.toString();    }

    @Override
    public String visitWriteOrOut(BobaroParser.WriteOrOutContext ctx) {
        StringBuilder sb = new StringBuilder();

        if(ctx.IDENTIFIER() != null) {
            sb.append("cout<< " + ctx.IDENTIFIER() + "<< endl" + ctx.SEMICOLON());
        }else if(ctx.INT_VAL() != null) {
            sb.append("cout<< " + ctx.INT_VAL() + "<< endl" + ctx.SEMICOLON());
        }
        return sb.toString();

    }

    @Override
    public String visitMath_symbol(BobaroParser.Math_symbolContext ctx) {
        return super.visitMath_symbol(ctx);
    }

    @Override
    public String visitNum_val(BobaroParser.Num_valContext ctx) {
        StringBuilder sb = new StringBuilder();

        if(ctx.INT_VAL() != null) {
            if(ctx.ADD_() != null) {
                sb.append(ctx.ADD_());
            }else if(ctx.SUBTRACT_() != null) {
                sb.append(ctx.SUBTRACT_());
            }
            sb.append(ctx.INT_VAL());
        }else if (ctx.IDENTIFIER() != null) {
            if(ctx.ADD_() != null) {
                sb.append(ctx.ADD_());
            }else if(ctx.SUBTRACT_() != null) {
                sb.append(ctx.SUBTRACT_());
            }
            sb.append(ctx.IDENTIFIER());
        }

        return sb.toString();
    }

    @Override
    public String visitMath_expr(BobaroParser.Math_exprContext ctx) {
        StringBuilder sb = new StringBuilder();

        if(ctx.math_symbol() != null) {
            sb.append(visitMath_expr(ctx.math_expr(0)));
            sb.append(visitMath_symbol(ctx.math_symbol()));
            sb.append(visitMath_expr(ctx.math_expr(1)));
        }else if(ctx.math_expr() != null) {
            sb.append(ctx.BRACKET_L());
            sb.append(visitMath_expr(ctx.math_expr(0)));
            sb.append(ctx.BRACKET_R());
        }
        else {
            sb.append(visitNum_val(ctx.num_val()));
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
        return super.visitLogic_condition(ctx);
    }

    @Override
    public String visitComparison(BobaroParser.ComparisonContext ctx) {
        return super.visitComparison(ctx);
    }

    @Override
    public String visitLogic_statement(BobaroParser.Logic_statementContext ctx) {
        return super.visitLogic_statement(ctx);
    }

    @Override
    public String visitLogic_operator(BobaroParser.Logic_operatorContext ctx) {

        StringBuilder sb = new StringBuilder();
        if(ctx.OR() != null) {
            sb.append(ctx.OR());
        } else if(ctx.AND() != null) {
            sb.append(ctx.AND());
        }
        return sb.toString();
    }

    @Override
    public String visitComparator(BobaroParser.ComparatorContext ctx) {
        return super.visitComparator(ctx);
    }

    @Override
    public String visitWhile_loop(BobaroParser.While_loopContext ctx) {
        StringBuilder sb = new StringBuilder();

        sb.append(ctx.WHILE());
        sb.append(visitLogic_condition(ctx.logic_condition()));
        sb.append(ctx.PARENT_L() + "\n");
        sb.append(visitInstruction_general(ctx.instruction_general()));
        sb.append(ctx.PARENT_R() + "\n");

        return sb.toString();
    }

    @Override
    public String visitInstruction(BobaroParser.InstructionContext ctx) {
        return super.visitInstruction(ctx);
    }

    @Override
    public String visitInstruction_general(BobaroParser.Instruction_generalContext ctx) {
        return super.visitInstruction_general(ctx);
    }

    @Override
    public String visitModification(BobaroParser.ModificationContext ctx) {

        StringBuilder sb = new StringBuilder();

        sb.append(ctx.IDENTIFIER());
        sb.append(ctx.EQUAL());

        if (ctx.math_expr() != null){
           sb.append(visitMath_expr(ctx.math_expr()));
        } else if(ctx.READ_OR_IN() != null){
            sb.append(ctx.READ_OR_IN());
        }

        return sb.toString();

    }
}
