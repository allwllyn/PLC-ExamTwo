## Andrew Llewellyn

# PLC-ExamTwo
# Programming Language Built on Kotlin

### Made with intelliJ - Please clone and run main.kt

a. (15 Points) Define the rules for recognizing all lexemes as their proper token, and
clearly define integer token codes for each token required for this language <br/>


    integer literals must end in 't','s','m', or 'b'
    variable names must start with '$'
    
    tiny = Regex("(-)?\\d+t") //one byte
    small = Regex("(-)?\\d+s") //two byte
    mid = Regex("(-)?\\d+m") //four byte
    big = Regex("(-)?\\d+b") //eight byte
    variable = Regex("(\\$)([a-zA-Z_]{6,8})") //variable name
    keyword =  Regex("dec|tiny|small|mid|big|for|while|fact|wrong")
    operator = Regex("(\\+|-|\\*|/|=|%)")
    comparator = Regex("<=|>=|==|<|>|!=|!")
    separator = Regex("[{}|\\[|\\]|(|)|~]")

b. (15 Points) Define production rules for implementing the mathematical syntax of operators and operands, loops, variable declaration, selection statements<br/>

 Rules —————————————————————————————————————————————————————————————————<br/>
 Regular expressions for these tokens in the github readme and in Lexical.kt<br/>
 declare variables with dec<br/>
 four integer types:<br/>
 tiny : 1 byte<br/>
 small : 2 bytes<br/>
 mid : 4 bytes<br/>
 big : 8 bytes<br/>
 being loop = while loop<br/>
 lines terminated with ~<br/>
 
 Production Rules ———————————————————————————————————————————————————————<br/>
 \<program> -> 'start' \<block><br/>
 \<stmt> —> \<fact> | \<being> | \<assign> | \<block><br/>
 \<block> —> '{' { \<stmt> } '}'<br/>
 \<fact> —> 'fact' '('<bool_expr>')' <stmt> ['wrong' \<stmt>]<br/>
 \<being> —> '('<bool_expr>')' <stmt> <br/>
 \<bool_expr> -> \<term> {(<|>|==) \<term>}<br/>
 \<expr> -> \<term> { (/|*) <term>}<br/>
 \<term> -> \<factor> {(%|-|+) \<factor>}<br/>
 \<factor> -> 'id' | 'int_literal' | (\<expr>)<br/>
 \<assign> -> 'id' '=' \<expr><br/>

 Precedence order ——————————————————————————————————————————————————————<br/>
 —Math Operations—<br/>
 Parentheses -> Modulo -> Subtraction -> Addition -> division -> multiplication<br/>
 —Boolean Operations—<br/>
 Parentheses -> Equal-to -> Less-than -> Greater-than<br/>
 

c. (10 points) Show whether every rule set in your language conforms to the
standard of an LL Grammar.<br/>

## There is no left-hand recursion, and no two rules begin the same way, so it is also pairwise disjoint.

d. (5 points) Make sure it is not ambiguous grammar<br/>
    
## Constructed with EBNF rules, LR tables suggest there is only one way to achieve a given final string of terminals

e. (15 points) Write a program that process all lexemes in a file by recognizing all
tokens in a file, and produces a list of those tokens in order<br />
    
## see Lexical.kt in src/main/kotlin/Analyzer<br/>

f. (10 points) Write a program or an extension to the above program that
determines if the tokens conform to the correct syntax.<br/>

## see Syntactic.kt in src/main/kotlin/Analyzer<br/>

g. (10 points) Create 4 test files that have different names where each should have
30 or more lexemes that can be converted into tokens<br/><br/>
    Lexical errors are in test_three.txt, or val C in main.kt.<br/>
        Errors are: newone does not begin with $; asdfke does not begin with $; factoid is not a keyword; several unrecognized words after this <br />
    Syntax errors are in test_two.txt, or val B in main.ket.<br/>
        Error are: doesn't begin with 'start'; unmatched left paren; unmatched left paren; being statement missing a boolean expression; unmatched ending curly brace <br />

h. (20 points) Create a LR (1) parse table for your language. And show the trace of 4
code samples. Each must have 6 or more tokens.<br/>
    
    PDFs uploaded to iCollege<br/>
    Error in LR(1)ParserGenerator_Error_1, needs another set of parentheses<br/>
    Error in LR(1)ParserGeneratorError_2, { } can be nested, but not { } { }<br/>
    NOTE: Boolean expression/term/factor rules not include, tables were getting very large
    
