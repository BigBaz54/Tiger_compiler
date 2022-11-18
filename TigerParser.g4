parser grammar TigerParser;

@header {
    package parser;
}

options { tokenVocab= TigerLexer; }

program : exp EOF;

declaration 
    : tyDec 
    | varDec 
    | funDec;

tyDec : TYPE ID EQ ty ;

ty 
    : ID 
    | ARRAY OF ID // arrayType
    | LBRACE (fieldDec (COMMA fieldDec)*)? RBRACE ; // recordType

fieldDec : ID COLON ID ;

funDec : FUNCTION ID LPAREN (fieldDec (COMMA fieldDec)*)? RPAREN (EQ exp | COLON ID EQ exp);

varDec : VAR ID (ASSIGN exp | COLON ID ASSIGN exp);

lValue : ID (DOT ID | LBRACK exp RBRACK)*;

exp : (lValue ASSIGN)? orExp;

orExp : andExp (OR andExp)*;

andExp : compExp (AND compExp)* ;

compExp : plusExp ((EQ|NEQ|GE|GT|LE|LT) plusExp)? ;

plusExp: timesExp ((PLUS|MINUS) timesExp)*;

timesExp : exp1 ((TIMES|DIVIDE) exp1)*;

exp1 
    : seqExp   
    | negation
    | lValue  
    | callExp  
    | arrCreate  
    | recCreate  
    | ifThenElse  
    | whileExp  
    | forExp  
    | letExp  
    | NIL  
    | INTLIT  
    | STRINGLIT 
    | BREAK ;

seqExp : LPAREN (exp (SEMI exp)*)? RPAREN ;

negation : MINUS exp1;

callExp : ID LPAREN (exp (COMMA exp)*)? RPAREN;

arrCreate : ID LBRACK exp RBRACK OF exp;

recCreate : ID LBRACE (fieldCreate (COMMA fieldCreate)*)? RBRACE ;

fieldCreate : ID EQ exp;

ifThenElse : IF exp THEN exp (ELSE exp)? ;

whileExp : WHILE exp DO exp;

forExp : FOR ID ASSIGN exp TO exp DO exp;

letExp : LET declaration+ IN (exp (SEMI exp)*)? END;

print : PRINT LPAREN (STRINGLIT|callExp) RPAREN SEMI;

flush : FLUSH LPAREN RPAREN SEMI;

getchar : GETCHAR LPAREN RPAREN SEMI;

ord : ORD LPAREN (STRINGLIT|callExp) RPAREN SEMI;

chr : CHR LPAREN (INTLIT|callExp) RPAREN SEMI;

size : SIZE LPAREN (STRINGLIT|callExp) RPAREN SEMI;

substring : SUBSTR LPAREN (STRINGLIT|callExp) COMMA (INTLIT|callExp) COMMA (INTLIT|callExp) RPAREN SEMI;

concat : CONCAT LPAREN (STRINGLIT|callExp) COMMA (STRINGLIT|callExp) RPAREN SEMI;

not : NOT LPAREN (INTLIT|callExp) RPAREN SEMI;

exit : EXIT LPAREN (INTLIT|callExp) RPAREN SEMI;




