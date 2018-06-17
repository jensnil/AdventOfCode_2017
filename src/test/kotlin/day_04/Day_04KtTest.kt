package day_04

internal class Day_04KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        val input = input_04.lines().map { it.split(" ") }
        assert(part_one(input) == 325)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        val input = input_04.lines().map { it.split(" ") }
        assert(part_two(input) == 119)
    }
}