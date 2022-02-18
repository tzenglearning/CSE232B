grammar ExpressionGrammar ;

@header {
package edu.ucsd.CSE232B.parsers;
}

/*Rules*/
prog : (xq | exp)+  EOF;

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

xq:   var         #XQ_VAR
    | stringConst #XQ_STRING
    | exp         #XQ_EXP
    | LPR xq RPR  #XQ_PR
    | xq SLASH rp #XQ_SLASH
    | xq COMMA xq #XQ_COMMA
    | LAB tagName RAB LCB xq RCB LAB SLASH tagName RAB #XQ_TAGNAME
    | forClause letClause whereClause returnClause #XQ_FOR
    | LET definition #XQ_LET
    ;

forClause: FOR items;

items:  item COMMA items #ITEM_MULTIPLE
    | item #ITEM_ONE
    ;

item: var IN xq;

letClause: LET definition #LET_DEF
           |  #LET_NONE
           ;

definitions: definition COMMA definitions #DEF_MUTIPLE
           | definition #DEF_ONE
           ;

definition: var DEFINEEQ xq;

whereClause: WHERE cond #WHERE_CONDITION
             | #WHERE_NONE
             ;
returnClause: RETURN xq;
cond : xq EQUAL xq    #COND_EQUAL
       | xq SPEC_EQUAL xq #COND_SPEQUAL
       | EMPTY LPR xq RPR #COND_EMPTY
       | SOME items SATISFIES cond #COND_SATISFY
       | LPR cond RPR #COND_PR
       | cond AND cond #COND_AND
       | cond OR cond #COND_OR
       | NEGATE cond  #COND_NEGATE
       ;

// TA provided
docName: (DOC | DOCUMENT) LPR fileName RPR;

var : DOLLAR NAME;
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
DOCUMENT: 'document';



/*Tokens*/
DOLLAR: '$';
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
LAB : '<';
RAB : '>';
LCB : '{';
RCB : '}';
LSQ: '[';
RSQ: ']';
QUOTE: '"';
COMMA: ',';
FOR : 'for';
IN : 'in';
LET: 'let';
DEFINEEQ: ':=';
WHERE: 'where';
RETURN: 'return';
EMPTY: 'empty';
SOME: 'some';
SATISFIES: 'satisfies';
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