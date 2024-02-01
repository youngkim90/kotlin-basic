package basic

fun main() {
    // 범위연산자 .. 을 반복문에 사용 가능
    for (i in 0..3) {
        println(i)
    }

    // until 사용시 뒤 숫자보다 작은 숫자까지만
    for (i in 0 until 3) {
        println(i)
    }

    // step 사용시 증가or감소 폭 설정 가능
    for (i in 0..10 step 2) {
        println(i)
    }

    // downTo 사용시 최소값 설정 가능
    for (i in 5 downTo 3 step 2) {
        println(i)
    }

    // 배열 생성 및 반복
    val number = arrayOf(1, 2, 3)
    for (i in number) {
        println(number[i])
    }
}