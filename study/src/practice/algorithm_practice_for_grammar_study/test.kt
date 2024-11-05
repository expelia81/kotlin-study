package practice.algorithm_practice_for_grammar_study

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))


    var value = br.readLine().toInt()
    while (value!=0) {
        var result = 0
        for (i in 1..value) {
            result+=i
        }
        println(result)
        value = br.readLine().toInt()
    }

    br.close()

}
