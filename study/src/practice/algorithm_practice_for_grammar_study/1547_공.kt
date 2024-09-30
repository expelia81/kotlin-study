package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    var ball = 1

    for (i in 0..<  n){
        var st= StringTokenizer(br.readLine(), " ")
        var m = st.nextToken().toInt()
        var k = st.nextToken().toInt()
        if (m == ball) {
            ball = k
        } else if (k == ball) {
            ball = m
        }
    }

    println(ball)


    bw.flush()
    br.close()
    bw.close()
}