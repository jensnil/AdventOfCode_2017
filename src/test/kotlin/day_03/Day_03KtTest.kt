package day_03

internal class Day_03KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        for (i in input_03_test)
            part_one(i)
        assert(part_one(input_03) == 438)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        assert(part_two(input_03) == 266330)
    }
}