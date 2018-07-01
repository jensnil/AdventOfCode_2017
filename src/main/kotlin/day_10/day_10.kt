package day_10

import lib.circular
import lib.knothash

fun part_one(input: List<Int>, listLength : Int): Int {
    var list = (0..listLength-1).toMutableList().circular()
    var currentPostition = 0
    var skip = 0
    var tmp : Int
    input.forEach { it ->
        var end = currentPostition+it-1
        for (i in 0 until it/2) {
            tmp = list[currentPostition + i]
            list[currentPostition + i] = list[end - i]
            list[end - i] = tmp
        }
        currentPostition = (currentPostition + it + skip) % list.size
        skip++
    }
    return list[0] * list[1]
}

fun part_two(input: List<Byte>, listLength : Int, iterations : Int): String {
    return knothash(input, listLength, iterations).map { String.format("%02x", it) }.joinToString(separator =  "")
}
