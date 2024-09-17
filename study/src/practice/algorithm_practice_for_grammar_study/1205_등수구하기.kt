package practice.algorithm_practice_for_grammar_study

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(): Unit {

    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine(), " ");
    var n = st.nextToken().toInt()
    var score = st.nextToken().toInt()
    var p = st.nextToken().toInt()
    if (n==0) {
        bw.write("1")
        bw.flush()
        bw.close()
        br.close()
        return
    }
    st = StringTokenizer(br.readLine(), " ")
    val arr : Array<Int> = Array(n) { i -> st.nextToken().toInt() };

    arr.sortDescending()
    var rank = n+1;
    out@for (i in 0..<n) {
        var temp = arr[i];
        if (temp > score) {
            continue@out
        } else {
            rank = i+1;
            if (temp == score) {
                if (n==p) {
                    // n==p이면 최악에는 -1일 수 있음.
                    if (arr[n-1]==score) {
                        rank = -1
                    }
                }
            }
            break@out
        }
    }
    if (rank > p) {
        rank = -1
    }
    bw.write(rank.toString())



    bw.flush()
    br.close()
    bw.close()
}