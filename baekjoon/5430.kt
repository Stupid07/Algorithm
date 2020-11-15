import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    fun String.println(){println(this)}
    fun MutableList<String>.removeFirstOrLast(isFirst:Boolean){
        when {
            this.size == 0 -> throw Exception("error")
            isFirst -> this.removeAt(0)
            else -> this.removeAt(this.size-1)
        }
    }

    fun execute(): String {
        try {
            val command = readLine()
            val size = readLine().toInt()
            val strArray = readLine().trim('[', ']').split(",").toMutableList()
            if(size == 0) strArray.removeAt(0)
            var isFirst = true
            command.forEach {
                when (it) {
                    'D' -> strArray.removeFirstOrLast(isFirst)
                    'R' -> isFirst = isFirst.not()
                }
            }

            if(!isFirst) strArray.reverse()

            return strArray.toString().replace(" ", "")
        }catch (e:Exception){
            return e.message?:"error"
        }
    }

    Array(readLine().toInt()){
        execute()
    }.joinToString ("\n").println()

}
