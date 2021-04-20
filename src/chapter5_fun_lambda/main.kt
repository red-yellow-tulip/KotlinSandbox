package chapter5_fun_lambda

fun main(args: Array<String>) {

    var numLetters = "Mississippi".count({ let -> let == 's' }) // аннонимная функция { let -> let == 's' }
    var numLetters1 = "Mississippi".count({  it == 's' }) // аннонимная функция {  it == 's' }
    println(numLetters) //4

    // без параметров без тела
    var newType: () -> String

    // без параметров с телом
    var newType2: () -> String = {
        //......
        ""  // это будет возвращаемое значение
    }
    // с 1 параметром с телом
    var newType3: (String) -> String = { param ->
        val res = param
        //......
        res  // это будет возвращаемое значение
    }
    // с 1 параметром с телом  - it можно использовать вместо параметра если в функции 1 параметр
    var newType31: (String) -> String = {//it  - если 1 параметр, можно не обьявлять
        var r: String = it
        //......
        "res = $it"  // это будет возвращаемое значение
    }

    // передачу функции в качестве параметра
    funMulty("99",newFun4);


    // вызов функции возвращающей функцию
    var fun6 =  newFun5() // функция создается 1 раз, и инициализируется 1 раз    var counter = 5 инициализируется и живет
    println(fun6("fun6")) //6 FUN6
    println(fun6("fun6")) //7 FUN6
    println(fun6("fun6")) //8 FUN6
}

// функцмя принимает функцию в качестве параметра
fun funMulty ( a1:String, newType4: (String, Int) -> String) {

    println (newType4 (a1,a1.toInt()))
}

// inline функции - как было в С++
inline fun funMulty2 ( a1:String, newType4: (String, Int) -> String) {  // пример встраиваемой функкии

    println (newType4 (a1,a1.toInt()))
}
// функция с 2я параметрами
var  newFun4: (String, Int) -> String =  // это описание функции
{
    s, i -> // это описание левой части лямбда
    s + " <> $i"   // правая часть = код + результат
}

// функция которая возвращает в качестве результата другую функцию - фабрика функций
fun newFun5(): (String) -> String
{
    var counter = 5
    return {  counter+= 1
              "${counter} " + it.toUpperCase()    }  // обьявление тела возвращаемой функции
}

