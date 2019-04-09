package se.johannalynn.google.codejam.y2019.foregone.kotlin

import java.util.*
import java.io.InputStreamReader
import java.io.BufferedReader

fun result(number: String): String {
    val one = StringBuilder()
    val two = StringBuilder()

    number.chars().forEach {
        if (it.toChar() == '4') {
            one.append('3')
            two.append('1')
        } else {
            one.append(it.toChar())
            two.append('0')
        }
    }

    val second = two.toString()
    val retVal = one.toString() + " " + second.trimStart { it == '0' }
    return "tmp"
}

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val T = scanner.nextLine().trim().toInt()
    for (i in 1..T) {
        val input = scanner.nextLine()
        println("Case #${i}: " + result(input))
    }
}