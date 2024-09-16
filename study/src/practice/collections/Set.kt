package practice.collections

fun main(): Unit {
    val set = setOf("a","b","c","d")
    val writeSet = mutableSetOf("a","b","c","a")

    val count = set.count {x:String -> x.length > 0 };
    val count2 = set.count({x:String -> x.length>0})

    println("count : $count")
    println("count2 : $count2")
    println("count3 : ${set.count(){x:String -> x.length>0}}")
    println("count3 : ${set.count { x:String -> x.length>0}}")
}