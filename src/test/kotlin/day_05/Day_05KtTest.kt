package day_05

internal class Day_05KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        val input = input_05.lines().map { it.toInt() }
        assert(partOne(input) == 339351)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        val input = input_05.lines().map { it.toInt() }
        assert(partTwo(input) == 24315397)
    }
}