package practice.algorithm_practice_for_grammar_study

fun main() {

    var tens = IntArray(11+1){i -> Math.pow(10.0,i.toDouble()).toInt()}
    println(2531%tens[2]/tens[1])
    println(2531%tens[3]/tens[2])
}