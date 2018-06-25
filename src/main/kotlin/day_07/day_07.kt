package day_07

fun part_one(input: Map<String, Pair<Int, List<String>>>): String {
    //var tree = HashMap(input)
    var firstValue: String? = input.keys.first()
    while (true) {
        val temp = firstValue
        val temp2 = input.filter { it ->
            it.value.second.indexOf(temp) != -1
        }.keys.firstOrNull()
        if (temp2 == null) {
            break
        }
        firstValue = temp2
    }
    return firstValue.toString()
}

var diffValue: Int = 0

fun part_two(input: Map<String, Pair<Int, List<String>>>): Int {
    get_sum(input, part_one(input), 0)
    return diffValue
}

fun get_sum(input: Map<String, Pair<Int, List<String>>>, name: String, indent: Int): Int {
    var sum = input[name]?.first ?: 0
    val sums = (input[name]?.second?.map {
        it to get_sum(input, it, indent + 1)
    })
    sum += sums?.map { it.second }?.sum() ?: 0
//    if (indent < 2) {
//        print("${"\t".repeat(indent)} ${name} ${sum}\n")
//    }
    if (diffValue == 0 && (sums?.map { it.second }?.max() ?: 0) - (sums?.map { it.second }?.min() ?: 0) != 0) {
        diffValue = (input[sums?.maxBy { it.second }?.first]?.first ?: 0) - ((sums?.map { it.second }?.max()
                ?: 0) - (sums?.map { it.second }?.min() ?: 0))
    }
    return sum
}

