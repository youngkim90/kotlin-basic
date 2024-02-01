package basic

fun main() {
    val age: Int = 10

    // 코틀린의 if문은 표현식이다.
    var str = if (age > 20) {
        "성인"
    } else if (age > 10) {
        "어린이"
    } else {
        "아기"
    }

    println(str)

    val a = 1
    val b = 2
    // if문이 표현식이므로 삼항 연산자가 불필요
    val c = if (b > a) b else a
}
