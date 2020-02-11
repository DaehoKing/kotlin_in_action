package com.pi.big._6_type._1_null_safety

class Contract(val no:Long, val payment: Payment?) {
    fun printReceipt() = payment?.also {
            println("### 계약 결제 정보 ###")
            println("결제 유형       : ${payment?.payType}")
            println("결제 카드 정보   : ${payment?.cardName}")
            println("결제 계좌 정보   : ${payment?.bankName}")
        }
}

class Payment(val no:Long, val payType:String, val dkpgResponse: DkpgResponse? = null) {

    // 클래스 래핑하기가 수월하군...
    val cardName:String?
        get() = dkpgResponse?.cardName
    val bankName:String?
        get() = dkpgResponse?.bankName
}

class DkpgResponse(val no:Long, val cardName:String? = null, val bankName:String? = null)

fun main() {
    /*** 카드결제 ***/
    val dkpgResponse1 = DkpgResponse(1L, "삼성카드")
    val payment1 = Payment(2L, "CARD", dkpgResponse1)
    val contract1 = Contract(3L, payment1)
    contract1.printReceipt()

    println()

    /*** 계좌이체 ***/
    val payment2 = Payment(5L, "REWARD")
    val contract2 = Contract(6L, payment2)
    contract2.printReceipt()

}
