package day_06

internal class Day_06KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        val input = input_06.split("\t").map { it.toInt() }
        assert(part_one(input) == 4074)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        val input = input_06.split("\t").map { it.toInt() }
        assert(part_two(input) == 2793)
    }
}