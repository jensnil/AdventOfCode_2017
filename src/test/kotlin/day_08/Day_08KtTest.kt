package day_08

internal class Day_08KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        assert(part_one(get_map()) == 4448)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        assert(part_two(get_map()) == 6582)
    }

    fun get_map(): List<Instruction> {
        val regex = """(\w+) (\w+) (-?\d+) if (\w+) (\S+) (-?\d+)""".toRegex()
        return input_08.lines().map {
            var matchResult = regex.find(it)
            //println(matchResult!!.groupValues[1])
            //println(matchResult!!.groupValues[2])
            Instruction(matchResult!!.groupValues[1],
                    matchResult!!.groupValues[2],
                    matchResult!!.groupValues[3].toInt(),
                    matchResult!!.groupValues[4],
                    matchResult!!.groupValues[5],
                    matchResult!!.groupValues[6].toInt())
        }
    }
}