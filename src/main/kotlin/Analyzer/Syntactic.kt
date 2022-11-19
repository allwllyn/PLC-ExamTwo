package Analyzer
import ViewModels.TokenViewModel

class Syntactic (viewModel: TokenViewModel){
    var decMap: MutableMap<String,Double> = mutableMapOf<String,Double>()//to store dec assignments
    val tokens = viewModel.tokenArray
    var current = 0
    var currentToken = tokens[current]

    fun printSyntax(){
        println("syntax")
    }

    fun getNextToken(){
        if(current < tokens.size){
            current += 1
        }
    }

}