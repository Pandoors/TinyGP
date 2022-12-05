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
        return super.visitWriteOrOut(ctx);
    }

    @Override
    public String visitMath_symbol(BobaroParser.Math_symbolContext ctx) {
        return super.visitMath_symbol(ctx);
    }

    @Override
    public String visitNum_val(BobaroParser.Num_valContext ctx) {
        return super.visitNum_val(ctx);
    }

    @Override
    public String visitMath_expr(BobaroParser.Math_exprContext ctx) {
        return super.visitMath_expr(ctx);
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
        return super.visitLogic_operator(ctx);
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
