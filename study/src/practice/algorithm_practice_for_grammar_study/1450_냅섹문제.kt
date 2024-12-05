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

    var st= StringTokenizer(br.readLine(), " ")

    var n = st.nextToken().toInt()
    var c = st.nextToken().toInt()

    st= StringTokenizer(br.readLine(), " ")

    var list = Array(n){st.nextToken().toInt()}

    var queue = ArrayDeque<Int>()
    var queue2 = ArrayDeque<Int>()

    var middle = n/2

    var half1 = ArrayList<Int>()
    var half2 = ArrayList<Int>()


    queue.add(0)
    for (i in 0 until n/2) {
        queue.addAll(queue2)
        queue2.clear()
        while (queue.isNotEmpty()) {
            var temp = queue.poll()
            var one = list[i]+temp
            queue2.add(temp)
            if (one <= c) {
                queue2.add(one)
            }
        }
    }
    queue.addAll(queue2)
    queue2.clear()
    while (queue.isNotEmpty()) {
        half1.add(queue.poll())
    }

    queue.add(0)
    for (i in middle until n) {
        queue.addAll(queue2)
        queue2.clear()
        while (queue.isNotEmpty()) {
            var temp = queue.poll()
            var one = list[i]+temp
            queue2.add(temp)
            if (one <= c) {
                queue2.add(one)
            }
        }
    }
    queue.addAll(queue2)
    queue2.clear()
    while (queue.isNotEmpty()) {
        half2.add(queue.poll())
    }
    half1.sort()
    half2.sort()

    var result = 0
    for (i in half1) {
        var left = 0
        var right = half2.size
        var mid = right/2

        while (left < right) {
            mid = (left+right)/2
            if (i+half2[mid] <= c) {
                left = mid+1
            } else {
                right = mid
            }
        }
        result += left
    }
    bw.write(result.toString())



    bw.flush()
    br.close()
    bw.close()
}