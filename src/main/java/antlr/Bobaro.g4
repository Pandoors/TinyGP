grammar Bobaro;

INT_VAL: [1-9][0-9]*;
STRING_VAL: '"' ('\\' ["\\] | ~["\\\r\n])* '"' ;
BOOL: 'boolean';
COMMENT: '//'~[\r\n]*;
OR: '||';
AND: '&&';
EQUAL: '=';
INT: 'int';
TRUE: 'true';
FALSE: 'false';
STRING: 'string';
NOT_EQUAL: '!=';
GREATER: '>';
LESS: '<';
GREATER_EQUAL: '>=';
LESS_EQUAL: '<=';
BRACKET_L: '(';
BRACKET_R: ')';
SQ_BRACKET_L: '[';
SQ_BRACKET_R: ']';
PARENT_L: '{';
PARENT_R: '}';
ADD_: '+';
SUBTRACT_: '-';
MULTIPLY: '*';
DIVIDE: '/';
MODULO: '%';
IF: 'if';
ELSE: 'else';
FOR: 'for';
SEMICOLON: ';';
COMMA: ',';
READ_OR_IN: 'sysIn()';
IDENTIFIER: [a-zA-Z][a-zA-Z0-9]*;
WS   : [ \t\r\n]+ -> skip;


program: instruction_general | EOF;


writeOrOut: 'printl(' STRING_VAL ')'  SEMICOLON;

math_symbol: ADD_
| SUBTRACT_
| MULTIPLY
| DIVIDE;

bool_val: TRUE
| FALSE;

num_val: (ADD_ | SUBTRACT_)? INT_VAL
| (ADD_ | SUBTRACT_)? IDENTIFIER;

math_expr: math_expr math_symbol math_expr
| BRACKET_L math_expr BRACKET_R
| num_val;

assignment: INT IDENTIFIER EQUAL (math_expr | READ_OR_IN)
| STRING IDENTIFIER EQUAL (STRING_VAL | READ_OR_IN )
| BOOL IDENTIFIER EQUAL (bool_val | READ_OR_IN );

if_statement: IF logic_condition PARENT_L  (instruction | COMMENT )*  PARENT_R;

logic_condition: BRACKET_L logic_statement (logic_operator logic_statement)* BRACKET_R;

comparison: num_val comparator num_val;

logic_statement: comparison | bool_val; //1 max 2 mindeph(bool) 1 minDepth(comparison) = 2

logic_operator: OR | AND;

comparator: EQUAL EQUAL
| NOT_EQUAL
| GREATER
| LESS
| GREATER_EQUAL
| LESS_EQUAL;

for_loop: FOR BRACKET_L assignment SEMICOLON comparison SEMICOLON modification BRACKET_R PARENT_L (instruction | COMMENT )* PARENT_R;

instruction: modification SEMICOLON
| if_statement
| for_loop
| writeOrOut;

instruction_general: (instruction | COMMENT | assignment SEMICOLON)*;

modification: IDENTIFIER EQUAL (math_expr | READ_OR_IN);