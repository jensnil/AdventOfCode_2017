package day_12

internal class Day_12KtTest {
    @org.junit.jupiter.api.Test
    fun part_one() {
        //println(part_one(get_map(), 0))
        assert(part_one(get_map(), 0) == 113)
    }

    @org.junit.jupiter.api.Test
    fun part_two() {
        //println(part_two(get_map()))
        assert(part_two(get_map()) == 202)
    }

    fun get_map(): Map<Int,List<Int>> {
        return input_12.lines().map {
            val regex = """(\d+)""".toRegex()
            var nodes = regex.find(it)
            val node = nodes!!.value.toInt()
            var otherNodes = mutableListOf<Int>()
            nodes = nodes.next()
            while (nodes != null) {
                otherNodes.add(nodes!!.value.toInt())
                nodes = nodes.next()
            }
            node to otherNodes
        }.toMap()
    }
}
