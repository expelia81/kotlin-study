package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()

    var map = mutableMapOf<String, Int>()

    repeat(n) {
        var s = StringTokenizer(br.readLine(), ".")
        s.nextToken()
        var extension = s.nextToken()

        if (map.containsKey(extension)) {
            map[extension] = map[extension]!! + 1
        } else {
            map[extension] = 1
        }
    }

    map.keys.stream()
        .sorted()
        .forEach() {
            bw.write("$it ${map[it]}\n")
        }


    bw.flush()
    br.close()
    bw.close()
}