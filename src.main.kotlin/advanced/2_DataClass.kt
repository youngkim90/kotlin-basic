package advanced

// 데이터를 다루고 전달할 때 주로 사용(DTO)
// class 앞에 data 키워드를 사용
// 데이터 클래스는 내부적으로 equals(), hashCode(), toString(), copy() 등의 메소드를 포함하고 있다.
data class Person(val name: String, val age: Int)

fun main() {
    val person1 = Person(name = "tony", age = 20)
    val person2 = Person(name = "tony", age = 20)
    // data class는 비교 시 equals로 비교하기 때문에 내용이 동일하면 true
    println(person1 == person2)

    // data class는 hashcode를 자동으로 생성하기 때문에 동일한 객체로 인식
    val set = hashSetOf(person1)
    println(set.contains(person2))

    // toString()이 포함되어 있음(생략가능)
    println(person1.toString())

    // 가변 객체를 사용하여 값을 변경하면 프로퍼티 내부 값이 변경되고 추적이 어려워짐. 멀티스레드 환경에서 문제가 발생할 수 있음.
    // 불변 객체 상태로 복사하여 사용하면 안전함
    val person3 = person1.copy(name = "rory") // copy()를 통해 객체 복사 가능
    println(person3)

    println("이름=${person1.component1()}, 나이=${person1.component2()}")

    // 구조 분해 선언 방식
    val (name, age) = person1
    println("이름=$name, 나이=$age")
}