package day_10

import lib.circular
import kotlin.experimental.xor

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

fun part_two(input: List<Byte>, suffix: List<Byte>, listLength : Int, iterations : Int): String {
    var list = (0..listLength-1).map { it.toByte() }.toMutableList().circular()
    var currentPostition = 0
    var skip = 0
    var tmp : Byte
    val inputWithSuffix = input + suffix
    for (j in 0 until iterations) {
        inputWithSuffix.forEach { it ->
            var end = currentPostition+it-1
            for (i in 0 until it/2) {
                tmp = list[currentPostition + i]
                list[currentPostition + i] = list[end - i]
                list[end - i] = tmp
            }
            currentPostition = (currentPostition + it + skip) % list.size
            skip++
        }
    }
    val checksums = ByteArray(16)
    for (i in 0 until 16) {
        checksums[i] = list[16 * i]
        for (j in 1 until 16) {
            checksums[i] = checksums[i] xor list[16 * i + j]
        }
    }
    return checksums.map { String.format("%02x", it) }.joinToString(separator =  "")
}
