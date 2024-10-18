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
    var m = st.nextToken().toInt()

    /*
        b -> black = 1 True
        w -> white = 0 False
     */

    var bBoard = Array(8){ i -> Array(8){j -> (j+i+1)%2 == 1}}
    var wBoard = Array(8){ i -> Array(8){j -> (j+i)%2 == 1}}

    var board = Array(n) {
        var s = br.readLine()
        Array(m) {i -> s[i] == 'B'}
    }

    var result = Int.MAX_VALUE

    for (i in 0..n-8) {
        for (j in 0..m-8) {
            var bCount = 0
            var wCount = 0
            for (k in 0..7) {
                for (l in 0..7) {
                    if (board[i+k][j+l] != bBoard[k][l]) {
                        bCount++
                    }
                    if (board[i+k][j+l] != wBoard[k][l]) {
                        wCount++
                    }
                }
            }
            result = Math.min(result, Math.min(bCount, wCount))
        }
    }

    bw.write("$result")






    bw.flush()
    br.close()
    bw.close()
}