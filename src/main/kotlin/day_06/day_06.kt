package day_06

import lib.circular


fun part_one(input: List<Int>): Int {
    var counter = 0
    val currentState = input.toMutableList().circular()
    var previousLists = HashSet<String>()
    while (currentState.toString() !in previousLists) {
        previousLists.add(currentState.toString())
        val maxIndex = currentState.indexOf(currentState.max())
        val stopValue = currentState[maxIndex]
        currentState[maxIndex] = 0
        for (i in maxIndex + 1..maxIndex + stopValue) {
            currentState[i]++
        }
        counter++
    }
    return counter
}

fun part_two(input: List<Int>): Int {
    var counter = 0
    val currentState = input.toMutableList().circular()
    var previousLists = HashMap<String, Int>()
    while (!previousLists.containsKey(currentState.toString())) {
        previousLists.put(currentState.toString(), counter)
        val maxIndex = currentState.indexOf(currentState.max())
        val stopValue = currentState[maxIndex]
        currentState[maxIndex] = 0
        for (i in maxIndex + 1..maxIndex + stopValue) {
            currentState[i]++
        }
        counter++
    }
    return counter - (previousLists.get(currentState.toString())!!)
}
