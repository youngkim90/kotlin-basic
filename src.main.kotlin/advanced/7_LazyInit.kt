package advanced

class HelloBot {
    // by lazy를 사용하여 초기화를 호출 시점으로 미룸. 불변 상태로 val로 선언해야 함.
    // 지연 로딩은 스레드에 대한 동기화처리도 되어있어 멀티스레드 환경에서 안전함.
    val greeting: String by lazy {
        println("초기화 로직 수행") // 최초 호출 시에만 출력
        getHello()
    }

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {
    val helloBot = HelloBot()

    for (i in 1..5) {
        Thread {
            helloBot.sayHello()
        }.start()
    }
}