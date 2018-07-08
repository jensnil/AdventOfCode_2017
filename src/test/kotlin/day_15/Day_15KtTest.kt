package day_15

internal class Day_15KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
//        println(partOne(
//                input_15.lines()[0].split(" ").last().toInt(),
//                input_15.lines()[1].split(" ").last().toInt()
//        ))
        assert(partOne(
                input_15.lines()[0].split(" ").last().toInt(),
                input_15.lines()[1].split(" ").last().toInt()
        ) == 594)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
//        println(partTwo(
//                input_15.lines()[0].split(" ").last().toInt(),
//                input_15.lines()[1].split(" ").last().toInt()
//        ))
        assert(partTwo(
                input_15.lines()[0].split(" ").last().toInt(),
                input_15.lines()[1].split(" ").last().toInt()
        ) == 328)
    }
}
