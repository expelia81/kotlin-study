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
    var k = br.readLine().toInt()

    var arr = Array(n) {st.nextToken().toInt()}
    var dp = Array(100000){ 0 }

    var queue = LinkedList<Array<Int>>()
    queue.add(arrayOf(0,0))

    var index = 0
    while (queue.isNotEmpty()) {
        var temp = queue.poll()
        if (temp[0]>k) {
            continue
        }
        dp[temp[1]] = temp[0]


    }





    bw.flush()
    br.close()
    bw.close()
}