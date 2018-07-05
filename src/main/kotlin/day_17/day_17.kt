package day_17

fun part_one(step: Int, insertionCount : Int = 2017): Int {
    var list = mutableListOf<Int>()
    list.add(0)
    var currentPosition = 0
    for (i in 1 .. insertionCount) {
        currentPosition = (step + currentPosition) % list.size
        list.add(currentPosition + 1, i)
        currentPosition++
    }
    return list[(currentPosition + 1) % list.size]
}

fun part_two(step: Int, insertionCount : Int = 50000000) : Int {
    var currentPosition = 0
    var positionOne = 0
    for (i in 1 .. insertionCount) {
        currentPosition = (step + currentPosition) % i
        if (currentPosition == 0) {
            positionOne = i
        }
        currentPosition++
    }
    return positionOne
}
