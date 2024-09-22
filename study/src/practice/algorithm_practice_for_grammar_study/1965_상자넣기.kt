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
    var st= StringTokenizer(br.readLine(), " ")

    arr = Array(n) {st.nextToken().toInt()}

    dp = Array(n) {
        0
    }

    // dp[i] = dp[i-1]+1
    for (i in arr.indices.reversed()) {
        dp(i);
    }

    bw.write(result.toString())

    bw.flush()
    br.close()
    bw.close()
}

private lateinit var dp :Array<Int>;
private lateinit var arr :Array<Int>
private var result = 0
fun dp(a : Int): Int {
    if (dp[a] != 0) {
        return dp[a]
    }

    dp[a]=1
    for (i in 0..<a) {
        if (arr[a] > arr[i]) {
//            println("$i : ${dp(i)}")
            dp[a] = Math.max(dp(i)+1,dp[a])
        }
    }
    result = Math.max(dp[a], result)
    return dp[a]
}