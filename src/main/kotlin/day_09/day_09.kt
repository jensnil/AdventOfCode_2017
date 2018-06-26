package day_09

fun part_one(input: List<Char>): Int {
    var depth = 0
    var isCanceled = false
    var isGarbage = false
    var score = 0
    input.forEach { c ->
        if (isCanceled) {
            isCanceled = false
        } else if (c == '!') {
            isCanceled = true
        } else if (isGarbage) {
            if (c == '>') {
                isGarbage = false
            }
        } else if (c == '<') {
            isGarbage = true
        } else if (c == '{') {
            depth++
        } else if (c == '}') {
            score += depth
            depth--
        }
    }
    return score
}

fun part_two(input: List<Char>): Int {
    var depth = 0
    var isCanceled = false
    var isGarbage = false
    var score = 0
    input.forEach { c ->
        if (isCanceled) {
            isCanceled = false
        } else if (c == '!') {
            isCanceled = true
        } else if (isGarbage) {
            if (c == '>') {
                isGarbage = false
            } else {
                score++
            }
        } else if (c == '<') {
            isGarbage = true
        } else if (c == '{') {
            depth++
        } else if (c == '}') {
            depth--
        }
    }
    return score
}
