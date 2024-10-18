package practice.algorithm_practice_for_grammar_study.웜홀
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

private class Node(var index:Int) {
    var list = ArrayList<Edge>()
    var value = 0
    var origin = 0
}

private class Edge(var index:Int, var value:Int) {

}
fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var tc = br.readLine().toInt()


    repeat(tc) {
        var st= StringTokenizer(br.readLine(), " ")

        var n = st.nextToken().toInt()
        var m = st.nextToken().toInt()
        var w = st.nextToken().toInt()

        var nodes = Array<Node>(n+1) {i -> Node(i)}

        repeat(m) {
            st = StringTokenizer(br.readLine(), " ")
            var start = st.nextToken().toInt()
            var end = st.nextToken().toInt()
            var value = st.nextToken().toInt()
            nodes[start].list.add(Edge(end,value))
            nodes[end].list.add(Edge(start,value))
        }
        repeat(w) {
            st = StringTokenizer(br.readLine(), " ")
            nodes[st.nextToken().toInt()].list.add(Edge(st.nextToken().toInt(),st.nextToken().toInt() * -1))
        }


        var result = false
        repeat(n) {
            nodes.forEach { node ->
                    node.list.forEach { edge ->
                        val end = nodes[edge.index]
                        if (end.value > node.value + edge.value) {
                            end.value = node.value + edge.value
                        }
                    }
            }
        }

        nodes.forEach { node ->
                node.list.forEach { edge ->
                    val end = nodes[edge.index]
                    if (end.value > node.value + edge.value) {
//                        end.value = node.value + edge.value
                        result = true
                    }
                }
        }
        var ss = ""
        var tt = ""

        nodes.forEach { node ->
            ss += ("${node.value} ")
            node.origin = node.value
        }
        println(ss)
        println(tt)

        if (result) {
            println("YES")
        } else {
            println("NO")
        }

//        nodes.forEach { node ->
//            print("${node.value} ")
//        }
//        println()
//        nodes.forEach { node ->
//            print("${node.origin} ")
//        }
//        println()







    }

    bw.flush()
    br.close()
    bw.close()
}