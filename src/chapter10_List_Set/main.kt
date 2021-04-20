package chapter10_List_Set

import java.io.File
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

fun main(args: Array<String>) {

    // неизменяемые списки
    var l = listOf<Int>(1,2,3,4,5)
    var l1 = listOf(1,2,3,4,5)
    var l2:List<Int> = listOf(1,2,3,4,5)

    // изменяемые списки
    var ul = mutableListOf<Int>(1,2,3,4,5)
    var ul2 = l2.toMutableList()    // преобразование типа

    println(l.equals(l1))   //true
    println(l1.equals(l2))  //true
    println(l2.equals(l))   //true

    fun1(l)

    l.getOrElse(4,{ "тут любое значение по умолчанию или дямбда"})
    l.getOrNull(4) // вернет null если не такого индекса

    println(l.getOrElse(11, {100500})) // 100500
    println(l.getOrNull(11)) //null

    println(l.contains(3)) // true
    println(l.containsAll(listOf(3,5,1))) // true


    ul.remove(5) // удалит элемент
    ul.removeAt(0)//  удалит по индексу
    println(ul)//[2, 3, 4]

    ul.add(0,111)
    ul.add(555)
    println(ul)//[[111, 2, 3, 4, 555]


    // пройти по всем
    //1
    for (el in ul2)
        print(el)
    //2
    for(i in 0..ul2.size-1)
        print(ul2[i])
    //3
    ul2.forEach{ el -> print(el)}

    //4
    ul2.forEachIndexed(){ index, el -> print("[$index,$el]")}

    println()

    //чтения файла
  /*  val menuList = File("data/tavern-menu-items.txt")
        .readText()
        .split("\n")
    menuList.forEachIndexed { index, data ->
        println("$index : $data")
    }*/

    // Sets
    val s = setOf(1,2,3,4,5,1)
    val s1 = mutableSetOf(1,2,3,4,5,1,2,3,4,5,6)
    println("set 1 = "+s)  //[1, 2, 3, 4, 5]
    println("set 2 = $s1") //[1, 2, 3, 4, 5, 6]

    //очень медленная ситуация
    s1.elementAt(2)  // - та не делать

    // самый юыстрый вариант для обращения по индексу через множество
    var ls1 = s1.toList();
    ls1.getOrNull(2)

}

fun fun1 (l:List<Int>):Int = l.size



