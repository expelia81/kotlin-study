package practice.algorithm_practice_for_grammar_study.solved

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()


    var list = Array(n){br.readLine().toInt()};

    list.sort()

    var result : Long = 0

    for (i in 0 until n) {
        result += Math.abs(list[i]-(i+1))
    }

    bw.write(result.toString())





    bw.flush()
    br.close()
    bw.close()
}



