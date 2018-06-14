package day_01

import lib.circular
import lib.swap
import input
import input_test

fun part_one(inputCircular : List<Int>) {
    var count = 0
    count = inputCircular.reduceIndexed { index, acc, _ ->
        if (inputCircular[index] == inputCircular[index - 1])
            acc + inputCircular[index].toString().toInt()
        else
            acc
    }
    println(count)
}

fun part_two(inputCircular : List<Int>) {
    var count = 0
    count = inputCircular.reduceIndexed { index, acc, _ ->
        if (inputCircular[index] == inputCircular[index + inputCircular.size/2])
            acc + inputCircular[index].toString().toInt()
        else
            acc
    }
    println(count)
}

fun main(args: Array<String>) {
    val inputCircular = input.toList().map{it.toString().toInt()}.circular()
    part_one(inputCircular)
    part_two(inputCircular)
}

