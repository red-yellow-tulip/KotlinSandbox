package chapter12_class
/*
      public (по умол-чанию)
      Функция или свойство будут доступны вне класса. По умолчанию
      функции и свойства без модификатора видимости получают моди-
      фикатор public

      private Функция или свойство будут доступны только внутри класса

      protected Функция или свойство будут доступны только внутри класса или
      подкласса

      internal Функция или свойство будут доступны внутри модуля
  */

fun main(args: Array<String>) {

    var a = A(100);
    a.name = "Ivan1"
    a.age = -5
    println(a)

    var a1 = A("Ivan");
    println(a1)

    var b = B(60,"class B")
    b.type = 99
    println(b)
    println(b.description())

    println(a is Any) //true
    println(b is A) //true
    println(a is A) //true
    println(b is Any) //true


    // расширения класса
    println(b.isClear()) //false

    // data классы  - есть методы из коробки
    var p:Person = Person("","")
    p.name = "1"
    p.surname = "2"
    println(p)

    var p1 = p.copy()
    println(p1)
    //деструктуризация data классов
    var (name, surname) = p1
    println(name)
    println(surname)


}

// простой класс
open class A ( _type:Int): Z() {

    override val image: String = ""
        get() = field

    override fun setImage(im: String) {

    }

    var type:Int = _type

    var name: String = "" //свойство класса
        get() = field.toLowerCase()   //явное задание get and set
        set(value) {
            field = value.trim()
        }
    var age: Int = 0;

    init{ // блок инициализации
        require(age >= 0, {" warring age < 0"});
    }

    constructor(name: String = "defaultname", age:Int = 0) : this(0) { //вторичный конструкток
        this.name = name
        this.age = age
    }
    override fun toString(): String {
        return "A(name=$name type=$type, age=$age)"
    }

    open fun description () = "description.A"
}


class B(_type: Int, _name: String) : A(_name, _type) {

    private var counter:Long = 0;

    override fun toString(): String {

        return "B(name=$name type=$type, age=$age)"
    }

    override fun description() = super.description()+"-> description.B"
}

// расширения класса
fun A.isClear():Boolean{
    return type == 0 && name.equals("") && age == 0
}


abstract class Z {
     abstract fun setImage(im:String)
     abstract val image: String
}

// очень похоже на обычнаый POJO сласс, аналог record  в java
data class Person(var name: String, var surname: String){
    fun isClean():Boolean = "".equals(name) && "".equals(surname)
}




