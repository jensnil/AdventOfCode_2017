package day_13

internal class Day_13KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        //println(partOne(get_map()))
        assert(partOne(get_map()) == 2688)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        //println(partTwo(get_map()))
        assert(partTwo(get_map()) == 3876272)
    }

    fun get_map(): Map<Int,Int> {
        return input_12.lines().map {
            val regex = """(\d+)""".toRegex()
            var line = regex.find(it)
            val layer = line!!.value.toInt()
            line = line.next()
            val range = line!!.value.toInt()
            layer to range
        }.toMap()
    }
}
