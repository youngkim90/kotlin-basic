package advanced

class MyGenerics<out T>(val t: T) {
}

class Bag<T> {
    fun saveAll(
            to: MutableList<in T>,
            from: MutableList<T>
    ) {
        to.addAll(from)
    }
}

fun main() {
    // 타입 생략가능
    val generics = MyGenerics("Hello")

    // 변수 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()
    // 타입 아규먼트를 생성자에서 추가
    val list2 = mutableListOf<String>()

    val list3: List<*> = listOf<String>()
    val list4: List<*> = listOf<Int>(1, 2, 3)

    // PECS는 Producer-Extends, Consumer-Super의 약자로, 제네릭에서 사용되는 원칙
    // 공변성: 하위 클래스를 상위 클래스로 대체할 수 있는 것 <-> 반공변성
    // 공변성은 자바 제네릭의 extends 코틀린에선 out
    // 반공변성은 자바 제네릭의 super 코틀린에선 in

    // CharSequence 타입이어도 out이 붙어있기 때문에 하위 클래스(String)로 대체 가능(공변성)
    val charGenerics: MyGenerics<CharSequence> = generics

    // String 타입이어도 in이 붙어있기 때문에 상위 클래스(CharSequence)로 대체 가능(반공변성)
    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4"))
}