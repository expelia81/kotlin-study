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
    var array = Array(101){Array(101){0}}

    for (i in 0..<n){
        st = StringTokenizer(br.readLine(), " ")
        var sx = st.nextToken().toInt()
        var sy = st.nextToken().toInt()
        var dx = st.nextToken().toInt()
        var dy = st.nextToken().toInt()


        for (x in sx..dx) {
            for (y in sy..dy) {
                array[y][x]++
            }
        }
    }

    var result = 0
    for (x in 1..100) {
        for (y in 1..100) {
            if (array[y][x]>m) {
                result++
            }
        }
    }

    bw.write(result.toString())




    bw.flush()
    br.close()
    bw.close()
}