package basic

enum class PaymentStatus(val label: String) : Payable {
    UNPAID("미지급") {
        override fun isPayable() = false
    },
    PAID("지급완료") {
        override fun isPayable() = true
    },
    FAILED("지급실패") {
        override fun isPayable() = false
    },
    REFUNDED("환불") {
        override fun isPayable() = false
    };

//    abstract fun isPayable(): Boolean // abstract 변수로 선언하여 각 enum 상수에서 구현하도록 할 수 있다.
}

interface Payable {
    fun isPayable(): Boolean
}

fun main() {
    print(PaymentStatus.PAID.label)

    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)

    if (paymentStatus == PaymentStatus.PAID) println("결제 완료 상태")

    for (status in PaymentStatus.entries) {
        println("${status.name} : ${status.label} : ${status.ordinal}")
    }
}