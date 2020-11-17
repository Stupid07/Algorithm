import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    fun String.println(){println(this)}
    fun Stack<Char>.checkAndPop(bombStr: String){
        if(bombStr.length <= this.size &&
                bombStr.equals(this.slice(this.size-bombStr.length..this.size-1).joinToString(""))){
            for(i in 1..bombStr.length) this.pop()
        }
    }
    val stack = Stack<Char>()
    val line = readLine()
    val bombStr = readLine()
    line.forEach {
        stack.push(it)
        if(it == bombStr.last()){
            stack.checkAndPop(bombStr)
        }
    }

    when(stack.size){
        0 -> "FRULA"
        else -> stack.joinToString("")
    }.println()
}
