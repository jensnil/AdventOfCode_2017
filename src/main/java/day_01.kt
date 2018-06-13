import lib.circular
import lib.swap

fun main(args: Array<String>) {
    var hej = listOf<Int>(1, 2, 3)//.toMutableList()
    var c1 = hej.circular()
    //c1.add(4)
    println(c1[0])
    println(c1[-1])
    println(c1[1])
    println(c1[2])
}
