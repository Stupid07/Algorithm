import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val numbers = readLine().split(" ").map{ it.toInt() }

    fun recursiveSolve(index:Int,checkList:Array<Boolean>, numList:Array<Int>, result: StringBuilder) {
        if (index == numList.size) {
            result.append(numList.joinToString(" ")).append("\n")
        }else{
            checkList.forEachIndexed { idx, b -> if (b) {
                checkList[idx] = false
                numList[index] = idx+1
                recursiveSolve(index+1, checkList, numList, result )
                checkList[idx] = true
            } }
        }
    }
    val result = StringBuilder()
    recursiveSolve(0, Array(numbers[0], {i -> true}), Array(numbers[1], {i -> 0}), result)
    println(result.toString())
}

