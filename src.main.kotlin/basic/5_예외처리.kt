package basic

fun main() {
    Thread.sleep(1) // 자바와 달리 Checked Exception을 강제하지 않는다. 컴파일 에러 X

    // 필요시 tryCatch 직접 선언 가능
    try {
        Thread.sleep(1)
    } catch (e: Exception) {
        println("에러 발생")
    } finally {
        println("finally")
    }

    // tryCatch를 표현식으로 사용 가능
    val a = try {
        "123".toInt()
    } catch (e: Exception) {
        println("예외 발생 !")
    }
    println(a)

//    throw Exception("예외 발생 !") // 직접 호출 가능

    val b: String? = null
    val c = b ?: failFast("a is Null") // non-null 타입으로 자동 추론된다.
    println(c.length)
}

// 함수가 정상적으로 끝나지 않는 경우 Nothing 타입을 반환(생략가능)
fun failFast(message: String): Nothing {
    throw IllegalArgumentException(message)
}