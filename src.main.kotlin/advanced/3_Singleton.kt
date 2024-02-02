package advanced

import java.time.LocalDateTime

// object로 객체 생성 시 싱글톤으로 생성
object Singleton {
    val a = 123
    fun printA() = println("A")
}

object DateTimeUtils {
    val now: LocalDateTime
        get() = LocalDateTime.now()

    // const는 자바의 상수 개념
    const val DEFAULT_FORMAT = "yyyy-MM-dd"

    fun same(a: LocalDateTime, b: LocalDateTime): Boolean {
        return a == b
    }
}

class MyClass {
    private constructor()

    // 동반 객체
    companion object MyCompanion {
        val a = 123
        fun newInstance() = MyClass()
    }
}

fun main() {
    println(Singleton.a)
    Singleton.printA()

    println(DateTimeUtils.now)
    println(DateTimeUtils.now)
    println(DateTimeUtils.now)

    println(DateTimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DateTimeUtils.same(now, now))

    println(MyClass.a)
    println(MyClass.newInstance())

    println(MyClass.MyCompanion.a)
    println(MyClass.MyCompanion.newInstance())
}