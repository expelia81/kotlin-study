package practice.grammar

fun main() {
    val list = listOf("a","b","c")
    val mutableList = mutableListOf("a","b","c")
    val listCopy:List<String> = mutableList;

    println("내용만 같은 객체 ==  :  ${list==mutableList}")
    println("내용만 같은 객체 equals : ${list.equals(mutableList)}")
    println("내용만 같은 객체 ===  :  ${list===mutableList}")

    println("실제로 같은 객체 ==  :  ${listCopy==mutableList}")
    println("실제로 같은 객체 equals : ${listCopy.equals(mutableList)}")
    println("실제로 같은 객체 ===  :  ${listCopy===mutableList}")
}