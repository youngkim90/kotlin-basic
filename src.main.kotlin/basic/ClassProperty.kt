package basic

// 코틀린은 클래스에 생성자(생략가능) 함께 선언 가능하다.
class Coffee(
        var name: String = "",
        var price: Int = 0,
        var iced: Boolean = false, // 후행콤마 사용 가능
        ) {
    val brand: String
        get() = "이디야" // 커스텀 getter 선언

    var quantity : Int = 0
        set(value) {
            if (value > 0) {
                field = value // getter, setter에서 field는 해당 프로퍼티를 가리킨다.
//                quantity = value // setter로 프로퍼티에 직접 접근 시 무한루프 발생
            }
        }
}

class EmptyClass

fun main() {
    val coffee = Coffee()
    // 코틀린 내부적으로 var는 getter, setter를 자동으로 지원, val은 getter만 지원
    coffee.name = "아메리카노"
    coffee.price = 3000
    coffee.quantity = 2
    coffee.iced = true

    if (coffee.iced) {
        println("아이스 커피")
    }

    println("커피 이름: ${coffee.name}, 가격: ${coffee.price}, 브랜드: ${coffee.brand}, 수량: ${coffee.quantity}")
}