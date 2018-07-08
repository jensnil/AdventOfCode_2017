package day_12

internal class Day_12KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        //println(partOne(get_map(), 0))
        assert(partOne(get_map(), 0) == 113)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
        //println(partTwo(get_map()))
        assert(partTwo(get_map()) == 202)
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
