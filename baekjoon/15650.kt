import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val numbers = readLine().split(" ").map{ it.toInt() }

    fun recursiveSolve(index:Int,checkList:Array<Int>, numList:Array<Int>, result: StringBuilder) {

        if (index == numList.size) {
            result.append(numList.joinToString(" ")).append("\n")
        }else{
            checkList.forEach { n -> if (index == 0 || numList[index-1] < n) {
                numList[index] = n
                recursiveSolve(index+1, checkList, numList, result )
            } }
        }
    }
    val result = StringBuilder()
    recursiveSolve(0, Array(numbers[0], {i -> i+1}), Array(numbers[1], {i -> 0}), result)
    println(result.toString())
}
