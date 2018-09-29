package day_09

internal class Day_09KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        //println(partOne(get_map()))
        assert(partOne(get_map()) == 11898)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        //println(partTwo(get_map()))
        assert(partTwo(get_map()) == 5601)
    }

    fun get_map(): List<Char> {
        return input_09.toList()
    }
}