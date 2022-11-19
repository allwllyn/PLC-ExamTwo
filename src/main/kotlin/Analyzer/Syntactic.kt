package Analyzer

import ViewModels.TokenViewModel
import kotlin.system.exitProcess

class Syntactic (tokens: MutableList<String>){
    var tokens = tokens
    var current = 0
    var currentToken = tokens[current]
    lateinit var temp: String


    fun startProgram(){
        println("|——— Syntax Analysis Start ———|")
        if(currentToken == "start"){
            getNextToken()
            statement()
        }
        else{
            error("must start program with \"Start\"")
        }
        println("|——— Syntax Analysis Complete ———|")
    }
    fun getNextToken(){
        if(current < tokens.size-1){
            current += 1
        }
        currentToken = tokens[current]
        checkEndline()
    }
     fun statement(){
         println("called statement - current token: " + currentToken)
         if(checkInteger(currentToken)){
             temp = currentToken
             currentToken = "integer"
         }
        when(currentToken){
            "fact" -> fact()
            "{" -> block()
            "being" -> being()
            "dec" -> assign()
            "integer" -> {currentToken = temp; expression()}
            else -> {
                error("statement error")
            }
        }
    }
    fun block(){
        println("called block - current token: " + currentToken)
        if(currentToken == "{"){
            getNextToken()
            while(currentToken == "fact" || currentToken == "being" || currentToken == "{" || currentToken == "dec" || checkInteger(currentToken)){
                statement()
            }
            if(currentToken == "}"){
                getNextToken()
            }
            else{
                error("block error 2")
            }
        }
        else{
            error("block error 1")
        }
    }
    fun fact(){
        println("called fact - current token: " + currentToken)
        if (currentToken == "fact"){
            getNextToken()
            boolExpression()
            if(currentToken == "wrong"){
                statement()
            }
        }
        else{
            error("fact error")
        }
    }
    fun being(){
        println("called being - current token: " + currentToken)
        if(currentToken == "being"){
            getNextToken()
            if (currentToken == "("){
                boolExpression()
            }
            else{
                error("being loop error")
            }
        }
        else{
            error("being loop error")
        }
    }
    fun factor(){
        println("called factor - current token: " + currentToken)
        if(Lexical.dec.matches(currentToken) || checkInteger(currentToken)){
            getNextToken()
        }
        else if(currentToken == "("){
            getNextToken()
            expression()
            if(currentToken == ")"){
                getNextToken()
            }
            else{
                error("unmatched '('")
            }
        }
        else{
            error("invalid assignment operation")
        }
    }
    fun term(){
        println("called term - current token: " + currentToken)
        factor()
        while (currentToken == "%" || currentToken == "-" || currentToken == "+"){
            getNextToken()
            factor()
        }
    }
    fun expression(){
        println("called expression - current token: " + currentToken)
        term()
        while(currentToken == "*" || currentToken == "/"){
            getNextToken()
            factor()
        }
    }
    fun boolExpression(){
        println("called boolExpression - current token: " + currentToken)
        if(currentToken == "("){
            getNextToken()
            term()
            if(currentToken == "<" || currentToken == ">"){
                getNextToken()
                term()
                if(currentToken == ")"){
                    getNextToken()
                    block()
                }
            }
        }
    }
    fun assign(){
        println("called assign - current token: " + currentToken)
        if(currentToken == "dec"){
            getNextToken()
            if(Lexical.dec.matches(currentToken)){
                getNextToken()

            }
            if(currentToken == "="){
                getNextToken()
                expression()
            }
            else{
                error("invalid assignment")
            }
        }
        else{
            error("invalid assignment")
        }
    }
    fun error(message: String){
        println("Syntax error at: " + currentToken)
        println(message)
        exitProcess(1)
    }
    fun checkInteger(token: String): Boolean{
        if(Lexical.tiny.matches(token)){
            return true
        }
        else if(Lexical.small.matches(token)){
            return true
        }
        else if(Lexical.mid.matches(token)){
            return true
        }
        else return Lexical.big.matches(token)
    }
    fun checkEndline(){
        if(currentToken == "~"){
            getNextToken()
        }
    }
}