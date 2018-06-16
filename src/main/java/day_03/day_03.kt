package day_03


fun part_one(index: Int): Int {
    val a = Math.sqrt((index - 1).toDouble()).toInt() - 1
    val halfSideLength = a / 2
    val sideLength = halfSideLength * 2 + 1
    val smallSquare = sideLength * sideLength

    var start = index
    while (start - (sideLength + 1) > smallSquare) {
        start -= (sideLength + 1)
    }
    val indexOfFirstCellInCurrentSquare = smallSquare + 1 + sideLength / 2
    val d = Math.abs(indexOfFirstCellInCurrentSquare - start)
    val manhattan = halfSideLength + 1 + d
    return manhattan
}

fun part_two(index: Int): Int {
    val cells = HashMap<Pair<Int, Int>, Int>()
    var current = Pair(0, 0)
    cells[current] = 1
    while (cells[current] ?: 0 < index) {
        if (cells.containsKey(Pair(current.first - 1, current.second)) &&
                !cells.containsKey(Pair(current.first, current.second + 1))) {
            current = Pair(current.first, current.second + 1)
        } else if (cells.containsKey(Pair(current.first, current.second - 1)) &&
                !cells.containsKey(Pair(current.first - 1, current.second))) {
            current = Pair(current.first - 1, current.second)
        } else if (cells.containsKey(Pair(current.first + 1, current.second)) &&
                !cells.containsKey(Pair(current.first, current.second - 1))) {
            current = Pair(current.first, current.second - 1)
        } else {
            current = Pair(current.first + 1, current.second)
        }
        cells[current] = getSum(current, cells)
    }
    return cells[current] ?: -1
}

fun getSum(current: Pair<Int, Int>, cells: HashMap<Pair<Int, Int>, Int>): Int {
    return (cells[Pair(current.first - 1, current.second - 1)] ?: 0) +
            (cells[Pair(current.first, current.second - 1)] ?: 0) +
            (cells[Pair(current.first + 1, current.second - 1)] ?: 0) +
            (cells[Pair(current.first - 1, current.second)] ?: 0) +
            (cells[Pair(current.first + 1, current.second)] ?: 0) +
            (cells[Pair(current.first - 1, current.second + 1)] ?: 0) +
            (cells[Pair(current.first, current.second + 1)] ?: 0) +
            (cells[Pair(current.first + 1, current.second + 1)] ?: 0)
}