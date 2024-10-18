package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

private class NodePair(var first:Int, var second:Int) {
    override fun toString(): String {
        return "($first, $second)"
    }
}
fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()


    var array = Array(n){Array(10){ArrayList<NodePair>()} }

    fun extracted(
        min: Int,
        i: Int,
        j: Int
    ) {
        array[j-1][min].forEach { pair ->
            var temp = pair.first or (1 shl i)
            var tr = true
            array[j][i].forEach { nextpair ->
                if (nextpair.first == temp) {
                    nextpair.second += pair.second
                    if (nextpair.second>= 1000000000) nextpair.second %= 1000000000
                    tr = false
                }
            }
            if (tr) array[j][i].add(NodePair(temp, pair.second))
        }
    }

    for (i in 1..<10) {
        array[0][i].add(NodePair(1 shl i,1))
    }
    for (j in 1..<n) {
        for (i in 0..<10) {
            var min = i-1
            var max = i+1

            if (min >= 0) extracted(min,i,j)

            if (max < 10) extracted(max,i,j)
        }
    }

    var result = 0b1111111111

    var value = 0

    for (i in 0..<10) {
        array[n-1][i].forEach {pair ->
            if (pair.first==result) {
                value+=pair.second
                value%=1000000000
            }
        }
    }
    bw.write(value.toString())



    bw.flush()
    br.close()
    bw.close()
}
