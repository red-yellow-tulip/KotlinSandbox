package chapter16_interface

fun main(args: Array<String>) {

    var a = A()
    println(a.param3)//10

    println(a.fun1())//18   значения от интерфейсов

    println(a.fun11()) //MyInterfaceMyInterface.fun11
    println(a.fun12()) //MyInterfaceSecondMyInterfaceSecond.fun12
    println(a.fun13()) //MyAbstractClassMyAbstractClass.fun14

    // расширения функции
    println(a.isClear()) //false

    //расширение свойства
    println(a.param4) //1000
}



interface MyInterface {
    var param1: Int
    val param2: Int

    var param3: Int   // field  нельзя использовать в интерфейсах
        get() = 7
        set(value) {param3 = value}

    fun fun1():String
    fun fun11():String = "MyInterface.fun11"
}

interface MyInterfaceSecond {
    var param1: Int
    val param2: Int

    var param3: Int   // field  нельзя использовать в интерфейсах
        get() = 6
        set(value) {param3 = value}

    fun fun1():String
    fun fun12():String = "MyInterfaceSecond.fun12"
}


abstract class MyAbstractClass {

    var param1: Int = 0
    val param2: Int = 0

    open var param3: Int = 0   // field   можно применять в abstract  !!!open
        get() = 5
        set(value) {field = value}

    abstract fun fun1():String
    abstract fun fun13():String
    fun fun14():String = "MyAbstractClass.fun14"
}


// простой класс
public class A : MyInterface,MyInterfaceSecond, MyAbstractClass() { //internal - в рамках пакетв

    override var param3: Int = 10

    override fun fun11(): String {//MyInterface
        return "MyInterface"+super<MyInterface>.fun11()
    }

    override fun fun12(): String {//MyInterfaceSecond
        return "MyInterfaceSecond"+ super<MyInterfaceSecond>.fun12()
    }

    override fun fun13(): String {//MyAbstractClass
        return "MyAbstractClass"+super<MyAbstractClass>.fun14()
    }

    override fun fun1(): String {// пример обращения к методам предка

        return "${super<MyInterface>.param3 + super<MyInterfaceSecond>.param3+super<MyAbstractClass>.param3}"
    }

}

// расширения класса
fun A.isClear():Boolean{
    return param3 == 0 && param2 == 0 && param1 == 0
}

val A.param4: Int
    get() = 5








