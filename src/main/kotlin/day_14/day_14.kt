package day_14

import lib.knothash

val gridSize = 128

fun part_one(input: String): Int {
    return getGrid(input).joinToString(separator = "").count { it == '1' }
}

fun part_two(input: String) : Int {
    var groupCount = 0
    val grid = getGrid(input)
    var cellVisited = Array(gridSize) { BooleanArray(gridSize) {false} }
    for (row in 0 until grid.count()) {
        for (col in 0 until grid[row].count()) {
            if (findGroup(grid, cellVisited, row, col)) {
                groupCount++
            }
        }
    }
    return groupCount
}

fun findGroup(grid : List<String>, cellVisited : Array<BooleanArray>, row : Int, col : Int) : Boolean {
    if (!cellVisited[row][col] && grid[row][col] == '1') {
        cellVisited[row][col] = true
        if (row > 0) {
            findGroup(grid, cellVisited, row - 1, col)
        }
        if (row < gridSize - 1) {
            findGroup(grid, cellVisited, row + 1, col)
        }
        if (col > 0) {
            findGroup(grid, cellVisited, row, col - 1)
        }
        if (col < gridSize - 1) {
            findGroup(grid, cellVisited, row, col + 1)
        }
        return true
    }
    else {
        return false
    }
}

fun getGrid(input: String) : List<String> {
    return (0..127).map {knothash(("$input-$it").map {it2 -> it2.toByte()}, 256, 64).map {
        it3 ->
        String.format("%8s", Integer.toBinaryString(it3.toInt() and 0XFF)).replace(' ', '0')
    }}.map { it4 -> it4.joinToString(separator="")}
}