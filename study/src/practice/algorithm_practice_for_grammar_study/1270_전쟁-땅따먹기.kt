package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    val map = HashMap<Long,Int>()
    for (i in 0..<n) {
        var st= StringTokenizer(br.readLine(), " ")
//        array = Array(st.nextToken().toInt()) {st.nextToken().toUInt()}

//        array.sort()
        var t = st.nextToken().toInt()
        for (i in 0..<t) {
            var temp = st.nextToken().toLong()
            map[temp] = map.getOrDefault(temp, 0)+1
        }

        var max = t/2;
        var duplicated = false
        var number = Long.MAX_VALUE
        for (key in map.keys) {
//            println("$key : ${map[key]}")
            if (max < map[key]!!) {
                max = map[key]!!
                duplicated = false
                number = key
            } else if (max == map[key]) {
                duplicated=true
            }
        }
        if (duplicated || number==Long.MAX_VALUE) bw.write("SYJKGW\n")
        else bw.write("$number\n")

        map.clear()
    }

    bw.flush()
    br.close()
    bw.close()
}