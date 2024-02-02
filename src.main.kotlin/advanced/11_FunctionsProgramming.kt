package advanced

fun main() {

    val list = mutableListOf(printHello)
//    list[0] // 함수는 인덱스로 접근 불가
    list[0]() // 함수를 호출하려면 ()를 붙여야 함

    val func: () -> Unit = list[0]
    func()

    call(printHello)
//    call(printNo) // 컴파일 에러

    val result: Int = plus(10, 20, 30)
    println(result)

    val list2 = listOf("A", "B", "C")
    val printStr: (String) -> Unit = { println(it) }
    forEachStr(list2, printStr)

    val upperCase: (String) -> String = { it.uppercase() }
    println(list2.map(upperCase))

    // 내부 익명함수를 호출하려면 ()를 추가로 붙여야함
//    outerFunc()()
    val func2 = outerFunc()
    func2()

    // 람다식이 마지막 인자로 전달되는 경우 괄호 밖에 작성 가능(후행람다)
    forEachStr(list2) { println(it) } // 인자가 2개 이상인 경우 it을 사용할 수 없음

    // 람다 레퍼런스 구문
    val callReference = ::printHello
    callReference()()

    val numberList = listOf("1", "2", "3")
//    numberList.map { it.toInt() }.forEach { println(it) }
    numberList.map(String::toInt).forEach(::println)
}

// 람다 표현식의 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

// 최대한 생략한 람다 식
val sum2 = { x: Int, y: Int -> x + y }

fun outerFunc(): () -> Unit = { println("익명함수!") }

// 함수를 인자로 받아서 실행하는 함수 -> 고차함수
fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}

val printMessage: (String) -> Unit = { message -> println(message) }
val printMessage2: (String) -> Unit = { println(it) } // 인자를 it으로 대체 가능

val plus: (Int, Int, Int) -> Int = { a, b, c -> a + b + c }

val printHello: () -> Unit = { println("Hello") }

// 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block()
}

// fun으로 선언한 함수는 함수를 인자로 넘기거나 반환하는 1급 객체 특성이 없다.
fun printNo() = println("No")