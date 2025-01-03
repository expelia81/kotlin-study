package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st= StringTokenizer(br.readLine(), " ")

    var n = st.nextToken().toInt()
    var k = st.nextToken().toInt()

    st = StringTokenizer(br.readLine(), " ")

    var count = st.nextToken().toInt()

    var bar = Bar(1, n, k)

    while (count-- > 0) {
        st = StringTokenizer(br.readLine(), " ")
        var index = st.nextToken().toInt()
        var temp = bar.move(index)
//        println("temp: $temp")
        bar.result += temp
    }

    bw.write(bar.result.toString())


    bw.flush()
    br.close()
    bw.close()
}

class Bar(val lMax:Int, val rMax:Int, var length:Int) {

    var l = 1
    var r = length
    var result = 0

    fun move(index:Int) : Int {
        if (index < l) {
            var temp = l-index
            l = index
            r = index+length-1
//            println("l: $l, r: $r, index: $index")
            return temp
        } else if (index > r) {
            var temp = index-r
            r = index
            l = index-length+1
//            println("l: $l, r: $r, index: $index")
            return temp
        } else {
//            println("l: $l, r: $r, index: $index")
            return 0
        }
    }

    fun moveLeft() : Boolean {
        if (r==rMax) {
            return false
        }
        l++
        r++
        return true
    }

    fun moveRight() : Boolean {
        if (l==lMax) {
            return false
        }
        l--
        r--
        return true
    }
}