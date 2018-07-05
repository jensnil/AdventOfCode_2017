package day_16

fun part_one(commands : List<IntArray>, programCount : Int): String {
    return dance(commands, programCount)
}

fun part_two(commands : List<IntArray>, programCount : Int, iterations : Int) : String {
    return dance(commands, programCount, iterations)
}

fun dance(commands : List<IntArray>, programCount : Int, iterations : Int = 1) : String {
    var line = ('a' until 'a'+programCount).joinToString(separator = "")
    var seen = mutableListOf<String>()
    for (i in 0 until iterations) {
        if (line in seen) {
            return seen[iterations % i]
        }
        seen.add(line)
        commands.forEach {
            if (it[0] == 1) {
                line = line.substring(line.length - it[1]) + line.substring(0, line.length - it[1])
            } else if (it[0] == 2) {
                var tmpString = line.toMutableList()
                var tmp = tmpString[it[1]]
                tmpString[it[1]] = tmpString[it[2]]
                tmpString[it[2]] = tmp
                line = tmpString.joinToString(separator = "")
            } else if (it[0] == 3) {
                val tmpString = line.toMutableList()
                val tmp = tmpString[tmpString.indexOf('a'+ it[1])]
                val tmpIndex = tmpString.indexOf('a'+ it[2])
                tmpString[tmpString.indexOf('a'+ it[1])] = tmpString[tmpIndex]
                tmpString[tmpIndex] = tmp
                line = tmpString.joinToString(separator = "")
            }
        }
    }
    return line
}
