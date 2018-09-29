package day_04


fun partOne(input: List<List<String>>): Int {
    return input.fold(0) { acc, list ->
        acc + (if (list.toSet().size == list.size) 1 else 0)
    }
}

fun partTwo(input: List<List<String>>): Int {
    return input.fold(0) { acc, list ->
        val anagramSet = list.map { it.toCharArray().toList().sorted().joinToString(separator = "") }
        acc + (if (list.size == anagramSet.toSet().size) 1 else 0)
    }
}
