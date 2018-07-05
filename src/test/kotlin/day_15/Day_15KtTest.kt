package day_15

internal class Day_15KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
//        println(part_one(
//                input_15.lines()[0].split(" ").last().toInt(),
//                input_15.lines()[1].split(" ").last().toInt()
//        ))
        assert(part_one(
                input_15.lines()[0].split(" ").last().toInt(),
                input_15.lines()[1].split(" ").last().toInt()
        ) == 594)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
//        println(part_two(
//                input_15.lines()[0].split(" ").last().toInt(),
//                input_15.lines()[1].split(" ").last().toInt()
//        ))
        assert(part_two(
                input_15.lines()[0].split(" ").last().toInt(),
                input_15.lines()[1].split(" ").last().toInt()
        ) == 328)
    }
}
