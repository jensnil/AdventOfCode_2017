package day_11

internal class Day_11KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        //println(partOne(get_map()))
        assert(partOne(get_map()) == 794)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        //println(partTwo(get_map()))
        assert(partTwo(get_map()) == 1524)
    }

    fun get_map(): List<String> {
        return input_11.split(",")
    }
}
