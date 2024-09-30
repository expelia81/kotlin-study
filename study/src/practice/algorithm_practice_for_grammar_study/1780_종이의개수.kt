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
    var st: StringTokenizer
    val array = Array(n){
        st = StringTokenizer(br.readLine(), " ")
        Array(n){st.nextToken().toShort()}
    }

    var queue = LinkedList<Paper>()
    queue.add(Paper(array).registerNumbers())
    var plus = 0
    var minus = 0
    var zero = 0

    while (queue.isNotEmpty()) {
        val paper = queue.poll()
        if (paper.isNotClean()) {
            var length = paper.array.size/3
            for (y in 0..<paper.array.size step length) {
                for (x in 0..<paper.array.size step length){
                    val tempPaper = Paper(length)
                    for (i in y..<y+length) {
                        for(j in x..<x+length) {
//                            println("$i $j")
                            tempPaper.array[i-y][j-x] = paper.array[i][j]
                        }
                    }
                    queue.add(tempPaper.registerNumbers())
                }
            }
        } else {
            if (paper.isAllPlus()) plus++
            else if (paper.isAllMinus()) minus++
            else zero++
        }
    }

    bw.write("$minus\n$zero\n$plus")



    bw.flush()
    br.close()
    bw.close()
}

private fun Paper.isAllPlus():Boolean {
    return this.zero==0 && this.minus==0
}

private class Paper(a: Int) {
    var minus =0
    var plus=0
    var zero=0

    fun isAllZero():Boolean {
        return minus==0 && plus==0
    }

    fun isAllMinus(): Boolean {
        return plus==0 && zero==0
    }

    var array : Array<Array<Short>> = Array(a){
        Array(a){-2}
    }
    constructor(a :Array<Array<Short>>) : this(a.size) {
        array = a;
    }

    fun registerNumbers() : Paper {
        for (arr in array) {
            for (i in arr) {
                when(i) {
                    (1).toShort() -> plus++
                    (-1).toShort() -> minus++
                    else -> zero++
                }
            }
        }
        return this
    }

    override fun toString(): String {
        return "Paper(minus=$minus, plus=$plus, zero=$zero)"
    }

    fun isNotClean(): Boolean {
        return !(isAllMinus() || isAllZero() || isAllPlus())
    }
}