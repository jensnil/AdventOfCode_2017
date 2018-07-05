package day_16

internal class Day_16KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        //println(part_one(mapInput(input_16_test), 5))
        assert(part_one(mapInput(input_16), 16) == "gkmndaholjbfcepi")
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        assert(part_two(mapInput(input_16), 16, 1000000000) == "abihnfkojcmegldp")
    }

    fun mapInput(input : String) : List<IntArray> {
        return input.split(",").map {
            var tmp : IntArray
            if (it.startsWith("s")) {
                tmp = intArrayOf(1, it.substring(1).toInt())
            } else if (it.startsWith("x")) {
                var slashIndex = it.indexOf("/")
                tmp = intArrayOf(2, it.substring(1, slashIndex).toInt(), it.substring(slashIndex + 1).toInt())
            } else if (it.startsWith("p")) {
                tmp = intArrayOf(3, it[1] - 'a', it[3] - 'a')
            } else {
                tmp = intArrayOf()
            }
            tmp
        }
    }
}
