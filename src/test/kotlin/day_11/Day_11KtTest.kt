package day_11

internal class Day_11KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        //println(part_one(get_map()))
        assert(part_one(get_map()) == 794)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        //println(part_two(get_map()))
        assert(part_two(get_map()) == 1524)
    }

    fun get_map(): List<String> {
        return input_11.split(",")
    }
}
