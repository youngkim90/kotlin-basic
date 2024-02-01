package basic

// 코틀린에서 기본 클래스는 final이고, 상속이 불가능하다.
// 상속 가능한 클래스로 선언하려면 open 키워드를 붙여야 한다.
open class Dog {
    open var age: Int = 0

    open fun bark() {
        println("멍멍")
    }
}

// 상속을 받으려면 클래스 뒤에 : 부모클래스()를 붙여야 한다.
// 생성자 내부 파라미터에 오버라이드 할 변수 선언이 가능하다.
open class Bulldog(override var age: Int = 0) : Dog() {
    //    override var age: Int = 0
    // final 키워드 사용 시 하위 클래스에서 오버라이드 불가능
    final override fun bark() {
        super.bark()
        println("컹컹")
    }
}

abstract class Developer {
    abstract var age: Int
    abstract fun code(language: String)
}

class BackendDeveloper(override var age: Int) : Developer() {
    // 추상클래스의 abstract 변수는 모두 할당 받아야함.
    override fun code(language: String) {
        println("BackendDeveloper code is $language")
    }
}

fun main() {
    val dog = Bulldog(age = 5)
    println(dog.age)
    dog.bark()

    val backendDeveloper = BackendDeveloper(age = 10)
    println(backendDeveloper.age)
    backendDeveloper.code("Kotlin")
}