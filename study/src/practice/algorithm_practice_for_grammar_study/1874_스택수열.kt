package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))

    var n = br.readLine().toInt()
    var array = Array<Int>(n+1){if (it==0) 0 else br.readLine().toInt()}
//    var st = StringTokenizer(br.readLine(), " ")
//    var array = Array<Int>(n+1){if (it==0) 0 else st.nextToken().toInt()}
    var stack = Stack<Int>()

    var sb = StringBuilder()

    fun Stack<Int>.ps(item: Int) {
        sb.append("+\n")
        this.push(item);
    }
    fun Stack<Int>.po() : Int {
        sb.append("-\n")
        return this.pop()
    }

    var top = 1
    stack.ps(top++)

    for (i in 1..n) {
        var now = array[i]
        while (true) {
            if (stack.isEmpty()) {
                if (top>n) {
                    break
                }
                stack.ps(top++)
            }
            if (now < stack.peek()) {
                println("NO")
                br.close()
                return
            }
            if (now == stack.peek()) {
                stack.po()
                break
            }
            stack.ps(top++)
        }
    }
    println(sb.toString())

    br.close()
}