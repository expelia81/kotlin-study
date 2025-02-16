package practice.algorithm_practice_for_grammar_study

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.LinkedHashSet

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    var a = st.nextToken().toLong()
    var b = st.nextToken().toInt()
    var c = st.nextToken().toLong()


    fun recursive(value : Int) : Long {
        if (value==1) {
            return a%c
        }
        var temp = recursive(value/2)
        if (value%2 == 0) {
            return (temp * temp)%c
        } else {
            return ((temp * temp)%c * a%c)%c
        }
    }

    bw.write(recursive(b).toString())


    br.close()
    bw.close()
}