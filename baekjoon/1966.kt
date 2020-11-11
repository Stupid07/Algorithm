import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    (1..readLine().toInt()).forEach{_ ->
        val (N, M) = readLine().split(" ").map{it.toInt()}
        val list = readLine().split(" ").mapIndexed { idx, str -> arrayOf(idx, str.toInt())}.toMutableList()
        val sortedList = list.sortedByDescending { it[1] }
        var result = 1
        sortedList.forEachIndexed{idx, value ->
            while(list.first()[1] != value[1]){
                list.add(list.removeAt(0))
            }
            if(list.first()[0] == M){
                result = idx+1
            }
            list.removeAt(0)
        }
        println(result)
    }
}
