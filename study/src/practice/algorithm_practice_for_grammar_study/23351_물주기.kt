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
    var k = st.nextToken().toInt()
    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()

    var array = Array(n+1) {k}

    var time = 0
    var index = 1
    while (true) {
        time++
        // a번만큼 b씩 물을 준다. 최대한 균등히 줘야하므로, 순차적으로 돌면 된다.
        repeat(a) {
            if (index > n) {
                index = 1
            }
            array[index] += b
        }

        // 모든 화분의 수명이 1일씩 줄어든다.
        for (i in 1..n) {
            array[i]--;
            // 0인 화분이 생기면 종료한다.
            if (array[i]==0) {
                println(time)
                return
            }
        }
    }


    bw.flush()
    br.close()
    bw.close()
}