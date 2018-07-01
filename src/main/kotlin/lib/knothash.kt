package lib

import lib.circular
import kotlin.experimental.xor

fun knothash(input: List<Byte>, listLength : Int, iterations : Int): ByteArray {
    val suffix = byteArrayOf(17, 31, 73, 47, 23).map { it.toByte() }
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
    return checksums
}
