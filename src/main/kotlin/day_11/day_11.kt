package day_11

class HexCoordinate(var x: Int, var y : Int, var z : Int) {
    fun move(command : String) {
        when (command) {
            "n" -> {
                y++
                z--
            }
            "ne" -> {
                x++
                z--
            }
            "se" -> {
                x++
                y--
            }
            "s" -> {
                y--
                z++
            }
            "sw" -> {
                x--
                z++
            }
            "nw" -> {
                x--
                y++
            }
        }
    }

    fun distanceToOrigon() : Int {
        return (Math.abs(x) +Math.abs(y) +Math.abs(z)) / 2
    }
}

fun part_one(input: List<String>): Int {
    var currentPosition = HexCoordinate(0,0,0)
    input.forEach {
        currentPosition.move(it)
    }
    return currentPosition.distanceToOrigon()
}

fun part_two(input: List<String>): Int {
    var maxDistance = -1
    var currentPosition = HexCoordinate(0,0,0)
    input.forEach {
        currentPosition.move(it)
        maxDistance = Math.max(maxDistance, currentPosition.distanceToOrigon())
    }
    return maxDistance
}
