package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val st= StringTokenizer(br.readLine(), " ")

    val m = br.readLine().toInt()

    val numbers = Array<Int>(n){st.nextToken().toInt()}
    val assigned = Array(n){i -> i}
    assigned.sortBy { i -> numbers[i] }

    var max = 0
    var temp = m
    val result = ArrayList<Int>()
    for (i in assigned) {
        if (i!=0) {
            temp-=numbers[i]
            result.add(i)
            break
        }
    }
    if (temp<0) {
        println(0)
        return
    }

    max += temp/numbers[assigned[0]]
    for (i in 0..<max) {
        result.add(assigned[0])
    }
    temp %= numbers[assigned[0]]

    // 돈남으면 맨앞자리부터 자릿수 조금씩 올려가면 된다
    var index = 0
    while (index < result.size) {
        for (i in n-1 downTo 0) {
            if (temp >= numbers[i] - numbers[result[index]]) {
                temp -= (numbers[i] - numbers[result[index]])
                result[index] = i
                break
            }
        }
        index++
    }

    if (result[0]==0) {
        println(0)
    } else {
        println(result.joinToString(""))
    }








    bw.flush()
    br.close()
    bw.close()
}