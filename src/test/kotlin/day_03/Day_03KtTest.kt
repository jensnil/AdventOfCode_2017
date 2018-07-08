package day_03

internal class Day_03KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        for (i in input_03_test)
            partOne(i)
        assert(partOne(input_03) == 438)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        assert(partTwo(input_03) == 266330)
    }
}