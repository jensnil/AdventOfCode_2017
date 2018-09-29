package day_01

fun partOne(inputCircular : List<Int>) : Int {
    return inputCircular.reduceIndexed { index, acc, _ ->
        if (inputCircular[index] == inputCircular[index - 1])
            acc + inputCircular[index].toString().toInt()
        else
            acc
    }
}

fun partTwo(inputCircular : List<Int>) : Int {
    return inputCircular.reduceIndexed { index, acc, _ ->
        if (inputCircular[index] == inputCircular[index + inputCircular.size/2])
            acc + inputCircular[index].toString().toInt()
        else
            acc
    }
}
