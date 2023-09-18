package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import java.lang.NullPointerException

class NullableTypeTest : StringSpec() {

    /**
     * 코틀린의 모든 type 은 Any? 를 상속받음
     * 그리고 nullable - non-nullable 따로 상속 구조를 가진다.
     *
     * 하지만 컴파일 이후에는 자바 코드로 변경되는데,
     * 자바에는 nullable non-nullable type 구분이 없다.
     *
     * 그래서 이같은 nullable type 구분은 컴파일 시점에만 유효하다.
     * -> 컴파일 시점에 널의 안정성을 보장 받을 수 있다!!
     * -> null에 대한 컴파일 통과를 위해 Safe Call 또는 Elvis 연산자를 활용할 수 있다.
     */
    init {
        "non-nullable string" {
            val str : String = "ABC"
            str.length shouldBe 3
        }

        "nullable string" {
            val str : String? = null

            str?.length shouldBe null
            (str?.length ?: 0) shouldBe 0
        }

        "runtime npe" {
            val str : String? = null

            shouldThrow<NullPointerException> {
                str!!.length
            }
        }
    }
}