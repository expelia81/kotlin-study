package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt();
    var st = StringTokenizer(br.readLine())
    var numbers = Array(n) {st.nextToken().toInt()}

    st = StringTokenizer(br.readLine())
    var operator = Array(4){st.nextToken().toInt()}
    /*
    0 : +
    1 : -
    2 : x
    3 : /
     */

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    fun check(i : Int, pre : Int) {
        if (i==n) {
            max = Math.max(max, pre)
            min = Math.min(min, pre)
            return
        }
        var now = numbers[i]
        if (operator[0] > 0) {
            operator[0]--
            check(i+1, pre+now)
            operator[0]++
        }

        if (operator[1] > 0) {
            operator[1]--
            check(i+1, pre - now)
            operator[1]++
        }

        if (operator[2] > 0) {
            operator[2]--
            check(i+1, pre * now)
            operator[2]++
        }

        if (operator[3] > 0) {
            operator[3]--
            check(i+1, pre / now)
            operator[3]++
        }
    }

    check(1, numbers[0])

    bw.write("$max\n$min")




    bw.flush()
    br.close()
    bw.close()
}