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
    var m = st.nextToken().toInt()

    st = StringTokenizer(br.readLine(), " ")

    var list: Deque<Int> = LinkedList()

    for (i in 1..n) {
        list.add(i)
    }
    var result = 0;
    outer@for (i in 1 ..m) {
        var query = st.nextToken().toInt()
        var index = list.indexOf(query)
        if (list.peekFirst().equals(query)) {
            list.poll()
            continue@outer
        }
        if (index <= list.size/2) {
            for (i in 1..index) {
                moveLeft(list)
                result++;
            }
        } else {
            for (i in 1..list.size-index) {
                moveRight(list)
                result++
            }
        }
        var temp = list.poll()
//        if (temp!=query) {
//            println("경고!!!")
//        }
//        println("query : ${query}  index : ${index}   제거대상 : ${temp}")
    }

    bw.write(result.toString())

    bw.flush()
    br.close()
    bw.close()
}

fun moveLeft(list :Deque<Int>) {
    list.addLast(list.poll())
}

fun moveRight(list : Deque<Int>) {
    list.addFirst(list.pollLast())
}