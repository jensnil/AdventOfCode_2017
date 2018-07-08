package day_02

internal class Day_02KtTest {
    private val spreadSheet = input_02.lines().map { it.split('\t').map{ it2 -> it2.toInt()} }

    @org.junit.jupiter.api.Test
    fun partOne() {
        val answer = partOne(spreadSheet)
        assert(answer== 36766)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        val answer = partTwo(spreadSheet)
        assert(answer== 261)
    }
}