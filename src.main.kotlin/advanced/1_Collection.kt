package advanced

import java.util.ArrayList
import java.util.LinkedList

fun main() {
    // immutable list
    val currencyList = listOf("달러", "유로", "엔")
//    currencyList.add("원") // 불가능

    // mutable list
    val mutableCurrencyList = mutableListOf<String>()
    mutableCurrencyList.addAll(currencyList)
    mutableCurrencyList.add("원")

    // apply로 생성
    val mutableCurrencyList2 = mutableListOf<String>().apply {
        this.addAll(currencyList)
        this.add("원")
    }

    // immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    // immutable map
    val numberMap = mapOf("one" to 1, "two" to 2, "three" to 3)

    // mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1 // 리터럴 문법
    mutableNumberMap.put("two", 2) // 함수 문법
    mutableNumberMap["three"] = 3

    // 컬렉션 빌더는 내부에서는 mutable, 반환 시엔 immutable 리스트
    val list: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }

    // linked list
    val linkedList = LinkedList<Int>().apply {
        addFirst(1)
        add(2)
        addLast(3)
    }

    // array list
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("=====")

    for (currency in currencyList) {
        println(currency)
    }

    currencyList.forEach {
        println(it)
    }

    // for loop -> map
    val lowerList = listOf("a", "b", "c")
    val upperList = mutableListOf<String>()
    for (lower in lowerList) {
        upperList.add(lower.uppercase())
    }
    println(upperList)

    // iterable map
    val upperList2 = lowerList.map { it.uppercase() }
    println(upperList2)

    // for loop -> filter
    val filteredList = mutableListOf<String>()
    for (upperCase in upperList) {
        if (upperCase == "B" || upperCase == "C") {
            filteredList.add(upperCase)
        }
    }

    // iterable filter
    val filteredList2 = upperList.filter { it == "B" || it == "C" }
    println(filteredList2)

    // 자바의 stream과 유사하게 터미널 오퍼레이터 사용 가능
    val filteredList3 = upperList
            .asSequence()
            .filter { it == "B" || it == "C" }
            .filter { it == "A" }
            .filter { it == "A" }
            .filter { it == "A" }
            .filter { it == "A" }
            .toList() // 최종 연산 호출 시점에 컨렉션을 실행하기 때문에 메모리 이슈를 줄일 수 있다
}