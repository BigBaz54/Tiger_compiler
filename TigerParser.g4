parser grammar TigerParser;

@header {
    package parser;
}

options { tokenVocab= TigerLexer; }

program : exp EOF;

dec 
    : tyDec 
    | varDec 
    | funDec;

tyDec : TYPE TYID EQ ty ;

ty 
    : TYID 
    | arrTy 
    | recTy;

arrTy : ARRAY OF TYID;

recTy : LBRACE (fieldDec (COMMA fieldDec)*)? RBRACE ;

fieldDec : ID COLON TYID ;

funDec : FUNCTION ID LPAREN (fieldDec (COMMA fieldDec)*)? RPAREN funDec2;

funDec2 
    : EQ exp
    | COLON TYID EQ exp;

varDec : VAR ID varDec2;

varDec2 
    : ASSIGN exp
    | COLON TYID ASSIGN exp;

lValue : ID lValue2;

lValue2
    : LBRACK exp RBRACK lValue2
    | DOT ID lValue2
    | ;

exp 
    : lValue exp2 
    | NIL exp2 
    | INTLIT exp2 
    | STRINGLIT exp2 
    | seqExp exp2 
    | negation exp2 
    | callExp exp2 
    | arrCreate exp2 
    | recCreate exp2 
    | assignment exp2 
    | ifThenElse exp2 
    | whileExp exp2 
    | forExp exp2 
    | BREAK exp2 
    | letExp exp2 ; 

exp2 
    : infixOp exp exp2
    | ;

infixOp
    : TIMES
    | DIVIDE
    | PLUS
    | MINUS
    | EQ
    | NEQ
    | LT
    | LE
    | GT
    | GE
    | AND
    | OR;

seqExp : LPAREN (exp (SEMI exp)*)? RPAREN ;

negation : MINUS exp;

callExp : ID LPAREN (exp (COMMA exp)*)? RPAREN;

arrCreate : TYID LBRACK exp RBRACK OF exp;

recCreate : TYID LBRACE (fieldCreate (COMMA fieldCreate)*)? RBRACE ;

fieldCreate : ID EQ exp;

assignment : lValue ASSIGN exp;

ifThenElse : IF exp THEN exp (ELSE exp)? ;

whileExp : WHILE exp DO exp;

forExp : FOR ID ASSIGN exp TO exp DO exp;

letExp : LET dec+ IN (exp (SEMI exp)*)? END;






