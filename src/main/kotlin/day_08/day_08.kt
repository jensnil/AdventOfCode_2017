package day_08

data class Instruction(val register : String, val operator : String, val operator1 : Int, val comparatorRegister : String, val comparator : String, val operator2 : Int)


fun part_one(input: List<Instruction>): Int {
    var registers = input.map {
        it.register to 0
    }.toMap().toMutableMap()
    input.forEach {
        val comparatorRegister = registers[it.comparatorRegister] ?: 0
        var condition : Boolean =
            when (it.comparator) {
                ">" ->
                    comparatorRegister > it.operator2
                "<" ->
                    comparatorRegister < it.operator2
                ">=" ->
                    comparatorRegister >= it.operator2
                "<=" ->
                    comparatorRegister <= it.operator2
                "==" ->
                    comparatorRegister == it.operator2
                "!=" ->
                    comparatorRegister != it.operator2
                else -> false
            }
        if (condition) {
            when (it.operator) {
                "inc" -> registers[it.register] = (registers[it.register] ?: 0) + it.operator1
                "dec" -> registers[it.register] = (registers[it.register] ?: 0) - it.operator1
            }
        }
    }
    return registers.maxBy{ it.value }?.value ?: 0
}

fun part_two(input: List<Instruction>): Int {
    var registers = input.map {
        it.register to 0
    }.toMap().toMutableMap()
    var highest = 0
    input.forEach {
        val comparatorRegister = registers[it.comparatorRegister] ?: 0
        var condition: Boolean =
                when (it.comparator) {
                    ">" ->
                        comparatorRegister > it.operator2
                    "<" ->
                        comparatorRegister < it.operator2
                    ">=" ->
                        comparatorRegister >= it.operator2
                    "<=" ->
                        comparatorRegister <= it.operator2
                    "==" ->
                        comparatorRegister == it.operator2
                    "!=" ->
                        comparatorRegister != it.operator2
                    else -> false
                }
        if (condition) {
            when (it.operator) {
                "inc" -> registers[it.register] = (registers[it.register] ?: 0) + it.operator1
                "dec" -> registers[it.register] = (registers[it.register] ?: 0) - it.operator1
            }
            if (registers[it.register] ?: 0 > highest) {
                highest = registers[it.register] ?: 0
            }
        }
    }
    return highest
}
