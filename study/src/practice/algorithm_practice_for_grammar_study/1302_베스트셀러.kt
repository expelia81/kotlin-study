package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()

    var map = HashMap<String,Short>()

    val short : Short = 0
    var max : Short= 0
    for (i in 0..<n) {
        val str = br.readLine()
        map.put(str, ((map.getOrDefault(str,short)+1).toShort()))
        max = Math.max(map.get(str)!!.toInt(),max.toInt()).toShort()
    }

    bw.write(map.keys.stream()
        .sorted()
        .filter { i -> map[i] == max }
        .findFirst()
        .get())

    bw.flush()
    br.close()
    bw.close()
}