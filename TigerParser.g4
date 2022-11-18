parser grammar TigerParser;

@header {
    package parser;
}

options { tokenVocab= TigerLexer; }

program : exp EOF;

lValue : (DOT ID | LBRACK exp RBRACK)+;

exp : (ID lValue? ASSIGN)? orExp;

orExp : andExp (OR andExp)*;

andExp : compExp (AND compExp)* ;

compExp : plusExp ((EQ|NEQ|GE|GT|LE|LT) plusExp)? ;

plusExp: timesExp ((PLUS|MINUS) timesExp)*;

timesExp : exp1 ((TIMES|DIVIDE) exp1)*;

exp1 
    : seqExp   
    | negation
    | idExp
    | ifThenElse  
    | whileExp  
    | forExp  
    | letExp  
    | NIL  
    | INTLIT  
    | STRINGLIT 
    | BREAK ;

seqExp : LPAREN (exp (SEMI exp)*)? RPAREN ;

negation : MINUS exp;

idExp 
    : ID (
        LPAREN (exp (COMMA exp)*)? RPAREN // callExp
        | LBRACK exp RBRACK (OF exp1 | (LBRACK exp RBRACK | DOT ID)*) //arrayCreate + Lvalue begin []
        | LBRACE (ID EQ exp (COMMA ID EQ exp)*)? RBRACE // reccordCreate
        | DOT ID (DOT ID | LBRACK exp RBRACK)* // LValue begin .id
)?; // lValue with id only



ifThenElse : IF exp THEN exp (ELSE exp)? ;

whileExp : WHILE exp DO exp;

forExp : FOR ID ASSIGN exp TO exp DO exp;

letExp : LET declaration+ IN (exp (SEMI exp)*)? END;

declaration 
    : tyDec 
    | varDec 
    | funDec;

tyDec : TYPE ID EQ ty ;

ty 
    : ID 
    | ARRAY OF ID // arrayType
    | LBRACE (ID COLON ID (COMMA ID COLON ID)*)? RBRACE ; // recordType

funDec : FUNCTION ID LPAREN (ID COLON ID (COMMA ID COLON ID)*)? RPAREN (EQ exp | COLON ID EQ exp);

varDec : VAR ID (ASSIGN exp | COLON ID ASSIGN exp);


// functions

callExp : LPAREN (exp (COMMA exp)*)? RPAREN ;


print : PRINT LPAREN (STRINGLIT|ID callExp) RPAREN SEMI;

flush : FLUSH LPAREN RPAREN SEMI;

getchar : GETCHAR LPAREN RPAREN SEMI;

ord : ORD LPAREN (STRINGLIT|ID callExp) RPAREN SEMI;

chr : CHR LPAREN (INTLIT|ID callExp) RPAREN SEMI;

size : SIZE LPAREN (STRINGLIT|ID callExp) RPAREN SEMI;

substring : SUBSTR LPAREN (STRINGLIT|ID callExp) COMMA (INTLIT|callExp) COMMA (INTLIT|callExp) RPAREN SEMI;

concat : CONCAT LPAREN (STRINGLIT|ID callExp) COMMA (STRINGLIT|callExp) RPAREN SEMI;

not : NOT LPAREN (INTLIT|ID callExp) RPAREN SEMI;

exit : EXIT LPAREN (INTLIT|ID callExp) RPAREN SEMI;




