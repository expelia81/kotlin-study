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

    var list = ArrayList<Array<Long>>()
    list.add(Array(10){0})
    list.add(Array(10){1})
    list.get(1).set(0,0)

    fun values(pre: Array<Long>, temp: Array<Long>): Unit {
        temp[1] = pre[0]
        temp[8] = pre[9]
        for (i in 1..8) {
            temp[i-1] += pre[i]
            temp[i-1] %= 1000000000L
            temp[i+1] += pre[i]
            temp[i+1] %= 1000000000L
        }
    }


    for (i in 1..n) {
        var pre = list.get(i)
        var temp = Array(10){0L}
        values(pre,temp)
        list.add(temp)

//        println(temp.joinToString(" "))
    }
    println(list[n].sum()%1000000000L)
    bw.flush()
    br.close()
    bw.close()
}