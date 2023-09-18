package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class KotlinWhenTest : StringSpec() {

    init {
        "when" {
            judgeNumber(0) shouldBe "ZERO"
            judgeNumber(2) shouldBe "EVEN"
            judgeNumber(3) shouldBe "ODD"
        }
    }
}

/**
 * kotlin 에서는 switch-case-default 문이 사라졌다.
 * when이 등장하였는데 조건문에 어떠한 expression이 들어갈 수 있다. when 또한 expression 이다.
 * 또한 when(값)에서 값이 없을 수 있다. - java의 early return 처럼 동작
 */
fun judgeNumber(number : Int) : String {
    return when {
        number == 0 -> "ZERO"
        number % 2 == 0 -> "EVEN"
        number % 2 == 1 -> "ODD"
        else -> throw RuntimeException()
    }
}