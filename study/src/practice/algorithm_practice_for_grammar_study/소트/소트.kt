package practice.algorithm_practice_for_grammar_study.소트
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

/*
    의심 예제
    1 4 2 4 4 4
    // 같은 숫자라고 반드시 뭉치라는 법은 없다.
 */

private var start : Node? = null
private data class Node (var a : Int, var left : Node?) {
    var right : Node? = null

    init {
        left?.right = this
    }

    fun move(left: Node?) {
        this.delete()
        if (left == null) {
            this.right = start
            start?.left = this
            start = this
            return
        }
        this.left = left
        this.right = left.right
        left.right = this
        this.right?.left = this
    }
    fun delete() {
        if (left != null) {
            left?.right = right
        }
        if (right != null) {
            right?.left = left
        }
        left = null
        right = null
    }
    fun register(left: Node?, right: Node?) {
        this.left = left
        this.right = right
        left?.right = this
        right?.left = this
    }

    fun add(a : Int): Node {
        var node = this
        while (true) {
            if (node.right == null) {
                break
            }
            node = node.right!!
        }

        node.right = Node(a, node)
        return node.right!!
    }

    override fun toString() : String {
        var start : Node = this
        while (true) {
            start = start.left ?: break
        }
        var result = StringBuilder()
        while (true) {
            result.append("${start.a} ")
            start = start.right ?: break
        }
        return result.toString()
    }

}
fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()

    var st= StringTokenizer(br.readLine(), " ")

    var odd = LinkedList<Int>()
    var even = LinkedList<Int>()
    repeat(n) {
        var num = st.nextToken().toInt()
        if (num % 2 == 0) {
            even.add(num)
        } else {
            odd.add(num)
        }
    }
    odd.sort()
    even.sort()

    while (odd.isNotEmpty() && even.isNotEmpty()) {
        if (odd.first < even.first) {
            bw.write("${odd.removeFirst()} ")
        } else {
            bw.write("${even.removeFirst()} ")
        }
    }

    println(odd)
    println(even)




    bw.flush()
    br.close()
    bw.close()
}