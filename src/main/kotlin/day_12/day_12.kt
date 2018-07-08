package day_12


fun partOne(input: Map<Int,List<Int>>, start : Int): Int {
    var visitedNodes = mutableSetOf<Int>()
    val remainingNodes = mutableSetOf(start)
    while (remainingNodes.isNotEmpty()) {
        var currentNode = remainingNodes.first()
        remainingNodes.remove(currentNode)
        visitedNodes.add(currentNode)
        var nextOnes = input[currentNode]
        if (nextOnes != null) {
            nextOnes.forEach {
                if (it !in visitedNodes) {
                    remainingNodes.add(it)
                }
            }
        }
    }
    return visitedNodes.size
}

fun partTwo(input: Map<Int,List<Int>>): Int {
    var allRemainingNodes = input.keys.toMutableSet()
    var groupCount = 0
    while (allRemainingNodes.isNotEmpty()) {
        var visitedNodes = mutableSetOf<Int>()
        val remainingNodes = mutableSetOf<Int>(allRemainingNodes.first())
        while (remainingNodes.isNotEmpty()) {
            var currentNode = remainingNodes.first()
            remainingNodes.remove(currentNode)
            visitedNodes.add(currentNode)
            var nextOnes = input[currentNode]
            if (nextOnes != null) {
                nextOnes.forEach {
                    if (it !in visitedNodes) {
                        remainingNodes.add(it)
                    }
                }
            }
        }
        groupCount++
        allRemainingNodes.removeAll(visitedNodes)
    }
    return groupCount
}
