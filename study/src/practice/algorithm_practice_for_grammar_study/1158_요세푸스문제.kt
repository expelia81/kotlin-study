package practice.algorithm_practice_for_grammar_study

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 확장함수 사용해보기
fun main(){

    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine(), " ")
    n = st.nextToken().toInt()
    k = st.nextToken().toInt()

    for (number in 1..n) {
        queue.add(number)
    }
    for (number in 1..n) {
        queue.yosephus(k)
        result.add(queue.poll())
    }
    bw.write(result.toString().replace("[", "<").replace("]",">"))

    bw.flush()
    br.close()
    bw.close()
}

var n = 0
var k = 0

private val queue : Queue<Int> by lazy {
//    println("lazy 호출됨! 큐 생성 완료!")
    LinkedList()
}
private val result : ArrayList<Int> by lazy {
//    println("lazy 호출됨! size : ${n}")
    ArrayList(n)
}
fun <T> Queue<T>.yosephus(a : Int) {
    for (i in 1..<a) this.add(this.poll())
}