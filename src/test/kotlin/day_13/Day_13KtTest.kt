package day_13

internal class Day_13KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        //println(part_one(get_map()))
        assert(part_one(get_map()) == 2688)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        //println(part_two(get_map()))
        assert(part_two(get_map()) == 3876272)
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
