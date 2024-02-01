package basic

// 코틀린은 null 안정성을 보장한다.
fun main() {
//    val a : String = null // null 불가능
//    val b: String = "aabbcc"
//    b = null

    var a: String? = null // null 가능
//    a.length // nullable 타입인 경우 컴파일 에러
    println(a?.length) // nullable 타입은 안전연산자(?.)를 통해서만 접근 가능

    val b: Int = if (a != null) a.length else 0
    println(b)

    // 자바스크립트랑 비슷..?
    val c = a?.length ?: 0 // 엘비스 연산자(?:) 사용 시 좌변이 null인 경우 우변 값 반환

//    throw NullPointerException() // 직접 호출은 가능

    val d: String? = null
    val e = d!!.length // 단언연산자(!!.)를 사용하면 null이 아님을 보장한다. (null이면 NPE 발생)
}