package chapter3_if_while

fun main(args: Array<String>) {

    // if-else
    val id = 100
    if (id >= 100) {

    } else if (id < 100) {

    } else {

    }

    val id2 = 101
    val b1 = id == id2 //сравнение по значению !=
    val b2 = id === id2 //сравнение по ссылке  !==

    // возврат значения из if
    var res = if (id >= 100) 0 else 1
    println(res)

    // возврат значения из if
    var res0 = id >= 100
    println(res0)

    //работа с интервалами
    var res1 = if (id in 99..101) {
        1
    } else if (id in 99..100) {
        2
    } else {
        3
    }
    println(res1) // 1

    // while   через лямбду
    val idw = 77
    var isWhem = when(idw){
        1 -> 101
        2,3,4 -> 201
        in 6..10 -> 301
        in 11..15 -> {
          if (res1 > 0) 1
          else 0
        }
        else -> 501
    }

}