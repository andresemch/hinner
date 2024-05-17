// grammar hm;


// root: instru* EOF;

// instru:
//     expr
//     | abstraccio
//     | aplicacio
//     ;

// expr:
//     '(' expr ')'        # parentesi
//     | '(^)' expr expr   # potencia
//     | ( '(*)' | '(/)' ) expr expr   # multDiv
//     | ( '(+)' | '(-)' ) expr expr   # sumaResta
//     | NUM               # numero
//     | VAR               # variable
//     ;

// abstraccio: '\\' VAR '->' expr;

// aplicacio: abstraccio expr;

// NUM : [0-9]+ ;
// VAR : [a-zA-Z]+ ;
// WS  : [ \t\n\r]+ -> skip ;


////////////////////////////////////////



grammar hm;

root : expr               #rootExpr
    | exprTipus           #rootTipus
    | EOF                 #endfile
    ;

exprTipus : left=num '::' right=elemTipus       #numTipus
    | '(' left=op ')' '::' right=tipus      #opTipus
    ;

tipus : elemTipus '->' tipus    #funcTipus
    | elemTipus             #basicTipus
    ;

elemTipus : TIPUS
    ;

// tipus : VAR '::' TIPUS                               #tipusLiteral
//     | '(' op ')' '::' TIPUS '->' TIPUS '->' TIPUS    #tipusFunc
//     ;


// Punt d'entrada de la gramàtica
expr : abstraccio   
    | aplicacio   
    | var           
    | num
    | op
    ;

abstraccio : <assoc=right> '\\' var '->' expr
    ;

aplicacio : aplicacio expr                  #recursivaAplicacio                               
          | '(' (abstraccio | op) ')' expr  #parentesiAplicacio
          ;

var : VAR
    ;

num : NUM
    ;

op : '*'    #multOp
    | '/'   #divOp
    | '+'   #sumOp
    | '-'   #restaOp
    ;


// Tokens
NUM : [0-9]+ ;

VAR : [a-z][a-zA-Z_0-9]* ;

TIPUS : [A-Z]+ ;

OP : '+' | '-' | '*' | '/';

// Ignorar espais en blanc
WS      : [ \t\r\n]+ -> skip            // Ignorar espais en blanc
        ;

