package day_07

internal class Day_07KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        //print(partOne(get_map()))
        assert(partOne(get_map()) == "wiapj")
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        assert(partTwo(get_map()) == 1072)
    }

    fun get_map(): Map<String, Pair<Int, List<String>>> {
        return input_07.lines().map {
            val split = it.split("->")
            val pattern = """(\w+) \((\d+)\)""".toRegex()
            val matcher = pattern.find(it)
            matcher?.next()
            val name = matcher?.groupValues!![1]
            val weight = matcher.groupValues[2]
            var names = emptyList<String>()
            if (split.size > 1) {
                names = split[1].split(",").map { it.trim() }
            }
            name to Pair(weight.toInt(), names)
        }.toMap()
    }
}