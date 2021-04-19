package chapter4_fun
import chapter4_fun.pac1.fun5  // public
import chapter4_fun.pac1.fun6  // internal

fun main(args: Array<String>) {

    val res1 = fun1("1", 1)
    val res2 = fun2("2", 2)

    val res3 = fun3("3", 3)
    println(res3) // kotlin.Unit

    val res4 = fun4("4", 4)
    println(res4) // kotlin.Unit
    println(res4 == Unit) //true
    println(res4 === Unit) //true

    fun5()  // использованны значения по умолчанию    // public
    fun5(a1 = "888", a2 = 999)  // использованны именованные значяения  // internal

    //fun6("1"); //Exception in thread "main" kotlin.NotImplementedError: An operation is
    // not implemented: сделать все на света до конйа кварталаи не забыть про этот метод

    `Бредовое название функции *~!#@$%^&*()}{{}'`("10", 10);

}

private fun fun1(a1: String, a2: Int): String = "fun1"

private fun fun2(a1: String, a2: Int): String {
    return "fun1"
}

private fun fun3(a1: String, a2: Int) {
    println("fun3")
}

private fun fun4(a1: String, a2: Int): Unit {
    println("fun4")
}

public fun `Бредовое название функции *~!#@$%^&*()}{{}'`(a1: String, a2: Int): Unit {
    println("Бредовое название функции *~!#@\$%^&*()}{{}'")
}


