import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val list = Array(n) { readLine().split(' ').map { it.toInt()} }
    val result = list.map { it[1] % it[0]}.reduce { acc, i -> acc + i }
    println(result)
}