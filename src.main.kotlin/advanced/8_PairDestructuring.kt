package advanced

// Pair를 사용하면 Tuple처럼 인자를 활용할 수 있음.(2개의 인자 활용)
fun plus(pair: Pair<Int, Int>) = pair.first + pair.second

//data class Tuple(val a: Int, val b: Int)

fun main() {
    val plus = plus(Pair(1, 2))
    println(plus)

    val pair = Pair("A", 1)
//    pair.first = "B" // 데이터 클래스 기반이므로 불변 객체로 생성됨
    val newPair = pair.copy(first = "B")
    println(newPair)

    val second = newPair.component2()
    println(second)

    val list = newPair.toList() // immutable list
    println(list)

    // 3개의 인자를 활용하는 Triple
    val triple = Triple("A", "B", "C")
    println(triple)
    triple.first; triple.second; triple.third // Pair와 마찬가지로 불변

    val newTriple = triple.copy(third = "D")
    println(newTriple)

    println(newTriple.component3())

    // 구조분해 할당으로 값을 선언 가능
    val (a: String, b: String, c: String) = newTriple
    println("$a, $b, $c")

    // 리스트도 componentN을 사용할 수 있기 때문에 구조분해 할당 가능(최대 5개까지).
    val list3 = newTriple.toList()
    val (a1, a2, a3) = list3
    println("$a1, $a2, $a3")

    // key, value도 Pair로 들어가기 때문에 구조분해 할당 가능
    val map = mutableMapOf("김영완" to "개발자")
    for ((name, job) in map) {
        println("${name}의 직업은 $job")
    }
}