package practice.algorithm_practice_for_grammar_study//package practice.algorithm_practice_for_grammar_study
//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.util.*
//import kotlin.collections.ArrayList
//
//private var result = -1
//
//private class Node2(val value : Int, var turn : Short) {
//    override fun toString(): String {
//        return "Node(turn=$turn, value=$value)"
//    }
//
//}
//fun main() {
//    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
//
//    var st= StringTokenizer(br.readLine(), " ")
//
//    var n = st.nextToken().toInt()
//    var k = st.nextToken().toShort()
//
//    if (n < 10) {
//        println(-1)
//        return
//    }
//
//    var size = n.toString().length
//
//    var tens = IntArray(size+1){i -> Math.pow(10.0,i.toDouble()).toInt()}
//    var arr = Array(size){ i -> n%tens[size-i]/tens[size-i-1]}
//
//    /*
//        현재 문제점
//        4044 1  이걸 못품.
//
//        못푸는 이유는, 단순한 버블정렬로 할 경우, 최적의 횟수를 찾지 못할 수도 있기 때문임.
//        최대값을 구하는 부분에서 bfs를 통해 최적값을 찾아야함.
//
//     */
//
//    var queue : Queue<Node2> = LinkedList()
////    var queue2 : Queue<Node> = LinkedList()
//
//    var maxValue = Node2(arr.joinToString("").toInt(), 0)
//    queue.add(maxValue)
////    var set = Array(1000001){ false }
//    var set = ArrayList<Int>()
//
//    while (queue.isNotEmpty()/* || queue2.isNotEmpty()*/) {
////        if (queue.isEmpty()) {
////            queue.
////        }
//        val now = queue.poll()
////        set[now.value]=true
//        set.add(now.value)
//        val turn = now.turn
//        if (now.value > maxValue.value) {
//            maxValue = now
//        }
//        if (turn == size.toShort() || turn == k) continue
//
//        for (i in 0..<size) {
//            for (j in i+1..<size) {
//                var changed = now.value%tens[i+1]/tens[i]
//                var target = now.value%tens[j+1]/tens[j]
//                var next=now.value - changed*tens[i] + changed*tens[j] - target*tens[j] +target*tens[i]
////                if (set.contains(next) ||  target==0 ) {
//                if (set.contains(next) ||  maxValue.value > next) {
//                    continue
//                }
//                queue.add(Node2(next,(turn+1).toShort()))
//            }
//        }
//    }
//    // 881로 시작하는거 턴 2에서 나와야한다.
////    println("max 결정됨")
//
//
//    arr = Array(size){ i -> maxValue.value%tens[size-i]/tens[size-i-1]}
//
//    out@while (k - maxValue.turn > 0) {
//        maxValue.turn++
//        var temp = arr[size-1]
//        for (i in 1..size-1) {
//            if (arr[i-1]==arr[i]) break@out
//        }
//        arr[size-1]=arr[size-2]
//        arr[size-2]=temp
//        if (arr[0]==0) {
//            println(-1)
//            return
//        }
//    }
//
//    println(arr.joinToString(""))
//
//    br.close()
//}