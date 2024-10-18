package practice.algorithm_practice_for_grammar_study.오민식의고민
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private data class Edge(var index:Int, var value:Int)
private class Node(start : Int, index: Int){
    val list : ArrayList<Edge> = ArrayList()
    var value = 0

    var first = if (start==index) 0 else Long.MAX_VALUE
    var second = first

    var tag = false;



    fun setFirstTo(v : Long) {
        first = v
        second = v
    }
    fun addEdge(end : Int, price : Int) {
        list.forEach(){ i ->
            if (i.index==end) {
                i.value = Math.min(i.value,price)
                return
            }
        }
        list.add(Edge(end,price))
    }

    override fun toString(): String {
        return "Node(list=${list.size}, value=$value, first=$first, second=$second, tag=$tag)"
    }
}
fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st= StringTokenizer(br.readLine(), " ")

    var n = st.nextToken().toInt()
    var start = st.nextToken().toInt()
    var end = st.nextToken().toInt()
    var m = st.nextToken().toInt()

    var nodes = Array(n){ i -> Node(start, i)}

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine(), " ")
        nodes[st.nextToken().toInt()].addEdge(st.nextToken().toInt(), st.nextToken().toInt())
    }
    st = StringTokenizer(br.readLine(), " ")
    for (i in 0 until n) {
        nodes[i].value = st.nextToken().toInt()
    }
    nodes[start].setFirstTo(nodes[start].value * -1L)

    fun setFirstTurn(node : Node) {
        if (node.first == Long.MAX_VALUE) return
        node.list.forEach(){
            var temp = it.value - nodes[it.index].value
            // 쓴 돈을 기준으로 계산할 것이다. 쓴 돈이 적을수록 돈을 아낀 셈이 된다.
            if (nodes[it.index].first > node.first + temp) {
                nodes[it.index].setFirstTo(node.first+temp)
            }
        }
    }

    repeat(n){
        setFirstTurn(nodes[start])
        for (i in 0 until n) {
            if(i==start) continue
            setFirstTurn(nodes[i])
        }
    }

    fun setSecondTurn(node : Node) {
        if (node.second == Long.MAX_VALUE) return
        node.list.forEach(){
            var temp = it.value - nodes[it.index].value
            // 쓴 돈을 기준으로 계산할 것이다. 쓴 돈이 적을수록 돈을 아낀 셈이 된다.
            if (nodes[it.index].second > node.second + temp) {
                nodes[it.index].second = (node.second+temp)
            }
        }
    }
    setSecondTurn(nodes[start])
    for (i in 0 until n) {
        if(i==start) continue
        setSecondTurn(nodes[i])
    }

    fun createTag( node: Node) {
        node.tag = true
        node.list.forEach() {
            var target:Node = nodes[it.index]
            if (!target.tag) {
                createTag(target)
            }
        }
    }



    nodes.forEach { i ->
//        println("${i.first} ${i.second}    edges : ${i.list.get(0)}")
        if (i.second != i.first) {
            createTag(i)
        }
    }

    if (nodes[end].second == Long.MAX_VALUE) {
        println("gg")
    } else if(nodes[end].tag) {
        println("Gee")
    } else /*(nodes[end].second == nodes[end].first)*/ {
        println(nodes[end].first * -1)
    }




    bw.flush()
    br.close()
    bw.close()
}