package chapter9_standart_func

import java.io.File
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

fun main(args: Array<String>) {

    /*функция apply. apply можно считать функцией на-
    стройки: она позволяет вызвать несколько функций для объекта-получателя
    и настроить его для дальнейшего использования.*/

    val menuFile = File("menu-file.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }

    /*стандартная функция  let, определяет переменную в область видимости за-
    данной лямбды и позволяет использовать ключевое слово it,*/
    val firstItemSquared = listOf(1,2,3).first().let {
        it * it
        "Welcome, $it. Please"

    }

    /* Функция run похожа на
    apply, точно так же ограничивая относительную область видимости, но не воз-
    вращает объект-приемник.*/
    val menuFile2 = File("menu-file.txt")
    val servesDragonsBreath = menuFile.run {
        readText().contains("Dragon's Breath")
    }

    fun nameIsLong(name: String) = name.length >= 20
    "Polarcubis, Supreme Master of NyetHack".run(::nameIsLong) // Истина


    /*  with — это разновидность run. Она ведет себя похожим образом, но использует
    другие соглашения вызова. В отличие от стандартных функций, рассмотрен-
    ных ранее, with требует, чтобы объект-приемник передавался ей в первом
    аргументе, а не как субъект вызова, как это принято в других стандартных
    функциях:*/

    val nameTooLong = with("Polarcubis, Supreme Master of NyetHack") {
        length >= 20
    }

    /*Функция also похожа на функцию let. Как и let, also передает объект-при-
    емник как аргумент в лямбду. Но есть одно большое различие между let и also:
    вторая возвращает объект-приемник, а не результат лямбды.*/
    var fileContents: List<String>
    File("file.txt")
        .also {
            print(it.name)
        }.also {
            fileContents = it.readLines()
        }

    /*takeIf — возвращает значение, если условие истинно;
    takeUnless — возвращает значение, если условие не истинно.*/

    /*это takeIf. takeIf работает немного иначе,
    чем другие стандартные функции: она вычисляет условие, или предикат, за-
    данное в лямбде, которое возвращает истинное или ложное значение. Если
    условие истинно, takeIf вернет объект-приемник. Если условие ложно, она вернет null*/

    val fileContents2 = File("myfile.txt")
        .takeIf { it.canRead() && it.canWrite() }
        ?.readText()

    /*  Функция takeUnless действует так же, как takeIf,
    но возвращает объект-приемник, если условие ложно. Следующий код читает
    файл, если он не скрытый (и возвращает null, если скрытый):*/
    val fileContents3 = File("myfile.txt").takeUnless { it.isHidden }?.readText()




}



