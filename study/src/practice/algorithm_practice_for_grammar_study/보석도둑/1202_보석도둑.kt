package practice.algorithm_practice_for_grammar_study.보석도둑
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

private class Jewel (var weight:Int, var value:Int) : Comparable<Jewel>{
    override fun compareTo(other: Jewel): Int {
        if (weight == other.weight) {
            return value - other.value
        }
        return weight - other.weight
    }

    override fun toString(): String {
        return "Jewel(weight=$weight, value=$value)"
    }

}
fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st= StringTokenizer(br.readLine(), " ")

    var n = st.nextToken().toInt()
    var m = st.nextToken().toInt()


//    {a, b ->
//        if (a.weight == b.weight) {
//            a.value - b.value
//        } else {
//            a.weight - b.weight
//        }
//    }
    var resultQueue = PriorityQueue<Jewel>() {a, b -> b.value - a.value}
    var bags = PriorityQueue<Int>() {a, b -> a - b}

    var queue = PriorityQueue<Jewel>(){a,b -> a.weight - b.weight}
    repeat(n) {
        st = StringTokenizer(br.readLine(), " ")
        queue.add(Jewel(st.nextToken().toInt(), st.nextToken().toInt()))
    }
    repeat(m) {
        bags.add(br.readLine().toInt())
    }


    var result = 0L
    while (bags.isNotEmpty()) {
        var bag = bags.poll()
        // bags에서 넣을 수 있는 모든 보석들을 결과 큐에 삽입한다.
        while (queue.isNotEmpty()) {
            var jewel = queue.poll()
            if (jewel.weight <= bag) {
                resultQueue.add(jewel)
            } else {
                queue.add(jewel)
                break
            }
        }
        // 현재 가방에 삽입 가능한 보석은 다음 가방에도 반드시 삽입이 가능하다.
        if (resultQueue.isNotEmpty()) {
            var temp = resultQueue.poll().value
//            println("temp : $temp")
            result += temp
        }
    }

    bw.write("$result")




    


    bw.flush()
    br.close()
    bw.close()
}


/*
10 7
0100010
0010100
0001000
1010101
0100010
1010101
0001000
0010100
0100010
0000010
 */