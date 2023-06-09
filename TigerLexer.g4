lexer grammar TigerLexer;

@header {
    package parser;
}

//ponctuation

LPAREN: '(';
RPAREN: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';
COLON: ':';
ASSIGN: ':=';
DOT: '.';
COMMA: ',';
SEMI: ';';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVIDE: '/';
EQ: '=';
NEQ: '<>';
LT: '<';
LE: '<=';
GT: '>';
GE: '>=';
AND: '&';
OR: '|';

//mot cle

ARRAY: 'array';
BREAK: 'break';
DO: 'do';
ELSE: 'else';
END: 'end';
FOR: 'for';
FUNCTION: 'function';
IF: 'if';
IN: 'in';
LET: 'let';
NIL: 'nil';
OF: 'of';
THEN: 'then';
TO: 'to';
TYPE: 'type';
VAR: 'var';
WHILE: 'while';

//identificateur

ID: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
INTLIT : '0'..'9'+;
STRINGLIT : '"' ('a'..'z'|'A'..'Z'|'0'..'9'|' '|'!'|'#'|'$'|'%'|'&'|'('|')'|'*'|'+'|','|'-'|'.'|'/'|':'|';'|'<'|'='|'>'|'?'|'@'|'['|']'|'^'|'_'|'`'|'{'|'|'|'}'|'~')* '"';
COMMENT : '/*' .*? '*/' -> skip;

//fonction standard library

PRINT: 'print';
FLUSH: 'flush';
GETCHAR: 'getchar';
ORD: 'ord';
CHR: 'chr';
SIZE: 'size';
SUBSTR: 'substr';
CONCAT: 'concat';
NOT: 'not';
EXIT: 'exit';

//types

INT: 'int';
STRING: 'string';

//espace
WS : (' '|'\t'|'\r'|'\n') -> skip;



