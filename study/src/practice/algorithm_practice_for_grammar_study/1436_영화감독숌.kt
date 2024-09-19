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

    var count = 0
    var result = 0;
    while (count != n){
        if ("$result".contains("666")) {
            count++;
            result++;
        } else {
            result++;
        }
    }
    result--;
    bw.write(result.toString())


    bw.flush()
    br.close()
    bw.close()
}