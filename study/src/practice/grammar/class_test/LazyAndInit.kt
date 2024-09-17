package practice.grammar.class_test

fun main(){
    IfTestObject.b
}
object IfTestObject {
    val a : Int by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        println("lazy 할당됨")
        32
    }
    var b : Int = 0
        private set(value) {
            println("set b 호출됨")
            field = value
        }
        get() {
            println("get b 호출됨")
            return field
        }
}