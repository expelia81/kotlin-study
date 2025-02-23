package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt();

    var count2 = 0
    var count5 = 0
    for (i in 2..n) {
        var number = i
        while (number%2==0) {
            count2++
            number/=2
        }
        while (number%5==0) {
            count5++
            number/=5
        }
    }
    bw.write(Math.min(count2, count5).toString())

    bw.flush()
    br.close()
    bw.close()
}