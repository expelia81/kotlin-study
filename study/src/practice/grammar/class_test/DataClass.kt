package practice.grammar.class_test

data class DataClass(val a : String, val b :String)


fun main() {
    val x = DataClass(a = "테스트", b="테스트2")
    val y = x.copy()

    println("${x===y}")
    println("${x==y}")
    println("${x.hashCode()} : ${y.hashCode()}")
    println("${x.component1()} : ${x.component2()}")
}

