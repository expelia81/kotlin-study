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
    val st= StringTokenizer(br.readLine(), " ")
    val st2 = StringTokenizer(br.readLine(), " ")
    var start = st2.nextToken().toInt()
    var end = st2.nextToken().toInt()


    var stone = Array(n+1) {i -> if (i>0) {st.nextToken().toInt()} else 0}

//    for (i in 0..n) println("stone : ${stone[i]}")

    val queue = LinkedList<Array<Int>>()

    queue.add(arrayOf(start,0))

    var set = HashSet<Int>()
    var delete = HashSet<Int>()

    for(i in 1..n) {
        set.add(i)
    }
    set.remove(start)


    var result = -1
    while (queue.isNotEmpty()) {
        var now = queue.poll()
        if (now[0]==end) {
            result = now[1]
            break
        }
        var step = stone[now[0]]
        var mod = now[0] % step

        for (value in set) {
            if (value%step == mod) {
                delete.add(value)
                queue.add(arrayOf(value,now[1]+1))
            }
        }
        for (target in delete) {
            set.remove(target)
        }
        delete.clear()

    }

    bw.write("$result")



    bw.flush()
    br.close()
    bw.close()
}
