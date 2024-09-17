package practice.grammar

fun main() {
    fun Person.isAdult(): Boolean {
        return age >= 18
    }
    val person = Person("name",18)
    println(person.isAdult())
}

class Person {
    val name:String
    val age: Int
    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}

fun <T> Collection<T>.joinToStringWithDelimiter(delimiter: String): String {

    var result = StringBuilder()
    for((index, element) in this.withIndex()) {
        if(index > 0) {
            result.append(delimiter)
        }
        result.append(element)
    }
    return result.toString()
}