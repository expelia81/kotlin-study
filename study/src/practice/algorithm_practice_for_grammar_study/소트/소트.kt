package practice.algorithm_practice_for_grammar_study.소트
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()

    var st= StringTokenizer(br.readLine(), " ")

    var max = 0

    var arr = Array(1003){0}

    for (i in 0 until n) {
        var temp = st.nextToken().toInt()
        arr[temp]++
        max = Math.max(max,temp)
    }
    var sb = StringBuilder();
    var now = 0

//    fun nextnext() :Int = {
//        var count = 2
////        while (arr[])
//    }
//    var list = ArrayList<Int>()
    fun extracted(count:Int, target:Int) {
//    println("반복 : $count  타겟값 : $target")
        repeat(count) {

            sb.append(target)
            sb.append(" ")
//            list.add(target)
            arr[target]--
        }
    }

    out@while (now <= max) {
//        println("현재 now : $now + ${list}")
        var count = arr[now]
        var next = arr[now+1]
        // 다음 숫자가 없다면 그대로 전부 출력
        // 다음 숫자가 있다면, 다음 숫자보다 큰 게 있는지 탐색
        // 다음 숫자보다 큰 게 하나라도 있다면 그것 한 개를 깔고 다음으로 넘어간다.
        if (count==0) {
            now++
            continue
        }
        if (next==0) {
            extracted(count, now)
            now++
        } else {
            for (i in now+2..max) {
                var nextCount = arr[i];
                if (nextCount > 0) {
//                    println("다다음 숫자 $i 가 있어서 무사히 넘어갔다. ")
                    extracted(count,now)
                    extracted(1,i)
                    // 여기서 1 1 3 생성되고 다음 사이클로.
//                    println("$now 는 ${arr[now]}개로 전락함")
//                    println("$i 는 ${arr[i]}개로 전락함")
                    continue@out
                }
            }
//            println("다음 숫자 못찾은 슬픈 숫자 : $now 는 $count 개 존재함")
            extracted(next, now+1)
        }
    }




    bw.write(sb.toString())


    bw.flush()
    br.close()
    bw.close()
}