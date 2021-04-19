package chapter4_fun_lambda

fun main(args: Array<String>) {

    var numLetters = "Mississippi".count({ let -> let == 's' }) // аннонимная функция { let -> let == 's' }
    var numLetters1 = "Mississippi".count({  it == 's' }) // аннонимная функция {  it == 's' }
    println(numLetters) //4

    var newType: () -> String
    var newType2: () -> String = {
        //......
        ""  // это будет возвращаемое значение
    }

    var newType3: (String) -> String = { param ->
        val res = param
        //......
        res  // это будет возвращаемое значение
    }

    var newType31: (String) -> String = {//it  - если 1 параметр, можно не обьявлять
        var r: String = it
        //......
        "res = $it"  // это будет возвращаемое значение
    }


    println(({ var c = 1; c++ })()) // 1
    println(({ var d = 5; d++ })())  // 5
    println(({ var d = 5 })())  // Unit


    // передачу функции в качестве параметра
    funMulty("99",newType4);

}

fun funMulty ( a1:String, newType4: (String, Int) -> String) {

    println (newType4 (a1,a1.toInt()))
}

inline fun funMulty2 ( a1:String, newType4: (String, Int) -> String) {  // пример встраиваемой функкии

    println (newType4 (a1,a1.toInt()))
}

var newType4: (String, Int) -> String =  // это описание функции
    { s,i ->        // это описание левой части лямбда
        s + " <> $i"   // правая часть = код + результат
    }
