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

    var st = StringTokenizer(br.readLine())

    var n = st.nextToken().toInt()
    var k = st.nextToken().toInt()

    var map = Array(n+1){
        Array(n+1){0}
    }

    for (i in 1..n) {
        st = StringTokenizer(br.readLine())
        for (j in 1..n) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    var state = Array(n+1){
        Array(n+1){ArrayList<CP17837>()}
    }


    bw.flush()
    br.close()
    bw.close()
}
class LD17837(
    val ArrayList: ArrayList<Int>
)

class CP17837(
    val index:Int,
    val direction:Int
)