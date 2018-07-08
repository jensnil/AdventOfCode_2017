package day_19

enum class Direction {
    SOUTH, NORTH, WEST, EAST
}

enum class CellType {
    EMPTY, CROSS, VERTICAL, HORIZONTAL, LETTER
}

class State(var diagram : List<List<Char>>, var line : Int, var row : Int, var direction : Direction) {
    fun getCellType() : CellType = when (getValue()) {
        in 'A'..'Z' -> CellType.LETTER
        '+' -> CellType.CROSS
        '-' -> CellType.HORIZONTAL
        '|' -> CellType.VERTICAL
        else -> CellType.EMPTY
    }

    fun getValue() : Char? {
        return diagram.elementAtOrNull(line)?.elementAtOrNull(row)
    }

    override fun toString() : String {
        return "($line, $row: $direction)"
    }
}

fun moveHorizontalDirection(state : State) : Direction? {
    val left = State(state.diagram, state.line, state.row - 1, state.direction)
    if (left.getCellType() == CellType.CROSS ||left.getCellType() == CellType.LETTER ||left.getCellType() == CellType.HORIZONTAL) {
        return Direction.WEST
    }
    val right = State(state.diagram, state.line, state.row + 1, state.direction)
    if (right.getCellType() == CellType.CROSS ||right.getCellType() == CellType.LETTER ||right.getCellType() == CellType.HORIZONTAL) {
        return Direction.EAST
    }
    return null
}

fun moveVerticalDirection(state : State) : Direction? {
    val up = State(state.diagram, state.line - 1, state.row, state.direction)
    if (up.getCellType() == CellType.CROSS ||up.getCellType() == CellType.LETTER ||up.getCellType() == CellType.VERTICAL) {
        return Direction.NORTH
    }
    val down = State(state.diagram, state.line + 1, state.row, state.direction)
    if (down.getCellType() == CellType.CROSS ||down.getCellType() == CellType.LETTER ||down.getCellType() == CellType.VERTICAL) {
        return Direction.SOUTH
    }
    return null
}

fun partOne(diagram : List<List<Char>>): Pair<String,Int> {
    var toReturn = StringBuilder()
    var steps = 0
    var currentState = State(diagram, 0, diagram[0].indexOf('|'), Direction.SOUTH)
    while (true) {
        var lineDiff = 0
        var rowDiff = 0
        when (currentState.getCellType()) {
            CellType.EMPTY -> {
                return Pair(toReturn.toString(), steps)
            }
            CellType.LETTER -> toReturn.append(currentState.getValue())
            CellType.CROSS -> {
                when (currentState.direction) {
                    Direction.SOUTH -> currentState.direction = moveHorizontalDirection(currentState) ?: return Pair("",0)
                    Direction.NORTH -> currentState.direction = moveHorizontalDirection(currentState) ?: return Pair("",0)
                    Direction.EAST -> currentState.direction = moveVerticalDirection(currentState) ?: return Pair("",0)
                    Direction.WEST -> currentState.direction = moveVerticalDirection(currentState) ?: return Pair("",0)
                }
            }
            CellType.VERTICAL, CellType.HORIZONTAL -> null
        }
        when (currentState.direction) {
            Direction.SOUTH -> lineDiff = 1
            Direction.NORTH -> lineDiff = -1
            Direction.EAST -> rowDiff = 1
            Direction.WEST -> rowDiff = -1
        }
        currentState.line += lineDiff
        currentState.row += rowDiff
        steps++
    }
}

fun partTwo(diagram : List<List<Char>>) : Int {
    return partOne(diagram).second
}
