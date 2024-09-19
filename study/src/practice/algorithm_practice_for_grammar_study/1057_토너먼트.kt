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
    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()

    var result = 1
    var queue1 = LinkedList<Int>()
    var queue2 = LinkedList<Int>()
    var tempQueue: LinkedList<Int>
    for (i in 1..n) {
        queue1.add(i)
    }
    out@while (true) {
        while (queue1.isNotEmpty()) {
            var one = queue1.poll()
            var two = Int.MAX_VALUE
            if (queue1.isNotEmpty()) {
                two = queue1.poll()
            }
            var oneEq = one==a || one==b
            var twoEq = two == a || two == b

            if (oneEq && twoEq) {
                break@out
            }
            if (twoEq) {
                queue2.add(two)
            } else {
                queue2.add(one)
            }
        }
        result++
        if (queue2.size==1) {
            bw.write("-1")
            bw.flush()
            bw.close()
            br.close()
            return
        } else {
            tempQueue = queue2
            queue2 = queue1
            queue1 = tempQueue
        }
    }
    bw.write("$result")




    bw.flush()
    br.close()
    bw.close()
}
