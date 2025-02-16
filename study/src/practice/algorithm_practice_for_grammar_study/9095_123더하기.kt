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

    var list = ArrayList<Int>()
    list.add(0)
    list.add(1)
    list.add(2)
    list.add(4)

    var max = 4

    var inputs = Array(n){
        var temp = br.readLine().toInt()
        max = Math.max(max, temp)
        temp
    }

    for (i in 4 .. max) {
        list.add(list[i-3] + list[i-2] + list[i-1])
    }

    inputs.forEach {
        bw.write(list[it].toString())
        bw.newLine()
    }





    bw.flush()
    br.close()
    bw.close()
}