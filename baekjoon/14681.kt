import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val (x, y) = readLine().toInt().to(readLine().toInt())
    var result = 1 + x.isNegativeReturnOne() + y.isNegativeReturnOne()
    if(x.isNegativeReturnOne().equals(0) && y.isNegativeReturnOne().equals(1)) result+=2
    print(result)
}
fun Int.isNegativeReturnOne() = run{if(this < 0) 1 else 0}
