package com.pi.big._6_type._1_null_safety

import kotlin.random.Random

/** 6.1.1~2 코틀린에서는 **nullable references** / **non-null references** 타입을 구분한다. */
val a:String? = null
// val a:String = null

fun main() {
    /** 다음을 수행하기 위해선 null check가 선행되야 함. */
    // println("a's length : ${a.length}")
    println("a's length : ${if (a != null) a.length else -1 }")

    /** 6.1.3~4 좀더 코틀린의 간결한 문법을 사용해보자! ?, ?: */
    println("a's length : ${a?.length ?: -1}")

    /** 6.1.7 let을 이용해서 nullable한 타입을 non-null 타입 인자에 전달하기! */
    val item = if (Random.nextBoolean()) Item(1L, "잠옷바지") else null
    item?.let { approveItem(it) }

    /** 6.1.9 String null과 Empty 체크 한번에! */
    val nullString:String? = null
    nullString.isNullOrBlank()
    // 자바라면 아파치 StringUtils 클래스를 쓰던 것을!
}
class Item(val no:Long, val name:String)

fun approveItem(item: Item) {
    item.apply { println("approve item(no:${no}, name:${name})") }
}