package Analyzer
import ViewModels.TokenViewModel

class Lexical(viewModel: TokenViewModel){
    companion object{
        // integer literals must end in t,s,m, or b
        val tiny = Regex("(-)?\\d+t") //one byte
        val small = Regex("(-)?\\d+s") //two byte
        val mid = Regex("(-)?\\d+m") //four byte
        val big = Regex("(-)?\\d+b") //eight byte
        val dec = Regex("(\\$)([a-zA-Z_]{6,8})") //variable name / identifier
        val keyword =  Regex("dec|tiny|small|mid|big|as|being|fact|wrong")
        val operator = Regex("(\\+|-|\\*|/|=|%)")
        val comparator = Regex("<=|>=|==|<|>|!=|!")
        val separator = Regex("[{}|\\[|\\]|(|)|~|\\s]")
        val whitespace = Regex("\\s*")
    }


    var tokenCount: Int = 0

    val tokenHash = hashSetOf<String>("start","+","-","*","=","%",">=","==","<",">","!=","!","{","}","[","]","(",")","~","dec","tiny","mid","big","being","fact","wrong")
    fun countTokens(strList: List<String>):Int{
        for(i in strList){
            if(tokenHash.contains(i)){
                tokenCount+=1
                continue
            }
            else if(tiny.matches(i)){
                tokenCount+=1
                continue
            }
            else if(small.matches(i)){
                tokenCount+=1
                continue
            }
            else if(mid.matches(i)){
                tokenCount+=1
                continue
            }
            else if(big.matches(i)){
                tokenCount+=1
                continue
            }
            else if(dec.matches(i)){
                tokenCount+=1
                continue
            }
            else{
                println("ERROR: " + i + " is not recognized.")
                break
            }
        }
        return tokenCount
    }

    fun printCount(codeList:List<String>){
        println("There are " + countTokens(codeList) + " tokens")
    }

}