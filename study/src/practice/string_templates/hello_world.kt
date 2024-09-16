package practice.string_templates

fun main() {
    val name = "Mary";
    val age = 20;
    println("${name} is ${age} years old.")

    println("$name is $age+1 years old.")
    println("$name is ${age+1} years old.")
}