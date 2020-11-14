import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs
import kotlin.math.roundToInt

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val array = Array(readLine().toInt()){readLine().toInt()}
    array.sort()
    val defaultValue = 4000
    var maxFrequency = 1
    var maxCount = 0
    var mostFrequencyValue = array.first()
    val countArray = arrayOfNulls<Int>(8001)
    array.forEach {
        countArray[it+defaultValue] = countArray[it+defaultValue]?.plus(1)?:1

        if(countArray[it+defaultValue] == maxFrequency){
            maxCount++
            if(maxCount.equals(2)){
                mostFrequencyValue = it
            }
        }else if(countArray[it+defaultValue]!! > maxFrequency){
            maxFrequency = countArray[it+defaultValue]!!
            maxCount = 1
            mostFrequencyValue = it
        }
    }
    println(array.sum().toDouble().div(array.size.toDouble()).roundToInt())
    println(array.get(array.size.div(2)))
    println(mostFrequencyValue)
    println(abs(array.last() - array.first()))
}
