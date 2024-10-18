package practice.algorithm_practice_for_grammar_study.다이아몬드광산
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

private class Node(a : Int, val y: Int, val x: Int) {
    var value = a;
    var rightUp = a;
    var leftUp = a;
    override fun toString(): String {
//        return "$value"
//        return "$leftUp"
        return "$leftUp / $rightUp"
//        return "($value, $leftUp, $rightUp)"
    }
}
fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st= StringTokenizer(br.readLine(), " ")

    var n = st.nextToken().toInt()
    var m = st.nextToken().toInt()

    var list = ArrayList<ArrayList<Node>>()

    var result = 0

    for (i in 0..<n) {
        var s = br.readLine()
        var temp = ArrayList<Node>()
        for (j in 0..<m) {
            var node = Node(if (s.get(j)=='1') 1 else 0, i, j)
            temp.add(node)
            if (node.value == 1) {
                if (i > 0 &&  j > 0) {
                    node.leftUp = list.get(i-1).get(j-1).leftUp + 1
                }
                if (i > 0 && j < m-1) {
                    node.rightUp = list.get(i-1).get(j+1).rightUp + 1
                }
            }
        }
        list.add(temp)
    }

    for (i in 0..<n) {
        for (j in 0..<m) {
            var node = list[i][j]
            var min = Math.min(node.leftUp, node.rightUp)
            while (min > 0) {
                var preX = j-min+1
                var preRightX= j+min-1
                var preY = i-min+1
                if (list[preY][preX].rightUp >= min && list[preY][preRightX].leftUp >= min) {
//                    println(node)
//                    println("now : ${node.y} ${node.x}  $preY  $preX  $preRightX   min : $min" )
                    result=Math.max(min, result)
                }
                min--;
            }
        }
    }

    println(result)

    


    bw.flush()
    br.close()
    bw.close()
}


/*
10 7
0100010
0010100
0001000
1010101
0100010
1010101
0001000
0010100
0100010
0000010
 */