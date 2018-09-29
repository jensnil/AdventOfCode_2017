package day_01

import input_01
import lib.circular

internal class Day_01KtTest {
    private val inputCircular = input_01.toList().map{it.toString().toInt()}.circular()

    @org.junit.jupiter.api.Test
    fun partOne() {
        val answer = partOne(inputCircular)
        assert(answer== 1341)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        val answer = partTwo(inputCircular)
        assert(answer== 1348)
    }
}