package chapter7_String

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

fun main(args: Array<String>) {


    var str = "aw gp;ASW VGFJ N\tWP VO NFBV FEBNA E;VB"

    var str0 = str.substring(0,str.length/2)
    var str1 = str.substring(0  until str.length/2) // IntRange
    println(str0) // aw gp;ASW VGFJ N	WP
    println(str1) // aw gp;ASW VGFJ N	WP

    var index = str.indexOf(';')
    println(index) // 4

    var str2 = str.split(' ') // List<String>
    println(str2) // [aw, gp;ASW, VGFJ, N	WP, VO, NFBV, FEBNA, E;VB]

    var str3 = str.replace("ASW","TTT").toUpperCase().plus("###")
    println(str3) //AW GP;TTT VGFJ N	WP VO NFBV FEBNA E;VB###

    var str4 = str.replace(Regex(".")) {
        when (it.value) {
            "V" -> "4"
            "S" -> "3"
            "W" -> "1"
            "N" -> "0"
            "F" -> "|_|"
            else -> it.value
        }
    }
    println(str4) //aw gp;A31 4G|_|J 0	1P 4O 0|_|B4 |_|EB0A E;4B

    // equals
    println(str.equals(str));   //true
    println(str == str);        //true
    println(str === str);       //true

    println(str.equals(str3));  //false
    println(str.equals(str4));  //false

    // обход символов в строке
    str.forEach { print ("'$it' ") }








}

