package advanced

// 확장함수는 코틀린 버전이 올라가면 동일한 함수가 추가될 수 있기 때문에 주의해야 함
fun String.first(): Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

class MyExample {
    fun printMessage() = println("Hello")
}

fun MyExample.printMessage(message: String) = println(message)

fun MyExample?.printNullOrNotNull() {
    if (this == null) println("null")
    else println("not null")
}

fun main() {
    println("ABCD".first())
    println("ABCD".addFirst('Z'))

    MyExample().printMessage() // 멤버 함수 출력
    MyExample().printMessage("Goodbye") // 확장 함수 출력

    var myExample: MyExample? = null
    myExample.printNullOrNotNull() // 확장함수 내부에서 null 체크 시, 안전연산자를 사용하지 않아도 컴파일 에러가 발생하지 않음.

    myExample = MyExample()
    myExample.printNullOrNotNull()
}