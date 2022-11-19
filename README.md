# PLC-ExamTwo
Programming Language Built on Kotlin

Made with intelliJ - Please clone and run main.kt

a. (15 Points) Define the rules for recognizing all lexemes as their proper token, and
clearly define integer token codes for each token required for this language <br />
    • Should have Regular Grammar, Regular Expression, or Finite Automat
defined

    integer literals must end in 't','s','m', or 'b' 
    
    tiny = Regex("(-)?\\d+t") //one byte
    small = Regex("(-)?\\d+s") //two byte
    mid = Regex("(-)?\\d+m") //four byte
    big = Regex("(-)?\\d+b") //eight byte
    variable = Regex("(\\$)([a-zA-Z_]{6,8})") //variable name
    keyword =  Regex("dec|tiny|small|mid|big|for|while|fact|wrong")
    operator = Regex("(\\+|-|\\*|/|=)")
    comparator = Regex("<=|>=|==|<|>|!=|!")
    separator = Regex("[{}|\\[|\\]|(|)|~]")

b. (15 Points) Define production rules for implementing the mathematical syntax of operators and operands, loops, variable declaration, selection statements<br />
    • Enforce a non PEMDAS (BODMAS) order of operation, must have at least 6 levels of precedence<br />
    • Keywords cannot use the words while, for, do, if, int, short, long<br />
        i. Keywords should be unique, if others share your same words, you<br />
    may lose more points than this problem is worth<br />
    • You must clearly state the structure of your language with production
    rules<br />

c. (10 points) Show whether every rule set in your language conforms to the
standard of an LL Grammar.<br />

d. (5 points) Make sure it is not ambiguous grammar<br />

e. (15 points) Write a program that process all lexemes in a file by recognizing all
tokens in a file, and produces a list of those tokens in order<br />
    • If a group of characters is not defined in your language your program
    should print an error message stating what went wrong and terminate<br />
    • This program should be written in an Object-Oriented fashion<br />
    • This program should have comments to describe each method that is
    defined<br />
    
*see Lexical.kt in src/main/kotlin/Analyzer*<br />

f. (10 points) Write a program or an extension to the above program that
determines if the tokens conform to the correct syntax.<br />

*see Syntactic.kt in src/main/kotlin/Analyzer*<br />

g. (10 points) Create 4 test files that have different names where each should have
30 or more lexemes that can be converted into tokens<br />
    • 1 with a at least 5 lexical errors based on the rules you defined<br />
        i. Detail each error and say why it doesn’t work<br />
    • 1 with at least 5 syntax errors based on the rules you defined i. Detail each error and say why it doesn’t work<br />
    • 2 with no errors at all based on the language you created<br />

h. (20 points) Create a LR (1) parse table for your language. And show the trace of 4
code samples. Each must have 6 or more tokens.<br />
    • Table must be provided, and the rules must be listed<br />
    • 2 code samples must have errors<br />
    • Show were these samples fail and pass the test<br />
