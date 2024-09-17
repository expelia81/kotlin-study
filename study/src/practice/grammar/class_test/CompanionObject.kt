package practice.grammar.class_test

fun main() {
    val humanoid = Humanoid("humanoid", 19)
    val human = Human("human", "man", 18)

    println(Human.local)
    println(Humanoid.local)
    Humanoid.local = "moon"
    println(Humanoid.local)

    println(Humanoid.obj.str)
}

class Humanoid(val name:String, val power:Int) {
    companion object {
        var local = "earth"
    }
    object obj{
        var str="this is static"
    }
}

const val constValue = "kkkkkick"

class Human {
    val name:String
    val sex:String
    val age:Int
    constructor(name: String, sex: String, age: Int) {
        this.name = name
        this.sex = sex
        this.age = age
    }

    companion object {
        const val local= "earth"
    }
}