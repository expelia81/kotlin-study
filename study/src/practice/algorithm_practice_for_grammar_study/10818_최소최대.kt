package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    var st= StringTokenizer(br.readLine(), " ")
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    repeat(n) {
        var temp = st.nextToken().toInt()
        min = Math.min(min, temp)
        max = Math.max(max, temp)
    }

    bw.write("$min $max")


    bw.flush()
    br.close()
    bw.close()
}