package practice.algorithm_practice_for_grammar_study.타임머신



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

    // i 번째 계단을 밟았을 때 최대값
    var dp = Array<Int>(n){0}


    if (n < 3) {
        if (n == 1) {
            bw.write(list[0].toString())
        } else {
            bw.write((list[0] + list[1]).toString())
        }
        bw.flush()
        br.close()
        bw.close()
        return
    }

    dp[0] = list[0]
    dp[1] = list[0] + list[1]
    dp[2] = Math.max(list[0] + list[2], list[1] + list[2])

    //  후보들
    var two = 0

    for (temp in 3 until n) {
        two = Math.max(dp[temp-2], dp[temp-3] + list[temp-1])
        two += list[temp]
        dp[temp] = two
    }

    bw.write(dp[n-1].toString())


    bw.flush()
    br.close()
    bw.close()
}


