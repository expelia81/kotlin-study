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
    var st= StringTokenizer(br.readLine(), " ")
    var dough = st.nextToken().toInt()
    var topping = st.nextToken().toInt()

    var doughCalorie = br.readLine().toInt()

    var list = Array(n){br.readLine().toInt()}.toList().sortedDescending()

    var value = doughCalorie;

    fun getTemp() = value / dough
    fun getNext(calorie: Int) = (value+calorie) / (dough+topping)

    for (i in list) {
        if (getTemp() < getNext(i)) {
            value += i
            dough += topping
        }
    }
    bw.write(getTemp().toString())


    bw.flush()
    br.close()
    bw.close()
}
