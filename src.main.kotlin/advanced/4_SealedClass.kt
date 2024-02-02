package advanced

// sealed class는 다른 패키지나 모듈에서는 상속이 불가능하다.
sealed class Developer {
    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자 ${name}입니다. ${language}를 사용합니다.")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 프론트 개발자 ${name}입니다. ${language}를 사용합니다.")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when(developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        // sealed class를 사용하면 컴파일러가 하위 클래스를 인지하기 때문에 오류를 줄일 수 있음
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name = "완이")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name = "숙이")
    DeveloperPool.add(frontendDeveloper)

    println(DeveloperPool.get("완이"))
    println(DeveloperPool.get("숙이"))
}