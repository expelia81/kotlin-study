package practice.collections

fun main() {
    val map = mapOf("a" to "A", "b" to "B")
    println(map.toTheMoon("BoB"))
    ArrayList<Int>().toTheMoon("hi")

    var a : Int

}


public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that);

infix fun <A,B> A.toTheMoon(that: B): List<String> = listOf(this.toString(), that.toString());