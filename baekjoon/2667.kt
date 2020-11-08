import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val result = Array(readLine().toInt()){readLine().toCharArray()}.let{searchApartment(it)}
    println(result.size)
    if(0 < result.size) println(result.joinToString("\n"))
}

data class Position(var map:Array<CharArray>,var x:Int,var y:Int, val limit:Int){
    fun left(): Position{if(0 < this.x) this.x--; return this}
    fun right(): Position{if(limit > this.x) this.x++; return this}
    fun up(): Position{if(limit > this.y) this.y++; return this}
    fun down(): Position{if(0 < this.y) this.y--; return this}
    fun getMap(): Char {return this.map[x][y]}
    fun setMap(value:Char):Position {this.map[x][y] = value; return this}
    fun isMapValue(value:Char):Boolean{return getMap().equals(value)}
    fun get():Pair<Int,Int>{return Pair(this.x,this.y)}
    fun set(pair:Pair<Int,Int>): Position{this.x = pair.first; this.y = pair.second; return this}
}

fun searchApartment(map: Array<CharArray>):List<Int> {
    val apartmentList = ArrayList<Int>()
    map.forEachIndexed {x, arr ->
        arr.forEachIndexed{y,value ->
            if(value.equals('1')){
                apartmentList.add(deleteApartment(Position(map, x, y,map.size-1)))
            }
        }
    }
    apartmentList.sort()
    return apartmentList
}

fun deleteApartment(position:Position): Int{
    val current = position.setMap('0').get()
    fun Position.runMapValueSame():Int { return if(this.isMapValue('1')) deleteApartment(position.setMap('0')) else 0 }
    return position.set(current).up().runMapValueSame() + position.set(current).down().runMapValueSame() + position.set(current).left().runMapValueSame() + position.set(current).right().runMapValueSame() + 1
}
