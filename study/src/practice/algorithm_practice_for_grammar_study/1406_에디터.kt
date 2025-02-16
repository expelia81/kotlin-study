package practice.algorithm_practice_for_grammar_study

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashSet

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

//    var st = StringTokenizer(br.readLine())

    var list = ArrayList<Char>()
    var after = LinkedList<Char>()

    var s = br.readLine()
    for (c in s) {
        list.add(c)
    }

    fun log() {
        var sb = StringBuilder()
        for (c in list) {sb.append(c)}
        for (c in after) {sb.append(c)}
        println(sb.toString())
    }

    repeat(br.readLine().toInt()) {
        var st = StringTokenizer(br.readLine(), " ")
        var order = st.nextToken().single()
        if (order == 'L') {
            if (list.isNotEmpty()) {
                after.addFirst(list.removeLast())
            }
        } else if (order == 'D') {
            if (after.isNotEmpty()) {
                list.add(after.removeFirst())
            }
        } else if (order == 'B') {
            if (list.isNotEmpty()) {
                list.removeLast()
            }
        } else if (order == 'P') {
            list.add(st.nextToken().single())
        }
//        log()
    }
    var sb = StringBuilder()
    list.forEach{sb.append(it)}
    after.forEach{sb.append(it)}

    bw.write(sb.toString())


    br.close()
    bw.close()
}