package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var max = 10000

    var set = HashSet<Int>()
    for (i in 1..max) {
        set.add(i)
    }

    fun d(n: Int) {
     var result = n;
        var temp = n;

        while (temp > 0) {
            result += temp % 10;
            temp /= 10;
        }
        set.remove(result);
    }

    for (i in 1..max) {
        d(i);
    }

    for (i in set) {
        bw.write(i.toString() + "\n")
    }

    bw.flush()
    bw.close()
}