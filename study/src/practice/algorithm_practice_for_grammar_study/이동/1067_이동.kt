package practice.algorithm_practice_for_grammar_study.이동
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
    var one = Array(n){0}
    var two = Array(n){0}

    repeat(n) {
        one[it] = st.nextToken().toInt()
    }

    st= StringTokenizer(br.readLine(), " ")
    repeat(n) {
        two[it] = st.nextToken().toInt()
    }
    Arrays.sort(one)
    Arrays.sort(two)
//    println(one.joinToString())
//    println(two.joinToString())

    var max = 0L

    for (i in 0 until n) {
        max += one[i]*two[i]
    }

    bw.write(max.toString())


    bw.flush()
    br.close()
    bw.close()
}