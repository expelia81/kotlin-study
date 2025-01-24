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

    if (n<100) {
        bw.write("$n")
        bw.close()
        br.close()
        return
    }

    var list = ArrayList<Int>()

    var result = 99
    for (i in 100..n) {
        list.clear()
        var temp = i
        while (temp > 0) {
            list.add(temp%10)
            temp/=10
        }

        var value = list[1]-list[0]
        for (j in 2 .. list.size-1) {
            if (value!=list[j]-list[j-1]) {
                value = -99
            }
        }
        if (value!=-99) {
            result++
        }
    }

    bw.write(result.toString())

    bw.flush()
    br.close()
    bw.close()
}