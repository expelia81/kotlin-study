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

    var n = br.readLine().toInt()

    var list = ArrayList<ArrayList<Int>>()
    var dp = ArrayList<ArrayList<Long>>()

    for (i in 1..n) {
        var tempList = ArrayList<Int>()
        var tempdp = ArrayList<Long>()
        var st = StringTokenizer(br.readLine()," ")
        for(j in 1..n) {
            tempList.add(st.nextToken().toInt())
            tempdp.add(-1)
        }
        list.add(tempList)
        dp.add(tempdp)
    }
    dp[0][0]=1

    fun dpp(y : Int, x:Int) : Long {
        if (dp[y][x] != -1L) {
            return dp[y][x]
        } else {
            var temp : Long = 0
            for (i in 0..y-1) {
                if (list[i][x]==(y-i)) {
                    temp+=dpp(i,x)
                }
            }
            for (i in 0..x-1) {
                if (list[y][i]==(x-i)) {
                    temp+=dpp(y,i)
                }
            }
            dp[y][x]=temp
            return temp
        }
    }

    println(dpp(n-1,n-1))




    bw.flush()
    br.close()
    bw.close()
}