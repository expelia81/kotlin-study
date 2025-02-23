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

    var list = ArrayList<Size7568_EASY>()
    var count = 0
    repeat(n) {
        var st = StringTokenizer(br.readLine())
        count++
        list.add(Size7568_EASY(st.nextToken().toInt(),st.nextToken().toInt(), count))
    }

    list.sortByDescending { it.first }

    var index=0

    list[0].index = 0

    count=0

    for (i in 0..n-1) {
        if (count>0) {
            count--
            continue
        }
        list[i].index = ++index
        for (j in i+1 until n) {
            if (list[i].first > list[j].first && list[i].second > list[j].second) {
                break
            } else {
                list[j].index = list[i].index
                index++
                count++
            }
        }
    }

    list.sortBy { it.offset }

    bw.write(list.joinToString(" ") { "${it.index}" })

    bw.flush()
    br.close()
    bw.close()
}
class Size7568(val first : Int, val second : Int, val offset : Int) {
    public var index = -1
}

/*
6
55 181
54 181
56 181
55 179
56 182
54 190

221
 */