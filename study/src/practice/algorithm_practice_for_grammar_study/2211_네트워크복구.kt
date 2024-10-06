//package practice.algorithm_practice_for_grammar_study
//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//import java.util.*
//import kotlin.collections.ArrayList
//
//private class Node(index:Int) {
//    var last = 0
//    val list = ArrayList<Array<Int>>()
//}
//private class Edge(var index: Int, val length:Int)
//
////private class History() {
////    var length = 0
////    val list : ArrayList<Array<Int>> = ArrayList()
////    constructor(start:Int, end:Int, length: Int, history: History) : this() {
////        this.length=history.length+length
////        this.list.addAll(history.list)
////        this.list.add(arrayOf(start,end))
////    }
////
////}
////private fun History.copy(start:Int, end:Int, length: Int) :History {
////    return History(start,end, length,this)
////}
////private fun init(start: Int, end: Int, length: Int) :History {
////    val history = History()
////    history.length = length
////    history.list.add(arrayOf(start,end))
////    return history
////}
//
//private val nodes = ArrayList<Node>()
//fun main() {
//    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
//    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
//
//    var st= StringTokenizer(br.readLine(), " ")
//
//    var n = st.nextToken().toInt()
//    var m = st.nextToken().toInt()
//
//    for (i in 0..n) {
//        nodes.add(Node(i))
//    }
//
//    for (i in 0 .. m-1) {
//        st = StringTokenizer(br.readLine(), " ")
//        var start = st.nextToken().toInt()
//        var end = st.nextToken().toInt()
//        var length = st.nextToken().toInt()
//
//        nodes[start].list.add(arrayOf(end,length))
//        nodes[end].list.add(arrayOf(start,length))
//    }
//
//    bw.flush()
//    br.close()
//    bw.close()
//}
//
//private fun daikstra(queue: Queue<Array<Edge>>) {
//
////    while (queue.isNotEmpty()) {
////        var edge =
////    }
//
//
//}