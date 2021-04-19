package chapter2_types

const val PI:Double = 3.14   // константа времени компиляции

fun main (args: Array<String>){

    // var - изеняемая переменная
    // val - констанстная переменная   - аналог final

    var s1: String = "s1"
    var s11 = "s1"
    val s2: String = "s2"

    // вывод типов по значению
    var s3 = "s3"
    val s4 = "s4"
    val i1 = 1
    val d1 = 1.0  //double

    // типы
    var s: String = "s"
    var c: Char = 'c'
    var b: Boolean = true
    var i: Int = Integer.MAX_VALUE
    var d: Double = 123456789.123456789
    var sh:Short = 1234
    var bt: Byte = 6;

    val intNumber: Int = 20       // this is inferred as int
    val longNumber: Long = 20L     // this is inferred as long
    val floatNumber: Float = 20F    // this is inferred as float, 20.0
    val doubleNumber: Double = 20.0   // this is inferred as double, 20.0

    var l: List<Int>  = listOf(1,2,3,4,5,6,7,8,9)
    var set: Set<Int> = setOf(1, 3, 9)
    val intMutableSet: MutableSet<Int> = mutableSetOf(3, 27, 66, 12, 10)
    val intsHashSet: java.util.HashSet<Int> = hashSetOf(1, 2, 3, 4)
    val intSortedSet  = sortedSetOf(9, 1, 8, 3)
    val intLinkedHashSet = linkedSetOf(15, 6, 7, 2, 3)

    var sReg: String = "подстановка значения другой переменной -> $floatNumber"  // почти как в javascript
    println(sReg)
    var sReg2: String = "вычисляемые значения с подстановкой-> (значение: ${if (doubleNumber == 20.0) "Yes" else "No"}))"  // (значение: Yes)
    println(sReg2)




}