package advanced

class LateInit {
    // lateinit은 가변변수로 선언해야하기 때문에 var로 선언해야 하고, non-null 타입으로 선언해야 함.
    lateinit var text: String

    fun printText() {
        // 지연변수는 초기화가 필요함. 초기화 없이 호출 시 에러 발생.
        if(this::text.isInitialized) println("초기화 완료")
        else text = "안녕하세요"
        println(text)
    }

    val textInitialized: Boolean
        get() = this::text.isInitialized
}

fun main() {
    val test = LateInit()
    test.text = "Hello"
//    test.text.isInitialized // 외부에서는 초기화 여부 확인 불가
    test.printText()

    if(!test.textInitialized) test.text = "Hi"
    test.printText()
}