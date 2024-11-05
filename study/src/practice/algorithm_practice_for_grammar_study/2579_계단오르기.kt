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

    var list = Array<Int>(n){br.readLine().toInt()}

    var dp = Array<Int>(n){0}

    dp[0] = list[0]
    var max = 0
    if (n > 1) {
        dp[1] = list[0] + list[1]
        max = dp[1]
    }
    if (n > 2) {
        dp[2] = Math.max(dp[1], Math.max(list[0] + list[2], list[1] + list[2]))
        max = dp[2]
    }
    if (n==3) {
        max = Math.max(list[0] + list[2], list[1] + list[2]);
    } else if (n > 3) {
        for (i in 3 until n-1) {
            dp[i] = Math.max(dp[i-2] + list[i], dp[i-3] + list[i-1] + list[i]);
            max = Math.max(max, dp[i])
        }
        max = Math.max(dp[n-3]+list[n-1], dp[n-4]+list[n-2]+list[n-1])
    }
    bw.write(max.toString())

    bw.flush()
    br.close()
    bw.close()
}