package day_10

internal class Day_10KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        //println(part_one(get_map(), 256))
        assert(part_one(get_map(), 256) == 5577)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        //println(part_two(get_map_2(), get_map_2_suffix(), 256, 64))
        assert(part_two(get_map_2(), get_map_2_suffix(), 256, 64) == "44f4befb0f303c0bafd085f97741d51d")
    }

    fun get_map(): List<Int> {
        return input_10.split(",").map { it.trim().toInt() }
    }

    fun get_map_2(): List<Byte> {
        return input_10.map { it.toByte() }
    }
    fun get_map_2_suffix(): List<Byte> {
        return intArrayOf(17, 31, 73, 47, 23).map { it.toByte() }
    }
}
