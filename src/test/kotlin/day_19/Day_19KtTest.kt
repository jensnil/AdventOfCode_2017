package day_19

internal class Day_19KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        assert(partOne(input_19.lines().map { it.toCharArray().toList() }).first == "QPRYCIOLU")
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        assert(partTwo(input_19.lines().map { it.toCharArray().toList() }) == 16162)
    }
}
