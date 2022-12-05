// Generated from /Users/bartosz/IdeaProjects/TinyGP/src/main/java/antlr/Bobaro.g4 by ANTLR 4.10.1
package visitor;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BobaroParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BobaroVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BobaroParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BobaroParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#writeOrOut}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteOrOut(BobaroParser.WriteOrOutContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#math_symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_symbol(BobaroParser.Math_symbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#num_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum_val(BobaroParser.Num_valContext ctx);
	/**
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_expr(BobaroParser.Math_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(BobaroParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#logic_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_condition(BobaroParser.Logic_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(BobaroParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#logic_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_statement(BobaroParser.Logic_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#logic_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_operator(BobaroParser.Logic_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(BobaroParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#while_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_loop(BobaroParser.While_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(BobaroParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#instruction_general}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction_general(BobaroParser.Instruction_generalContext ctx);
	/**
	 * Visit a parse tree produced by {@link BobaroParser#modification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModification(BobaroParser.ModificationContext ctx);
}