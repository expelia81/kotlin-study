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

    var n = br.readLine().toInt()

    var list = ArrayList<ArrayList<Int>>()
    var result = ArrayList<ArrayList<Int>>()

    for (i in 0 until n) {
        var st= StringTokenizer(br.readLine(), " ")
        var temp = ArrayList<Int>()
        var temp2 = ArrayList<Int>()
        for (j in 0 until n) {
            temp.add(st.nextToken().toInt())
            temp2.add(0)
        }
        list.add(temp)
        result.add(temp2)
    }

    var queue = ArrayDeque<Pair<Int, Int>>()

    queue.add(Pair(0, 0))
    result.get(0).set(0, 1)

    while (queue.isNotEmpty()) {
        var temp = queue.poll()
        var x = temp.first
        var y = temp.second
        var value = list[x][y]
        var t = result[x][y]
        if (value == 0) {
            continue
        }
        if (value + x < n) {
            queue.add(Pair(value + x, y))
            var temp = result.get(value + x).get(y)
            result.get(value + x).set(y, temp+t)
        }
        if (value + y < n) {
            queue.add(Pair(x, value + y))
            var temp = result.get(x).get(value + y)
            result.get(x).set(value + y, temp+t)
        }
    }


    bw.write(result.get(n-1).get(n-1).toString())

//    result.forEach {
//        println(it)
//    }

    bw.flush()
    br.close()
    bw.close()
}