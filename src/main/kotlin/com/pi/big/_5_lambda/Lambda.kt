package com.pi.big._5_lambda

import kotlin.collections.HashMap


fun main() {
    val items = listOf(Item("상의", 100), Item("잠바", 1000), Item("속옷", 500), Item("바지", 1100))
    /*** 코틀린의 간결한 람다식 표현 ***/
    items.maxBy({ item: Item -> item.price })
    items.maxBy() { item -> item.price }
    items.maxBy { item -> item.price }
    items.maxBy { it.price }

    items.toMap({ item -> item.name }, { item -> item.price })
    items.toMap({ item -> item.name }) { item -> item.price }

    /*** 드모르간 법칙! ***/
    assert(!listOf(1, 2, 3, 4, 5, 6).any { it == 3 } == listOf(1, 2, 3, 4, 5, 6).all { it != 3 })
    /*** size vs count ***/
    items.filter { it.price > 1000 }.size // => 메모리에 리스트를 할당 함.
    items.count { it.price > 1000 } // => 조건을 만족하는 개수만 계산
    /*** Extention function member reference ***/
    listOf("apple", "banana", "cherry").groupBy { String::first }

    items.asSequence()
    val arg = "running...";
    Main.postponeComputation(2) { println(arg) }
//    Main().postponeComputation(2, object:Runnable {
//        override fun run() {
//            println("running...")
//        }
//    })
    handleComputation("aasdfasdf")
}
fun handleComputation(id:String) {
    Main.postponeComputation(1) {println(id)}
}
/*** 참고! 8.1에 나오는 함수 타입 선언 방법 ***/
fun <T, K, V> List<T>.toMap(arg0: (T) -> (K), arg1: (T) -> (V)): Map<K, V> {
    val result = HashMap<K, V>()
    this.forEach { element -> result[arg0(element)] = arg1(element) }
    return result
}

fun String.first(): Char {
    return this[0]
}

class Item(val name: String, val price: Long)