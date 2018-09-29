package day_20

import com.sun.tools.internal.xjc.model.Multiplicity.group
import java.util.regex.Pattern


internal class Day_20KtTest {
    @org.junit.jupiter.api.Test
    fun partOne() {
        assert(partOne(getMap()) == 157)
    }

    @org.junit.jupiter.api.Test
    fun partTwo() {
       println(partTwo(getMap()))
    }


    fun getMap(): List<List<Int>> {
        val regex = """(-?\d+)""".toRegex()
        return input_20_test_2.lines().map {
            val p = Pattern.compile("-?\\d+")
            val m = p.matcher(it)
            var toReturn = mutableListOf<Int>()
            while (m.find()) {
                toReturn.add(m.group().toInt())
            }
            toReturn
        }
    }
}
