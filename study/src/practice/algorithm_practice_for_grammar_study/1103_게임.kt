import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashSet

private class Node(var y: Int, var x : Int, var value:Int) {
    var list = HashSet<Node>()
    var found = false
}

private lateinit var array : Array<Array<Node?>>

private var result = 0
private var n = 0
private var m = 0

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var st= StringTokenizer(br.readLine(), " ")

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    array = Array(n+1){Array(m+1){null} }

    for (i in 1..n) {
        val s = br.readLine()
        for (j in 1 .. m) {
            if (s.get(j-1) == 'H') {
                array[i][j]=Node(i,j,-1)
            } else {
                array[i][j]=Node(i,j,s.get(j-1).toString().toInt())
            }
        }
//        println(array[i].joinToString(","))
    }
    /*
        사이클이 돈다면 -1이 된다.
        사이클 판단은 어떻게 이루어질까.

        사이클을 알아야 하므로, DFS를 해야하는데 중간 과정을 기억하는 DPS가 되어야한다.

        현재 단계에서부터, 끝까지 얼마나 깊이까지 진행되는지 갯수를 DP로 저장해야한다.
     */
    dfs(1,1,-1,-1)

    if (result == Int.MAX_VALUE) {
        bw.write("-1")
    } else {
        bw.write(result.toString())
    }
    bw.flush()
    br.close()
    bw.close()
}
private var set = HashSet<Node>()

fun dfs(y : Int, x : Int, ry: Int, rx: Int) : Int {
    var now = array[y][x]!!
    if (result==Int.MAX_VALUE) return result
    if (now.value==-1) return 0
    if (now.found) { // 이미 탐색되어있는 경우, 해당 경로에 현재 노드가 들어있는지 확인한다.
        return now.list.size
    }

    // 추가한다
    set.add(now)

    // 아직 탐색되지 않았다면, 사방을 탐색하고, 탐색한 수치중 가장 높은 가장 높은 놈을 자신의 부모 노드로 삼는다.
    var dx = arrayOf(0,now.value,0,now.value.unaryMinus())
    var dy = arrayOf(now.value,0,now.value.unaryMinus(),0)
    for (i in 0..3) {
        var ny = y+dy[i]
        var nx = x+dx[i]
        if (checkRange(ny,nx)) {
//            println("y:$y x:$x  ny:${ny}  nx:${nx}  ry:$ry rx:$rx ")
//            if (array[ny][nx]!!.found) {
//                result = Int.MAX_VALUE
//                return result
//            }
            var nextNode = array[ny][nx]!!
            if (set.contains(nextNode)) {
                result = Int.MAX_VALUE
                return result
            }
            var temp = dfs(ny,nx,y,x)
            if (nextNode.list.contains(now)) {
                result = Int.MAX_VALUE
                return result
            }
            if (nextNode.list.size > now.list.size) {
                now.list.clear()
                now.list.addAll(array[ny][nx]!!.list)
            }
        }
    }

    now.list.add(now)

    result = now.list.size.coerceAtLeast(result)
    now.found = true
    // 회수한다
    set.remove(now)
    return now.list.size
}

fun checkRange(y : Int, x:Int) : Boolean {
//    println("y:$y x:$x  = ${(y <= 0 || x <=0 || y > n || x > m)}")
    return !(y <= 0 || x <=0 || y > n || x > m)
}