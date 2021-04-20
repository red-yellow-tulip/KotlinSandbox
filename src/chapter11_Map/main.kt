package chapter11_Map

fun main(args: Array<String>) {


    val map = mapOf("A" to 10.5, "B" to 8.0, "C" to 5.5)
    val map1 = mutableMapOf("A" to 10.5, "B" to 8.0, "C" to 5.5)
    var map2 = mutableMapOf(Pair("A",10.5), Pair("B",8.0),Pair( "C",5.5))

    println(map.equals(map1)) // true
    println(map == map1)      // true
    println(map == map2)      // true
    println(map === map1)     // false

    println(map)
    println(map["A"])

    map.keys.toList().forEach{ key -> print("$key:${map.getValue(key)} ")}

    val el = map2.put ("D",9.9);
    println(el) //null - добавдяет обьект
    val e2 = map2.put ("D",9.7);
    println(e2) //9.9  - возвращает замененную-старую версию обьекта
    println(map2.getValue("D")) //9.7




}




