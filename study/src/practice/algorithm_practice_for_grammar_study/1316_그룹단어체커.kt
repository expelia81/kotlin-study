package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashSet

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()

    var count = 0

    var res = 0;

    var set = HashSet<Char>()
    var pre : Char = '-'

    for (i in 1..n) {
        var str = br.readLine()
        pre = '-'
        set.clear()
        var result = true
        for (i in str.indices) {
            if (set.contains(str.get(i))) {
                if (pre == str.get(i)) {
                    pre = str.get(i)
                } else {
                    result = false
                    break
                }
            } else {
                pre = str.get(i)
                set.add(pre)
            }
        }
        if (result) res++
    }

    bw.write(res.toString())


    bw.flush()
    br.close()
    bw.close()
}