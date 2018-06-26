package day_09

internal class Day_09KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        //println(part_one(get_map()))
        assert(part_one(get_map()) == 11898)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        //println(part_two(get_map()))
        assert(part_two(get_map()) == 5601)
    }

    fun get_map(): List<Char> {
        return input_09.toList()
    }
}