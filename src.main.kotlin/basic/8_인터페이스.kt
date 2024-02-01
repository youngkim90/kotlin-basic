package basic

interface Wheel {
    fun move()
}

interface Cart: Wheel {
    var coin: Int
    val weight: String
        get() = "20KG" // 프로퍼티의 초기값이 없기 때문에 특정 값을 반환해야함.
    fun add(product: Product)

    // 인터페이스 내부적으로 구현하는 함수의 경우 {}를 통해 구현 가능
    fun rent() {
        if (coin > 0) {
            println("카트를 대여합니다.")
        }
    }

    override fun move() {
        println("카트가 이동합니다.")
    }

    fun printId() = println("456") // 두 인터페이스에서 동일한 디폴트 함수를 선언한 경우 하위에서 구현해야만 한다.
}

interface Order {
    fun add(product: Product) {
        println("${product.name}을 주문했습니다.")
    }

    fun printId() = println("123")
}

class Product(val name: String, val price: Int)

// 복수개의 인터페이스 상속이 가능
class MyCart(override var coin: Int): Cart, Order {
    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}을 카트에 담았습니다.")

        // 부모의 동일한 함수가 있는 경우 super<부모>로 지정하여 호출해준다.
        super<Order>.add(product)
    }

    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.move()
    cart.add(Product("원두", 1000))
    cart.printId()
}
