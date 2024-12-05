package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toBigInteger()

    println(Long.MAX_VALUE)

    var one = BigInteger.ONE

    while (n>one) {
        var sqrt = n.sqrt()
        var plusOneSqrt = sqrt.plus(one).pow(2)
        sqrt = sqrt.pow(2)

        println("$sqrt $plusOneSqrt")

    }


    bw.flush()
    br.close()
    bw.close()
}