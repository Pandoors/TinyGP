grammar Bobaro;

INT_VAL: [1-9][0-9]*;
//STRING_VAL: '"' ('\\' ["\\] | ~["\\\r\n])* '"' ;
OR: '||';
AND: '&&';
EQUAL: '=';
//TRUE: 'true';
//FALSE: 'false';
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
WHILE: 'while';
SEMICOLON: ';';
COMMA: ',';
READ_OR_IN: 'sysIn()';
IDENTIFIER: [a-zA-Z][a-zA-Z0-9]*;
WS   : [ \t\r\n]+ -> skip;


program: instruction_general;

writeOrOut: 'printl(' (IDENTIFIER | INT_VAL) ')'  SEMICOLON; // minDepth: 1 todo

math_symbol: ADD_ // minDepth  1
| SUBTRACT_
| MULTIPLY
| DIVIDE;



num_val: (ADD_ | SUBTRACT_)? INT_VAL // minDepth: 1
| (ADD_ | SUBTRACT_)? IDENTIFIER;

math_expr: math_expr math_symbol math_expr // minDepth: 2
| BRACKET_L math_expr BRACKET_R
| num_val; // mD1

//assignment: INT IDENTIFIER EQUAL (math_expr | READ_OR_IN) // minDepth: 1 //todo
//| STRING IDENTIFIER EQUAL (STRING_VAL | READ_OR_IN )
//| BOOL IDENTIFIER EQUAL (bool_val | READ_OR_IN );

if_statement: IF logic_condition PARENT_L  instruction_general  PARENT_R; // minDepth = 4

logic_condition: BRACKET_L logic_statement (logic_operator logic_statement)* BRACKET_R; // minDepth = 3 //todo moze nawiasy?

comparison: num_val comparator num_val; //minDepth: 2

logic_statement: // minDepth: 2
comparison //mD2
| num_val; //mD1

logic_operator: //minDepth: 1
OR //mD0
| AND; //mD0

comparator: //minDepth: 1
EQUAL EQUAL //mD0
| NOT_EQUAL //mD0
| GREATER //mD0
| LESS //mD0
| GREATER_EQUAL //mD0
| LESS_EQUAL; //mD0

while_loop: WHILE  logic_condition  PARENT_L instruction_general PARENT_R; // minDepth: 2 //todo

instruction: // minDepth:2
modification SEMICOLON //mD1 + (checking If varialble is declared)
| if_statement // mD4
| while_loop  // mD3 //todo
| writeOrOut; //mD1

instruction_general: (instruction)*; // minDepth: 3 //todo

modification: IDENTIFIER EQUAL (math_expr | READ_OR_IN); // minDepth: 1