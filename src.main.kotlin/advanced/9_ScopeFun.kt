package advanced

fun main() {
//    let()
//    run()
//    with()
//    apply()
    also()

//    val this: String? = null // this는 다른 용도로 사용 불가
    val it: String? = null // it은 다른 용도로 사용 가능
}
fun let() {
    val str: String? = "Hello"

    // let은 null이 아닌 경우에만 실행됨
    val result: Int? = str?.let {
        println(it)

        val abc: String? = "abc"
        val def: String? = "def"
        if(!abc.isNullOrEmpty() && !def.isNullOrEmpty()) {
            println("abcdef가 null 아님")
        }
        1234 // let 함수의 마지막 줄은 반환값
    }
    println(result)
}

class DatabaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null

    fun connect(): Boolean {
        println("Connecting...")
        Thread.sleep(1000)
        println("Connected")
        return true
    }
}
fun run() {
    // run은 객체의 값을 설정하고 함수를 호출하고자 할 때 사용
    // let으로도 가능하지만 it을 사용해야 하기 때문에 run이 더 편리함
    val connected: Boolean = DatabaseClient().run {
        url = "localhost:3306"
        username = "root"
        password = "1234"
        connect() // run 함수의 마지막 줄은 반환값
    }
    println(connected)
}

fun with() {
    var str = "Hello"

    // with는 확장 함수가 아니라는 점에서 run과 다름
    val length: Int = with(str) {
        println("length = $length")
        length
    }

    val result: Boolean = with(DatabaseClient()) {
        url = "localhost:3306"
        username = "root"
        password = "1234"
        connect()
    }
    println(result)
}

fun apply() {
    // apply는 반환 값이 객체 자신
    val client: DatabaseClient = DatabaseClient().apply {
        url = "localhost:3306"
        username = "root"
        password = "1234"
    }
    client.connect().run {
        println(this)
    }
}

class User(val name: String, val password: String) {
    fun validate() {
        if(name.isNotEmpty() && password.isNotEmpty()) {
            println("유효하지 않은 사용자입니다.")
        } else {
            println("유효한 사용자입니다.")
        }
    }

    fun printName() = println(name)
}

fun also() {
    User(name = "wani", password = "1234").also {
        it.validate()
        it.printName()
    }
}
