package day_18

internal class Day_18KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
//        println(part_one(input_18.lines().map{ it.split(" ") } ))
        assert(part_one(input_18.lines().map{ it.split(" ") } ) == 7071L)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
//        println(part_two(
//                input_18.lines()[0].split(" ").last().toInt(),
//                input_18.lines()[1].split(" ").last().toInt()
//        ))           §
        assert(part_two(input_18.lines().map{ it.split(" ") }) == 8001)
    }
}
