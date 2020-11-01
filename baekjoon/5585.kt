import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val DEFAULT_MONEY = 1000
    val EXCHANGE_MONEYS = arrayOf(500, 100, 50, 10, 5, 1)

    tailrec fun exchangeCount(money:Int, idx:Int, count:Int) :Int {
        return when{
                money == 0 -> count
                money >= EXCHANGE_MONEYS[idx] -> exchangeCount(money-EXCHANGE_MONEYS[idx], idx, count+1)
                else -> exchangeCount(money, idx+1, count)
            }
    }

    val result = DEFAULT_MONEY.minus(readLine().toInt()).let{ exchangeCount(it, 0, 0)}
    println(result)
}
