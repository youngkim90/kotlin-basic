package basic

fun main() {
    val day = 2

    val result = when (day) {
        1 -> "월"
        2 -> "화"
        3 -> "수"
        4 -> "목"
        else -> "기타"
    }
    println(result)

    // else 생략 가능
    when (getColor()) {
        Color.RED -> print("빨강")
        Color.ORANGE -> println("주황")
        Color.YELLOW -> println("노랑")
        Color.GREEN -> println("초록")
    }

    // 여러 조컨을 콤마로 구분해 정의 가능
    when (getNumber()) {
        0, 1 -> println("0 또는 1")
        else -> println("기타")
    }
}

fun getNumber() = 1

enum class Color {
    RED, ORANGE, YELLOW, GREEN
}

fun getColor() = Color.RED