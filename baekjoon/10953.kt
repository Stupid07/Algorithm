import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    fun String.println (){println(this)}
    Array(readLine().toInt()){readLine().split(",").map { it.toInt() }.reduce{acc, value -> acc+value}}.joinToString("\n").println()
}
