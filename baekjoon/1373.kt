import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    fun String.println(){println(this)}
    val line = readLine()
    line.padStart(line.length + ((3-(line.length % 3))%3),'0')
            .chunked(3){data -> data.toString().toInt(2).toString(8)}.joinToString("").println()
}
