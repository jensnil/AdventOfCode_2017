package day_02

fun partOne(spreadsheet : List<List<Int>>) : Int {
    return spreadsheet.map { it ->  (it.max() ?: 0) - (it.min() ?: 0) }.toList().sum()
}

fun partTwo(spreadsheet : List<List<Int>>) : Int {
    var sum = 0
    for (row in spreadsheet) {
        start@
        for (i in row) {
            for (j in row) {
                if (i != j && i % j == 0) {
                    sum += i / j
                    break@start
                }
            }
        }
    }
    return sum
}
