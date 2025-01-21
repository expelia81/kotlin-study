package practice.algorithm_practice_for_grammar_study

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var admin = "/v1/maestro/admin"
    var user = "/v1/maestro/user"

    br.lines().forEach {
        // 두 번째 / 이후부터 시작되는 것만 경로로 입력받는다.
        var server = it.substring(0, it.indexOf("/"))
        var method = it.substring(it.indexOf("/")+1, it.indexOf("/", it.indexOf("/")+1))
        var path = it.substring(it.indexOf("/", it.indexOf("/")+1))
        var createdPath = path
        if (server == "admin-common") {
            createdPath = admin + path
        } else if (server == "user-common") {
            createdPath = user + path
        }
        println("('$server', '$method', '$path', '$createdPath'),")
    }



    bw.flush()
    br.close()
    bw.close()
}