package day_01

import lib.circular
import lib.swap
import input
import input_test

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
