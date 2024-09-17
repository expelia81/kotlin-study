package practice.grammar.conditional

fun main(): Unit {
    val a = 30

    when(ConditionalTest.add(a)) {
        20 -> {
            println("20!!!")
        }
        30 -> {
            println("30!!!")
        }
        else -> {
            println("break!!!")
        }
    }
}

object ConditionalTest {
    val a = 3
    val b = 4
    fun add(c:Int) : Int {
        return a+b+c
    }
}