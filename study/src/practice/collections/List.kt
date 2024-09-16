package practice.collections

import java.util.LinkedList

//fun main() {
//    val finalList = listOf("a","b","c")
//
//    val mutableList = mutableListOf("a","b","c")
//
//    println(finalList)
//    println(mutableList)
//
//    mutableList.add("d")
//
//    println(mutableList)
//
//    // 기본적으로 List는 변경 불가능한 객체이다.
//    // mutableList는 변경 가능하지만, List를 상속한 인터페이스이므로 아래와 같은 행위도 가능하다.
//
//    // mutableList를 얕은 복사 한다.
//    val list: List<String> = mutableList
//
//    //  list는 값의 변경을 지원하지 않기 때문에,
//    //  list.add("e")
//    mutableList.add("e")
////    mutableTest(mutableList)
////    mutableTest(list)
//
//    println("변환 가능한 컬렉션 ${mutableList::class} : $mutableList")
//    println("베껴온 컬렉션 : ${list::class} : $list")
//
//}

fun mutableTest(test : MutableList<String>) {
    test.add("f")
}
//fun main() {
//    val list: List<String> = listOf("a", "b", "c")
//    val mutableList: MutableList<String> = mutableListOf("a", "b", "c")
//    val linkedList = LinkedList<String>()
//    val arrayList = ArrayList<String>()
//    linkedList.add("s")
//    arrayList.add("d")
//    val list2 = linkedList
//
//    println("linkedlist : ${linkedList.hashCode()}")
//    println("list2 : ${list2.hashCode()}")
//    println("list : ${list.hashCode()}")
//    println("mutableList : ${mutableList.hashCode()}")
//    println("arrayList : ${arrayList.hashCode()}")
//}

fun main() {
    val list = listOf("a","b","c")
    // 요소 획득하기
    println(list.get(0))
    println(list[0])
    println(list.first())
    println(list.last())

    val mutableList = mutableListOf("a","b")
    // 요소 수정하기
    mutableList.add("c")
    mutableList.set(1,"B")
    mutableList.remove("a")
    // 요소 체크하기
    println("b is in list ${"a" in mutableList}")
    println("B is in list ${"B" in mutableList}")
    println("size : ${mutableList.count()}")
    println("size : ${mutableList.size}")

}