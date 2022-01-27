grammar ExpressionGrammar ;

@header {
package edu.ucsd.CSE232B.parsers;
}

/*Rules*/
prog : (exp)+  EOF;

exp: docName SLASH rp;
rp:   tagName
    | AT attName
    | PATH_SYMBOL
    | TEXT_FUNC LPR RPR
    | LPR rp RPR
    | rp SLASH rp
    | rp LSQ filter RSQ
    | rp rp
    ;
tagName: NAME;
attName: NAME;
filter:  rp
    | rp EQUAL (rp | STRING)
    | rp SPEC_EQUAL rp
    | LPR filter RPR
    | filter ('and' | 'or') filter
    | ('not') filter
    ;

// TA provided
docName: DOC LPR fileName RPR;

fileName: STRING;
stringConst: STRING;

STRING:
   '"'
   (
      ESCAPE
      | ~["\\]
   )* '"'
   | '\''
   (
      ESCAPE
      | ~['\\]
   )* '\''
;

ESCAPE:
   '\\'
   (
      ['"\\]
   )
;
// Represent DOC using a set of fragments
DOC: D O C;
fragment D: [dD];
fragment O: [oO];
fragment C: [cC];

/*Tokens*/
AT: '@';
SLASH: ('/' | '//');
SPEC_EQUAL: ('eq' | '==' | 'is');
EQUAL: '=';

TEXT_FUNC: 'text';

NAME: [a-zA-Z][a-zA-Z_0-9]*;
PATH_SYMBOL: ('*' | '.' | '..');
//AND_OR: ('and' | 'or');
//NEGATE: 'not';
LPR: '(';
RPR: ')';
LSQ: '[';
RSQ: ']';
QUOTE: '"';

//exp:	exp OP exp      #Expr_Binary
//    |	number          #Expr_Number
//    |   variable        #Expr_Variable
//    |	LPR exp RPR     #Expr_Parentheses
//    ;
//number:
// NUM
//;
//variable:
//ID
//;

//OP : ('*'|'/' | '+');
//ID : [a-zA-Z][a-zA-Z_0-9]*;
//NUM :  '0' | '-'?[1-9][0-9]* ;
WS: [ \t\n\r]+ -> skip;