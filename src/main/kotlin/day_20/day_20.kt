package day_20

data class Particle(val index : Int, var position : MutableList<Int>, var velocity : MutableList<Int>, var acceleration : MutableList<Int>, val sortOfPosition : Boolean =  false)  : Comparable<Particle> {
    fun getManhattanDistance() : Int = Math.abs(position[0]) + Math.abs(position[1]) + Math.abs(position[2])
    fun getManhattanVelocity() : Int = Math.abs(velocity[0]) + Math.abs(velocity[1]) + Math.abs(velocity[2])
    fun getManhattanAcceleration() : Int = Math.abs(acceleration[0]) + Math.abs(acceleration[1]) + Math.abs(acceleration[2])

    override fun compareTo(other: Particle) = when {
        getManhattanAcceleration() != other.getManhattanAcceleration() -> getManhattanAcceleration() - other.getManhattanAcceleration()
        getManhattanVelocity() != other.getManhattanVelocity() -> getManhattanVelocity() - other.getManhattanVelocity()
        else -> getManhattanDistance() - other.getManhattanDistance()
    }

    fun move() {
        acceleration.map {  velocity[0] += it }
        velocity.map {  position[0] += it }
    }
}

fun partOne(input : List<List<Int>>): Int {
    var particles = input.mapIndexed { idx, it -> Particle(idx, mutableListOf(it[0], it[1], it[2]), mutableListOf(it[3], it[4], it[5]), mutableListOf(it[6], it[7], it[8])) }
    return particles.sorted().first().index
}

fun partTwo(input : List<List<Int>>) : Int {
    var particles = input.map {Particle(0, mutableListOf(it[0], it[1], it[2]), mutableListOf(it[3], it[4], it[5]), mutableListOf(it[6], it[7], it[8])) }.toSortedSet()
    var nextParticles = sortedSetOf<Particle>()
    while (true) {
        particles.forEach {
            it.move()
            nextParticles.add(it)
        }

    }
    return 0
}
