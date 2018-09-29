package day_04

internal class Day_04KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        val input = input_04.lines().map { it.split(" ") }
        assert(partOne(input) == 325)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        val input = input_04.lines().map { it.split(" ") }
        assert(partTwo(input) == 119)
    }
}