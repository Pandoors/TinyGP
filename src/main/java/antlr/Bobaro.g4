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


program: instruction_general; // minDepth: 2, @Bartek tu powinna być ta '|' ?

writeOrOut: 'printl(' STRING_VAL ')'  SEMICOLON; // minDepth: 1

math_symbol: ADD_ // minDepth=1
| SUBTRACT_
| MULTIPLY
| DIVIDE;

bool_val: TRUE // minDepth: 1
| FALSE;

num_val: (ADD_ | SUBTRACT_)? INT_VAL // minDepth: 1
| (ADD_ | SUBTRACT_)? IDENTIFIER;

math_expr: math_expr math_symbol math_expr // minDepth: 2
| BRACKET_L math_expr BRACKET_R
| num_val;

assignment: INT IDENTIFIER EQUAL (math_expr | READ_OR_IN) // minDepth: 1
| STRING IDENTIFIER EQUAL (STRING_VAL | READ_OR_IN )
| BOOL IDENTIFIER EQUAL (bool_val | READ_OR_IN );

if_statement: IF logic_condition PARENT_L  (instruction | COMMENT )*  PARENT_R; // minDepth = 4

logic_condition: BRACKET_L logic_statement (logic_operator logic_statement)* BRACKET_R; // minDepth = 3

comparison: num_val comparator num_val; //minDepth: 2

logic_statement: comparison | bool_val; // minDepth: 2

logic_operator: OR | AND; //minDepth: 1

comparator: EQUAL EQUAL //minDepth: 1
| NOT_EQUAL
| GREATER
| LESS
| GREATER_EQUAL
| LESS_EQUAL;

for_loop: FOR BRACKET_L assignment SEMICOLON comparison SEMICOLON modification BRACKET_R PARENT_L (instruction | COMMENT )* PARENT_R; // minDepth: 3

instruction: modification SEMICOLON // minDepth: 2
| if_statement
| for_loop
| writeOrOut;

instruction_general: (instruction | COMMENT | assignment SEMICOLON)*; // minDepth: 1

modification: IDENTIFIER EQUAL (math_expr | READ_OR_IN); // minDepth: 1

