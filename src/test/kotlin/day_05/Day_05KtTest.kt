package day_05

internal class Day_05KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        val input = input_05.lines().map { it.toInt() }
        assert(part_one(input) == 339351)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        val input = input_05.lines().map { it.toInt() }
        assert(part_two(input) == 24315397)
    }
}