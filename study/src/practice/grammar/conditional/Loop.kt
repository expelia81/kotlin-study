package practice.grammar.conditional

fun main(): Unit {
    // ..<
    for (number in 0..<9) println(number)

    // ..

    // .. step
    for (number in 0..<20 step 3) println(number)

    // down to
    for (number in 4 downTo 0 step 2) println(number)
}