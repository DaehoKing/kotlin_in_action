package com.pi.big

import com.pi.big._6_type._1_null_safety.Person
import org.assertj.core.api.Assertions.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object Chapter6_1 : Spek({
    describe("초기화 되지 않은 오브젝트 사용") {
        class LeakingThis {
            val a:String

            constructor(a: String) {
                something()
                this.a = a
            }

            fun something() {
                print("a's length: ${a.length}")
            }
        }

        it("NPE") {
            assertThatNullPointerException().isThrownBy { LeakingThis("pi.big") }
        }
    }
    describe("6.1.11 자바 타입을 사용하는 코틀린 함수") {
        it("함수 실행 전 널 검사를 함") {
            assertThatIllegalStateException().isThrownBy { println("${Person(null).name.toUpperCase()} !!!") }
        }

        it("함수 실행 후 NPE 발생") {
            assertThatNullPointerException().isThrownBy { println("${Person(null).name.toString()} !!!") }
        }

        it("플랫폼타입 변수 대입") {
            assertThatIllegalStateException().isThrownBy { val n:String  = Person(null).name }

            assertThatCode { val n:String?  = Person(null).name }.doesNotThrowAnyException()
        }
    }
})