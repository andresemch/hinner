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

root : expr               #expressio
    | EOF                 #endfile
    | expr '::' tipus     #defTipus
    ;

tipus : basic             #tipusBasic
    | basic '->' tipus    #tipusFunc
    ;

basic : 'N'
    | 'B'
    ;

// Punt d'entrada de la gramàtica
expr : abstraccio   
    | aplicacio   
    | var           
    | num
    | op
    // | parentesi
    ;

// parentesi : '(' expr ')'
//     ;

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

VAR : [a-zA-Z_][a-zA-Z_0-9]* ;

// OP : '+' | '-' | '*' | '/' | '->' ;

// Ignorar espais en blanc
WS      : [ \t\r\n]+ -> skip            // Ignorar espais en blanc
        ;

