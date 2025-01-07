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
    var st= StringTokenizer(br.readLine(), " ")
    var list = Array(n){st.nextToken().toInt()}

    var dp = Array(n){Array(2){0}}
    dp[0][0] = 1
    dp[0][1] = 1
    var max = 1

    for (i in 1 until n) {
        if (list[i] >= list[i-1]) {
            dp[i][0] = dp[i-1][0] + 1
        } else {
            dp[i][0] = 1
        }

        if (list[i] <= list[i-1]) {
            dp[i][1] = dp[i-1][1] + 1
        } else {
            dp[i][1] = 1
        }
        max = Math.max(max, Math.max(dp[i][0], dp[i][1]))
    }

    bw.write(max.toString())
    bw.flush()
    br.close()
    bw.close()
}