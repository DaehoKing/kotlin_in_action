package com.pi.big

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Chapter6_3 : Spek({
    describe("ConcurrentModificationException 확인") {
        assertThatExceptionOfType(ConcurrentModificationException::class.java)
            .isThrownBy {
                val list = MutableList(10000000, ({ it % 3 }))
                val immutableList: List<Int> = list
                val thread = Thread(Runnable { (1..1000).forEach { list.add(it, it); println(list.get(it)) } })
                thread.isDaemon = true
                thread.start()
                immutableList.forEach { println(it) }
            }
    }
})