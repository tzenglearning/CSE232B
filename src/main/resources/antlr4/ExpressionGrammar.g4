grammar ExpressionGrammar ;

@header {
package edu.ucsd.CSE232B.parsers;
}

/*Rules*/
prog : (exp)+  EOF;

exp: docName SLASH rp;
rp:   tagName       #Rp_TagName
    | AT attName    #Rp_AttName
    | PATH_SYMBOL   #Rp_Pathsymbol
    | TEXT_FUNC LPR RPR #Rp_Text
    | LPR rp RPR    #Rp_Paren
    | rp SLASH rp   #Rp_Slash
    | rp LSQ filter RSQ #Rp_Filter
    | rp COMMA rp   #Rp_Comma
    ;
tagName: NAME;
attName: NAME;
filter:  rp                     #Filter_Rp
    | rp EQUAL (rp | STRING)    #Filter_Eq
    | rp SPEC_EQUAL rp          #Filter_SpecEq
    | LPR filter RPR            #Filter_Paren
    | filter AND filter         #Filter_And
    | filter OR filter          #Filter_Or
    | NEGATE filter             #Filter_Not
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

PATH_SYMBOL: ('*' | '.' | '..');
AND: 'and';
OR: 'or';
NEGATE: 'not';
LPR: '(';
RPR: ')';
LSQ: '[';
RSQ: ']';
QUOTE: '"';
COMMA: ',';
NAME: [a-zA-Z][a-zA-Z_0-9]*;

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