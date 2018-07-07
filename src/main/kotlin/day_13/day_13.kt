package day_13


fun part_one(input: Map<Int,Int>): Int {
    var score = 0
    val maxLayer = (input.keys.max() ?: 0) + 1
    var state = IntArray(maxLayer)
    var direction = IntArray(maxLayer) {-1}
    for (i in 0 until maxLayer) {
        if (input.containsKey(i) && state[i] == 0) {
            score += i * (input[i] ?: 0)
        }
        input.forEach { j ->
            if (state[j.key] == 0 || state[j.key] == j.value - 1) {
                direction[j.key] *= -1
            }
            state[j.key] = (state[j.key] + direction[j.key])
        }
    }
    return score
}



fun part_two(input: Map<Int,Int>): Int {
    val maxLayer = (input.keys.max() ?: 0) + 1
    var state = IntArray(maxLayer)
    var direction = IntArray(maxLayer) {-1}
    var activePackages = HashSet<Int>()
    var picoSecond = 0
    while (picoSecond - maxLayer !in activePackages) {
        activePackages.add(picoSecond)
        activePackages.toList().forEach {
            if (input.containsKey(picoSecond - it) && state[picoSecond - it] == 0) {
                activePackages.remove(it)
            }
        }
        input.forEach { i ->
            if (state[i.key] == 0 || state[i.key] == i.value - 1) {
                direction[i.key] *= -1
            }
            state[i.key] = (state[i.key] + direction[i.key])
        }
        picoSecond++
    }
    return picoSecond - maxLayer
}
