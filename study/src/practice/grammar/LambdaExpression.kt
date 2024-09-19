package practice.grammar

import practice.collections.to

fun main(): Unit {
    val lambda = {s : String, back : String -> s add back}
    println(lambda("a","b"))
    println(lambda)




    val positives = listOf(1, -2, 3, -4, 5, -6).filter ({ x -> x > 0 })
}

infix fun String.add(a: String) : String = this + a
