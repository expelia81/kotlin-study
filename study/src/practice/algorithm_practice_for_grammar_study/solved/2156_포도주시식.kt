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

    var list = ArrayList<Int>()

    repeat(n) {
        list.add(br.readLine().toInt())
    }

    if (n < 3) {
        var sum = 0
        for (i in 0 until n) {
            sum += list[i]
        }
        bw.write(sum.toString())
        bw.flush()
        br.close()
        bw.close()
        return
    }

    var dp = Array(n){0}
    dp[0] = list[0]
    dp[1] = list[0] + list[1]
    dp[2] = Math.max(dp[1], Math.max(list[0] + list[2], list[1] + list[2]))

    for (i in 3 until n) {
        dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + list[i], dp[i-3] + list[i-1] + list[i]))
    }

    bw.write(dp[n-1].toString())

    bw.flush()
    br.close()
    bw.close()
}