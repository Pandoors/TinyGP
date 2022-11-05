grammar Bobaro;

INT_VAL: [1-9][0-9]*;
STRING_VAL: '"' ('\\' ["\\] | ~["\\\r\n])* '"' ;
BOOL: 'boolean';
NULL: 'null'; //todo NOWE
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
IDENTIFIER: [a-zA-Z][a-zA-Z0-9]*;
WS   : [ \t\r\n]+ -> skip;


program: instruction_general | EOF;

readOrIn: 'sysIn()';

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

assignment: INT IDENTIFIER EQUAL (math_expr | readOrIn)
| STRING IDENTIFIER EQUAL (STRING_VAL | readOrIn )
| BOOL IDENTIFIER EQUAL (bool_val | readOrIn );

if_statement: IF logic_condition PARENT_L instruction_general PARENT_R;

logic_condition: BRACKET_L logic_statement (logic_operator logic_statement)* BRACKET_R;

comparison: num_val comparator num_val;

logic_statement: comparison | bool_val;

logic_operator: OR | AND;

comparator: EQUAL EQUAL
| NOT_EQUAL
| GREATER
| LESS
| GREATER_EQUAL
| LESS_EQUAL;

for_loop: FOR BRACKET_L assignment SEMICOLON comparison SEMICOLON modification BRACKET_R PARENT_L instruction_general PARENT_R;

instruction: assignment SEMICOLON
| modification SEMICOLON
| if_statement
| for_loop
| writeOrOut;

instruction_general: (instruction | COMMENT)*;

modification: IDENTIFIER EQUAL (math_expr | readOrIn);