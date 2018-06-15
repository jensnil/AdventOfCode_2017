package day_01

fun part_one(inputCircular : List<Int>) : Int {
    return inputCircular.reduceIndexed { index, acc, _ ->
        if (inputCircular[index] == inputCircular[index - 1])
            acc + inputCircular[index].toString().toInt()
        else
            acc
    }
}

fun part_two(inputCircular : List<Int>) : Int {
    return inputCircular.reduceIndexed { index, acc, _ ->
        if (inputCircular[index] == inputCircular[index + inputCircular.size/2])
            acc + inputCircular[index].toString().toInt()
        else
            acc
    }
}
