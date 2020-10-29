import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    tailrec fun fibo(n:Int): Int { return if(n < 2) n else fibo(n-1) + fibo(n-2)}
    println(fibo(readLine().toInt()))
}
