package practice.algorithm_practice_for_grammar_study.타임머신
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

private data class Edge(var index:Int, var value:Int)
private data class Node(val index: Int){
    val list : ArrayList<Edge> = ArrayList()
    var first : Long = if (index==0) 0 else Long.MAX_VALUE
    var second : Long = 0
}
fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st= StringTokenizer(br.readLine(), " ")

    var n = st.nextToken().toInt()
    var m = st.nextToken().toInt()

    var nodes = Array(n+1){ i -> Node(i) }

    nodes[1].first=0

    for (i in 0..<m) {
        st = StringTokenizer(br.readLine(), " ")
        var start = st.nextToken().toInt()
        var end = st.nextToken().toInt()
        var value = st.nextToken().toInt()

        var contains = false
        nodes[start].list.forEach {
            if (it.index == end) {
                contains = true
                if (it.value > value) {
                    it.value = value
                }
            }
        }
        if (!contains) {
            nodes[start].list.add(Edge(end, value))
        }
    }

    for (k in 1..m) {
        for (i in 1..n) {
            if (nodes[i].first!= Long.MAX_VALUE) {
                nodes[i].list.forEach() {
                    if (nodes[it.index].first > nodes[i].first+it.value) {
                        nodes[it.index].first = nodes[i].first+it.value
                    }
                }
            }
        }
    }
    for (i in nodes) {
        i.second = i.first
    }

    for (k in 1..m) {
        for (i in 1..n) {
            if (nodes[i].second!= Long.MAX_VALUE) {
                nodes[i].list.forEach() {
                    if (nodes[it.index].second > nodes[i].second+it.value) {
                        nodes[it.index].second = nodes[i].second+it.value
                    }
                }
            }
        }
    }

    for (i in 1..n) {
        if (nodes[i].first != nodes[i].second) {
            println(-1)
            return
        }
    }

    for (i in 2..n) {
        if (nodes[i].first!=Long.MAX_VALUE) {
            println(nodes[i].first)
        } else {
            println(-1)
        }
    }




    bw.flush()
    br.close()
    bw.close()
}