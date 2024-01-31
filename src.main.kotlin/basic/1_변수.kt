package basic

var g = 33 // 탑레벨 변수
fun main() {
    val a : Int = 1

    val b = 1

    val c : Int // 지연할당 시 타입 명시 필수
    c = 12;

    val d : Int
    d = 1212;

    // val(value) : 변경 불가능한 변수
    // var(variable) : 변경 가능한 변수

    val e : String = "String";
//    e = "String2"; // 변수 재할당 시 컴파일 에러

    var f = 456
//    f = "hi" // 다른 타입 입력 시 컴파일 에러

    g += 33
    println(g)
}