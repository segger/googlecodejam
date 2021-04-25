package se.johannalynn.google.codejam

import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import java.util.*

object Solution2 {

    private const val debug = true

    @JvmStatic
    fun main(args: Array<String>) {
        if (debug) {
            val data = """
                2
                2
                SE
                5
                EESSSESE
                
                """.trimIndent()
            val stdin = System.`in`
            try {
                System.setIn(ByteArrayInputStream(data.toByteArray()))
                run(args)
            } finally {
                System.setIn(stdin)
            }
        } else {
            run(args)
        }
    }

    fun run(args: Array<String>) {
        val input = Scanner(BufferedReader(InputStreamReader(System.`in`)))
        val T = input.nextLine().toInt()
        for (i in 1..T) {
            val dimensions = input.nextLine().toInt()
            val lydia = input.nextLine()
            println("Case #" + i + ": " + result(dimensions, lydia))
        }
    }

    private fun result(dimensions: Int, lydia: String): String {
        val buffer = StringBuffer()
        lydia.chars().forEach { c: Int ->
            if (c == 'E'.toInt()) {
                buffer.append('S')
            } else if (c == 'S'.toInt()) {
                buffer.append('E')
            } else {
                println("Something went wrong")
            }
        }
        return buffer.toString()
    }
}