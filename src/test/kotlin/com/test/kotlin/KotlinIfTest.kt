package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class KotlinIfTest : StringSpec() {

    init {

        "if-else" {
            val grade1 = getPassOrFail(90)
            val grade2 = getPassOrFail(30)

            grade1 shouldBe "P"
            grade2 shouldBe "F"
        }
    }
}

/**
 * kotlin에서 if-else 문은 Statement 이면서 Expression이다.
 * -> 삼항 연산자가 없다.
 */
fun getPassOrFail(score: Int) : String {
    return if (score > 50) {
        "P"
    } else {
        "F"
    }
}