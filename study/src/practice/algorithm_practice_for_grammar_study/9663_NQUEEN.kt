package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.collections.ArrayList

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt();

//    var t = Math.pow(15.0,15.0).toLong()


    var map = Array<Array<Int>>(n+1, { Array<Int>(n+1, { 0 })})

    var set = ArrayList<Int>()

    for (i in 1 ..n) {
        set.add(i)
    }

    fun log(i: Int) {
        println("--------  $i  -------")
        for( y in 1..n) {
            for(i in 1..n) {
                print("${if (map[y][i]==0) '-' else 'O'} ")
            }
            println()
        }
    }
    fun check(x : Int, y : Int) : Boolean {
        if(!set.contains(x)) {
            return false
        }

        var tempx = x;
        var tempy = y;

        while (tempy!=0 && tempx != 0) {
            if (map[tempy][tempx]!=0) {
//                println("out좌측상단대각선")
                return false
            }
            tempx--
            tempy--
        }

        tempy=y
        tempx=x
        while (tempx<=n && tempy != 0) {
            if (map[tempy][tempx]!=0) {
//                println("out우측상단대각선 : y=$tempy x=$tempx value = ${map[tempy][tempx]}")
                return false
            }
            tempy--
            tempx++
        }
        return true
    }

    var result = 0
    fun find(y : Int) : Unit {
//        log(y)
        if (y>n) {
            result++
            return
        }
        for (i in 1..n) {
            if (set.contains(i)) {
                var boolean = check(i,y);
//                println("$i,$y : $boolean   set : ${set.joinToString(" ")}}")
                if (boolean) {
                    set.remove(i)
                    map[y][i] = 1
                    find(y+1)
                    set.add(i)
                    map[y][i] = 0
                }
            }
        }
    }
    find(1)
    bw.write(result.toString())


    bw.flush()
    br.close()
    bw.close()
}