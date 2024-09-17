package practice.grammar

import practice.collections.to

fun main(): Unit {
    val lambda = {s : String, back : String -> s add back}
    println(lambda("a","b"))
    println(lambda)
}

infix fun String.add(a: String) : String = this + a
