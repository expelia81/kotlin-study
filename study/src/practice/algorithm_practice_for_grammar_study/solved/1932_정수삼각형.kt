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

    var dp = Array(n){Array(n){0}}

    dp[0][0] = br.readLine().toInt()
    var max = dp[0][0]
    for (i in 1..<n) {
        var st= StringTokenizer(br.readLine(), " ")

        for (j in 0..i) {
            var temp = st.nextToken().toInt()
            if (j > 0) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + temp
            } else {
                dp[i][j] = dp[i-1][j] + temp
            }
            max = Math.max(max, dp[i][j])
        }
    }

    bw.write(max.toString())

    bw.flush()
    br.close()
    bw.close()
}