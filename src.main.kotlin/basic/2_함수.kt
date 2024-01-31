package basic

// 기본 함수 선언
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 표현식 스타일
fun sum2(a: Int, b: Int): Int = a + b

// 표현식 & 반환타입 생략
fun sum3(a: Int, b: Int) = a + b

// 반환값이 있는 경우 반환 타입이 없으면 컴파일 에러
fun sum4(a: Int, b: Int) {
//    return a + b;
}

// 반환타입이 없는 함수는 Unit을 반환(생략가능)
fun printSum(a: Int, b: Int): Unit {
    println("$a + $b = ${a + b}")
}

// 파라미터 디폴트 설정
// 자바에는 없는 기능.. 타입스크립트 + 자바 느낌이 강하네..!
fun greeting(message: String = "Hello") {
    println(message)
}

fun log(level: String = "INFO", message: String) {
    println("[$level] $message")
}

fun main() {
    greeting() // 디폴트 파라미터인 경우, 값을 안넣어도 됨.
    greeting("Hi")

    log(message = "Hello") // 호출부에 파라미터 이름 명시 가능(네임드 아규먼트 기법)
    log(level = "WARN", "WARN 로그") // 네임드 파라미터를 사용해도 되고 안해도 됨
    log(level = "WARN", message = "WARN 로그")
    log("DEBUG", "DEBUG 로그")
}