package practice.grammar.conditional

import kotlin.random.Random

fun main(): Unit {
    val first = Random.nextInt(6)
    val second = Random.nextInt(6)

    if (first>second) {
        println("i win")
    }
}