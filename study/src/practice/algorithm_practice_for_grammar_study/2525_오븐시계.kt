package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    var hour = st.nextToken().toInt()
    var min = st.nextToken().toInt()

    var time = br.readLine().toInt()

    while (time > 0) {
        time--;
        min++;
        if (min==60) {
            hour++;
            min=0
            if (hour==24) {
                hour=0
            }
        }
    }
    bw.write("${hour} ${min}")

    bw.flush()
    br.close()
    bw.close()
}