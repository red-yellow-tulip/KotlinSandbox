package chapter6_Null

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

fun main(args: Array<String>) {

    val a = fun1("a1",null)
    println(a) //null

    //println(a.length); // так не пропустит компилятор
    //?. - оператор безопасного вызова
    println(a?.length);

    //1
    //.let - безопасный вызов, блок  { } выполнится если значение a? - не null
    println("let? - "+ a?.let {
        "Yes"
    }); //?. - оператор безопасного вызова

    //2
    //!!. - «Если я хочу провести операцию с несуществующим значением, то ТРЕБУЮ,
    //чтобы ты вызвал NullPointerException!»
    var b = "123456"
    //println("!!. - "+ a!!.length); //!!. - оператор безопасного вызова   - Exception in thread "main" kotlin.KotlinNullPointerException
    println("!!. - "+ b!!.length); //  !!. - 6

    //3
    // проверка в лоб
    if ( a != null)
        println(a.length);  //

    //4
    // ?:   - есил a не равно null присваиваем а, иначе то что после ?:
    val c = a?: "C"
    println(c);  //C

    val a2 = fun2(null,null)
    println(a2) //fun2

    // все исключения не проверяемые - все отдается на совесть разработчика
    // генерация исключений и перехват
    try{
        val a4 = fun4("a3",null) //Exception in thread "main" chapter6_Null.MyExeption: MyExeption
        println(a4) //null
    }catch (e: IllegalStateException){
        println(e)
    }
    // компилятор пропустити - ошибка на стадии выполнения
    val a3 = fun4("a3",null) //Exception in thread "main" chapter6_Null.MyExeption: MyExeption

  /*
    checkNotNull Возбуждает IllegalStateException, если аргумент null. В противном
    случае возвращает полученное значение

    require Возбуждает IllegalArgumentException, если условие не выполняется
    requireNotNull Возбуждает IllegalArgumentException, если аргумент null. В против-
    ном случае возвращает полученное значение

    error Возбуждает IllegalArgumentException с указанным сообщением, если
    аргумент null. В противном случае возвращает полученное значение

    assert Возбуждает AssertionError, если условие не выполняется и на этапе
    компиляции установлен флаг, разрешающий проверку утверждений
    во время выполнения а
    */

}

// функцмя с параметрами a2  - может быть null, возвращаемое значение может быть null
fun fun1 (a1:String, a2:String?): String? {
    return  null
}

// функцмя с параметрами a2  - может быть null, возвращаемое значение может быть null
fun fun2 (a1:String?, a2:String?): String {
    return  "fun2"
}

// герерация исключения
fun fun3 (a1:String?, a2:String?): String {
    return  a2 ?: throw IllegalArgumentException ("a2 - is null")
}

// герерация исключения - свое исключение
fun fun4 (a1:String?, a2:String?): String {
    return  a2 ?: throw MyExeption ("a2 - is null")
}

class MyExeption (s: String): IllegalStateException ("MyExeption")


