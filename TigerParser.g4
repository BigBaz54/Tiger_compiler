parser grammar TigerParser;

@header {
    package parser;
}

options { tokenVocab= TigerLexer; }

program : exp EOF;

lValue : lValue1+;

lValue1 : 
    DOT ID                  #LValueDot
    | LBRACK exp RBRACK     #LValueBrack
    ;

exp : (ID lValue? ASSIGN)? orExp;

orExp : andExp (OR andExp)*;

andExp : compExp (AND compExp)* ;

compExp : plusExp ((EQ|NEQ|GE|GT|LE|LT) plusExp)?   ;

plusExp: timesExp ((PLUS|MINUS) timesExp)*;

timesExp : exp1 ((TIMES|DIVIDE) exp1)*;

exp1 
    : seqExp   
    | idExp
    | ifThenElse
    | whileExp
    | forExp
    | letExp
    | exp1Lit
    | negation ;

exp1Lit :
    NIL             #Nilexp
    | INTLIT        #IntLitexp
    | STRINGLIT     #StringLitexp
    | BREAK         #Breakexp
    ;

seqExp : LPAREN (exp (SEMI exp)*)? RPAREN ;

negation : MINUS exp1;

idExp : ID idExp1?;

idExp1 :
    callExp                                             #IdExp1CallExp // callExp
    | lValue                                            #IdExp1LValue // Lvalue
    | LBRACK exp RBRACK OF exp1                         #IdExp1ArrayCreate //arrayCreate
    | LBRACE (ID EQ exp (COMMA ID EQ exp)*)? RBRACE     #IdExp1RecordCreate // reccordCreate
    ;

ifThenElse : IF exp THEN exp (ELSE exp)? ;

whileExp : WHILE exp DO exp;

forExp : FOR ID ASSIGN exp TO exp DO exp;

letExp : LET declaration+ IN (exp (SEMI exp)*)? END;

declaration : 
    tyDec 
    | varDec 
    | funDec;

tyDec : TYPE ID EQ tyDec1;

tyDec1 :
    ID                                                      #TyDec1Id
    | ARRAY OF ID                                           #TyDec1Array //arrayType
    | LBRACE (ID COLON ID (COMMA ID COLON ID)*)? RBRACE     #TyDec1Record //recordType
    ;

funDec : FUNCTION ID LPAREN (ID COLON ID (COMMA ID COLON ID)*)? RPAREN funDec1;

funDec1 : 
    EQ exp              #FunDec1NoType
    | COLON ID EQ exp   #FunDec1Type
    ;

varDec : VAR ID varDec1;

varDec1 :
    ASSIGN exp              #VarDec1NoType
    | COLON ID ASSIGN exp   #VarDec1Type
    ;

callExp : LPAREN (exp (COMMA exp)*)? RPAREN ;

// functions

intArg :
    INTLIT      #IntArgLit
    | idExp     #IntArgExp
    ;

stringArg :
    STRINGLIT   #StringArgLit
    | idExp     #StringArgExp
    ;

print : PRINT LPAREN (stringArg) RPAREN SEMI;

flush : FLUSH LPAREN RPAREN SEMI;

getchar : GETCHAR LPAREN RPAREN SEMI;

ord : ORD LPAREN (stringArg) RPAREN SEMI;

chr : CHR LPAREN (intArg) RPAREN SEMI;

size : SIZE LPAREN (stringArg) RPAREN SEMI;

substring : SUBSTR LPAREN (stringArg) COMMA (intArg) COMMA (intArg) RPAREN SEMI;

concat : CONCAT LPAREN (stringArg) COMMA (stringArg) RPAREN SEMI;

not : NOT LPAREN (intArg) RPAREN SEMI;

exit : EXIT LPAREN (intArg) RPAREN SEMI;




