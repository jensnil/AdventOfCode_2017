package day_15

fun partOne(factorA: Int, factorB: Int): Int {
    var matchCount = 0
    var generatorA : Long = factorA.toLong()
    var generatorB : Long = factorB.toLong()
    for (i in 0..40000000) {
        generatorA = (16807 * generatorA) % 2147483647
        generatorB = (48271 * generatorB) % 2147483647
        if (generatorA and 0xFFFF == generatorB and 0xFFFF) {
            matchCount++
        }
    }
    return matchCount
}

fun partTwo(factorA: Int, factorB: Int) : Int {
    var matchCount = 0
    var generatorA : Long = factorA.toLong()
    var generatorB : Long = factorB.toLong()
    for (i in 0..5000000) {
        do {
            generatorA = (16807 * generatorA) % 2147483647
        } while (generatorA % 4L != 0L);
        do {
            generatorB = (48271 * generatorB) % 2147483647
        } while (generatorB % 8L != 0L);
        if (generatorA and 0xFFFF == generatorB and 0xFFFF) {
            matchCount++
        }
    }
    return matchCount
}
