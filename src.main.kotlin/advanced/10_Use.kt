package advanced

import java.io.FileWriter

fun getStr(): Nothing = throw Exception("예외 발생 기본 값으로 초기화")
fun main() {
    FileWriter("test.txt")
            .use {
                it.write("Hello, World!")
            }

    val result = try {
        getStr()
    } catch (e: Exception) {
        println(e.message)
        "기본 값"
    }

    println(result)

    val result2: Throwable? = runCatching { getStr() }
            .getOrNull() // 예외 발생 시 null 반환
//            .getOrElse { // 예외 발생 시 함수의 결과를 반환
//                println(it.message)
//                "기본 값2"
//            }
//            .getOrDefault("기본 값3") // 예외 발생 시 정해진 값 반환
//            .getOrThrow() // 바로 예외를 발생
//            .exceptionOrNull() // 예외를 반환

//    result2?.let {
//        println(it)
//        throw it
//    }
    println(result2)

    // mapCatching은 예외가 발생하면 예외를 반환하거나 다음 함수를 호출
    val result3 = runCatching { "안녕" }
//            .map { "${it}하세요" }
//            .map { throw Exception("예외 발생") } // map 안에서 Exception이 발생하면 getOrDefault 호출 없이 예외 발생
            .mapCatching { throw Exception("예외 발생") } // mapCatching 안에서 Exception이 발생하면 getOrDefault 호출
            .getOrDefault("기본 값")

    println(result3)

    // recover는 예외가 발생했을 때 대체할 값을 지정
    val result4 = runCatching { getStr() }
//            .recover { "복구" } // recover 안에서 Exception이 발생하면 getOrDefault 호출 없이 예외 발생
            .recoverCatching { throw Exception("예외") }
            .getOrNull()
    println(result4)
}
