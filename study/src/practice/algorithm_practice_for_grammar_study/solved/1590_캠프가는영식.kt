package practice.algorithm_practice_for_grammar_study.solved
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private data class Edge(var value:Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return this.value - other.value
    }
}
fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st= StringTokenizer(br.readLine(), " ")

    var n = st.nextToken().toInt()
    var time = st.nextToken().toInt()

    var target = Edge(time)

    var q = PriorityQueue<Edge>()

    repeat(n) {
        st = StringTokenizer(br.readLine(), " ")
        var s = st.nextToken().toInt()
        var i = st.nextToken().toInt()
        var c = st.nextToken().toInt()

        var count = 0

        while (s < target.value) {
            s += i
            count++
        }
        if (count < c) {
            q.add(Edge(s))
        }
    }

    if (q.isEmpty()) {
        bw.write("-1")
    } else {
        bw.write("${q.poll().value - target.value}")
    }

    bw.flush()
    br.close()
    bw.close()
}