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

    val map = HashMap<Int,MutableList<String>>()
    repeat(n) {
        var st = StringTokenizer(br.readLine(), " ")
        var age = st.nextToken().toInt()
        var name = st.nextToken()
        if (!map.containsKey(age)) {
            map.put(age,ArrayList())
        }
        map.get(age)?.add(name)
    }

    map.keys
        .stream()
        .sorted()
        .forEach{
            map.get(it)?.forEach{name ->
                bw.write("$it $name\n")
            }
        }


    bw.flush()
    br.close()
    bw.close()
}