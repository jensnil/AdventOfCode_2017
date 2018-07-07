package day_18

import java.util.*

fun part_one(commands : List<List<String>>): Long {
    var instrutionPointer : Int = 0
    var latestSound = 0L
    var registers = mutableMapOf<Char, Long>()
    while (0 <= instrutionPointer && instrutionPointer < commands.size) {
        when (commands[instrutionPointer][0]) {
            "snd" ->
                latestSound = (registers[commands[instrutionPointer][1][0]] ?:  commands[instrutionPointer][1].toLong())
            "set" ->
                registers[commands[instrutionPointer][1][0]] = registers[commands[instrutionPointer][2][0]] ?:  commands[instrutionPointer][2].toLong()
            "add" ->
                registers[commands[instrutionPointer][1][0]] = (registers[commands[instrutionPointer][1][0]] ?: 0L) + (registers[commands[instrutionPointer][2][0]] ?:  commands[instrutionPointer][2].toLong())
            "mul" ->
                registers[commands[instrutionPointer][1][0]] = (registers[commands[instrutionPointer][1][0]] ?: 0L) * (registers[commands[instrutionPointer][2][0]] ?:  commands[instrutionPointer][2].toLong())
            "mod" ->
                registers[commands[instrutionPointer][1][0]] = (registers[commands[instrutionPointer][1][0]] ?: 0L) % (registers[commands[instrutionPointer][2][0]] ?:  commands[instrutionPointer][2].toLong())
            "rcv" ->
                if (registers[commands[instrutionPointer][1][0]] ?: 0L != 0L) {
                    registers[commands[instrutionPointer][1][0]] = latestSound
                    return latestSound
                }
            "jgz" ->
                if (registers[commands[instrutionPointer][1][0]] ?: 0L > 0L) {
                    instrutionPointer += ((registers[commands[instrutionPointer][2][0]] ?: commands[instrutionPointer][2].toLong()) - 1L).toInt()
                }
        }
        instrutionPointer++
    }
    return latestSound
}

fun part_two(commands : List<List<String>>) : Int {
    val ip = intArrayOf(0, 0)
    val queue  : List<Queue<Long>> = listOf(ArrayDeque(), ArrayDeque())
    val reg = listOf(mutableMapOf<Char, Long>(), mutableMapOf())
    var cp = 0
    var sends = 0
    reg[0]['p'] = 0
    reg[1]['p'] = 1
    while (true) {
        if (commands[ip[0]][0] == "rcv" && queue[1].isEmpty() &&
                commands[ip[1]][0] == "rcv" && queue[0].isEmpty()) {
            break
        }

        when (commands[ip[cp]][0]) {
            "snd" -> {
                if (cp == 1) {
                    sends++
                }
                queue[cp].add(reg[cp][commands[ip[cp]][1][0]] ?:  commands[ip[cp]][1].toLong())
                ip[cp]++
            }
            "set" -> {
                reg[cp][commands[ip[cp]][1][0]] =
                        reg[cp][commands[ip[cp]][2][0]] ?:  commands[ip[cp]][2].toLong()
                ip[cp]++
            }
            "add" -> {
                reg[cp][commands[ip[cp]][1][0]] =
                        (reg[cp][commands[ip[cp]][1][0]] ?: 0L) +
                        (reg[cp][commands[ip[cp]][2][0]] ?:  commands[ip[cp]][2].toLong())
                ip[cp]++
            }
            "mul" -> {
                reg[cp][commands[ip[cp]][1][0]] =
                        (reg[cp][commands[ip[cp]][1][0]] ?: 0L) *
                        (reg[cp][commands[ip[cp]][2][0]] ?:  commands[ip[cp]][2].toLong())
                ip[cp]++
            }
            "mod" -> {
                reg[cp][commands[ip[cp]][1][0]] =
                        (reg[cp][commands[ip[cp]][1][0]] ?: 0L) %
                        (reg[cp][commands[ip[cp]][2][0]] ?:  commands[ip[cp]][2].toLong())
                ip[cp]++
            }
            "rcv" -> {
                if (queue[(cp + 1 ) % 2].any()) {
                    reg[cp][commands[ip[cp]][1][0]] = queue[(cp + 1 ) % 2].poll()
                    ip[cp]++
                } else {
                    cp = (cp + 1 ) % 2
                }
            }
            "jgz" -> {
                if (reg[cp][commands[ip[cp]][1][0]] ?: commands[ip[cp]][1].toLong() > 0L) {
                    ip[cp] += ((reg[cp][commands[ip[cp]][2][0]] ?: commands[ip[cp]][2].toLong())).toInt()
                } else {
                    ip[cp]++
                }
            }
        }

    }
    return sends
}
