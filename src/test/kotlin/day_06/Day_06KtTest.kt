package day_06

internal class Day_06KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        val input = input_06.split("\t").map { it.toInt() }
        assert(partOne(input) == 4074)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        val input = input_06.split("\t").map { it.toInt() }
        assert(partTwo(input) == 2793)
    }
}