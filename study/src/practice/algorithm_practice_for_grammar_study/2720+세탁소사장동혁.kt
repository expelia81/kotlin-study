package practice.algorithm_practice_for_grammar_study
import java.io.*
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    var quarter = 25
    var dime = 10
    var nickel = 5
    var penny = 1

    repeat(n) {
        var money = br.readLine().toInt()
        var q = money / quarter
        money %= quarter
        var d = money / dime
        money %= dime
        var ni = money / nickel
        money %= nickel
        var p = money / penny
        bw.write("${q} ${d} ${ni} ${p}\n")
    }

    bw.flush()
    br.close()
    bw.close()
}

