grammar hm;

root : expr               #rootExpr
    | exprTipus           #rootTipus
    | EOF                 #endfile
    ;

exprTipus : left=num '::' right=tipus       #numTipus
    | '(' left=op ')' '::' right=tipus      #opTipus
    | left=var '::' right=tipus            #varTipus
    ;

tipus : TIPUS '->' tipus    #funcTipus
    | TIPUS             #basicTipus
    ;

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


NUM : [0-9]+ ;

VAR : [a-z][a-zA-Z_0-9]* ;

TIPUS : [A-Z]+ ;

OP : '+' | '-' | '*' | '/';

WS      : [ \t\r\n]+ -> skip            // Ignorar espais en blanc
        ;

