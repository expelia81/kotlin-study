package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    var st= StringTokenizer(br.readLine(), " ")
    var list = ArrayList<Int>()

    for (i in 0 until n) {
        list.add(st.nextToken().toInt())
    }

    var dp = Array(n){0}

    dp[0] = list[0]

    var max = dp[0]

    for (i in 1 until n) {
        dp[i] = Math.max(dp[i-1]+list[i], list[i])
        max = Math.max(max, dp[i])
    }

    bw.write(max.toString())

    bw.flush()
    br.close()
    bw.close()
}