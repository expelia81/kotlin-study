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

    var header = 1;

    while (n>header) {
        n-=header
        header++
    }

    var value = header
    var top = 1

    while (n>1) {
        n--
        top++
        value--
    }

    if (header%2==0) {
        bw.write("$top/$value")
    } else {
        bw.write("$value/$top")
    }

    bw.flush()
    br.close()
    bw.close()
}