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

    var array = Array(n) {br.readLine().toLong()}

    array.sort()

    var mid = array[n/2]

    var map = mutableMapOf<Long, Long>()

    var max = 0L;
    var maxCount = 0L
    var sum = 0L

    var array2 = ArrayList<Long>()

    array.forEach {
        sum += it
        if (map.containsKey(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
        if (maxCount < map[it]!!) {
            maxCount = map[it]!!
            array2.clear()
            array2.add(it)
        } else if (maxCount == map[it]!!) {
            array2.add(it)
        }
    }
    var first : Double = sum.toDouble()/n
    var temp = sum/n

    // 음수일 때 반올림, 양수일떄 반올림 나눠서 반올림해야한다.
    if (first < 0) {
        if (first - temp <= -0.5) {
            first -= 1
        }
    } else {
        if (first - temp >= 0.5) {
            first += 1
        }
    }


    var range = array[n-1] - array[0]

    array2.sort()

    if (array2.size > 1) {
        max = array2[1]
    } else {
        max = array2[0]
    }



    bw.write("${first.toLong()}\n$mid\n$max\n$range")

    bw.flush()
    br.close()
    bw.close()
}