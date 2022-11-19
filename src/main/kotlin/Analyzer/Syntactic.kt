package Analyzer

import ViewModels.TokenViewModel

class Syntactic (viewModel: TokenViewModel){
    var decMap: MutableMap<String,Double> = mutableMapOf<String,Double>()//to store dec assignments
    val tokens = viewModel.tokenArray
    var current = 0
    var currentToken = tokens[current]


    fun startProgram(){

    }
    fun getNextToken(){
        if(current < tokens.size){
            current += 1
        }
        currentToken = tokens[current]
    }

    fun statement(){
        when(currentToken){
            "fact" -> fact()
            "{" -> block()
            "being" -> being()
            "assign" -> assign()
        }
    }
    fun block(){

    }

    fun fact(){

    }

    fun being(){
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
        factor()
        while (currentToken == "%" || currentToken == "-" || currentToken == "+"){
            getNextToken()
            factor()
        }
    }

    fun claim(){

    }

    fun idea(){

    }

    fun expression(){
        term()
        while(currentToken == "*" || currentToken == "/"){
            getNextToken()
            factor()
        }

    }

    fun boolExpression(){

    }

    fun assign(){
        if(Lexical.dec.matches(currentToken)){
            getNextToken()
            if(currentToken == "="){
                getNextToken()
                expression()
            }
            else{
                error("invale assignment")
            }
        }
        else{
            error("invalid assignment")
        }
    }


    fun error(message: String){
        println("Syntax error at: " + currentToken)
        println(message)
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


}