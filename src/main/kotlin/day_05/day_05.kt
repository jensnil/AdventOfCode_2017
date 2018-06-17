package day_05


fun part_one(input: List<Int>): Int {
    val instruction = input.toMutableList()
    var ip = 0
    var count = 0
    var tmp: Int
    while (0 <= ip && ip < input.size) {
        tmp = instruction[ip]
        instruction[ip]++
        ip += tmp
        count++
    }
    return count
}

fun part_two(input: List<Int>): Int {
    val instruction = input.toMutableList()
    var ip = 0
    var count = 0
    var tmp: Int
    while (0 <= ip && ip < input.size) {
        tmp = instruction[ip]
        instruction[ip] += if (instruction[ip] >= 3) -1 else 1
        ip += tmp
        count++
    }
    return count
}
