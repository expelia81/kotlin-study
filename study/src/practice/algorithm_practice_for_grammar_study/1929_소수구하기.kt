package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashSet
import kotlin.math.sqrt

fun main() {

    var stack = Stack<String>()

    stack.push("조직")
//    stack.push("경영")
//    stack.push("마케팅")

    var str : String = stack.stream()
        .reduce{a,b -> a+"/"+b}
        .orElse("")

    println(str)
}