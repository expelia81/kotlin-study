package practice.grammar


fun main() {
    val map = mapOf("a" to "A", "b" to "B")
    println(map toTheMoon "BoB")
    println(map toTheMoon("BoB"))
    println(map.toTheMoon("BoB"))
    val person = Person("name",18)
}

infix fun <A,B> A.toTheMoon(that: B): List<String> = listOf(this.toString(), that.toString());


