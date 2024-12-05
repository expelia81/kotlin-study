package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st= StringTokenizer(br.readLine(), " ")

    var n = st.nextToken().toInt()
    var l = st.nextToken().toInt()
    var w = st.nextToken().toInt()
    var h = st.nextToken().toInt()

    var left = 0.0
    var right = Math.min(l, Math.min(w, h)).toDouble()

    var mid = 0.0

    while (left < right) {
        mid = (left+right)/2
        var count = (l/mid).toInt() * (w/mid).toInt() * (h/mid).toInt()
        if (count >= n) {
            left = mid
        } else {
            right = mid
        }
    }

    bw.write(left.toString())



    bw.flush()
    br.close()
    bw.close()
}