package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class OperatorTest : StringSpec() {

    /**
     * java 동일성 테스트(주소) -> == 연산자, Object의 equeals() 메소드
     * kotlin 동일성 테스트 -> === 연산자
     *
     * java 동등성 테스트(값) -> 오버라이딩한 equals() 메소드
     * kotlin 동등성 테스트 -> == 연산자 호출(equals() 오버라이딩 안하면 Object꺼)
     */
    init {
        "동일성 테스트" {
            val money1 = Money(1000)
            val money2 = Money(1000)
            val money3 = money1

            (money1 === money2) shouldBe false
            (money1 === money3) shouldBe true
        }

        "동등성 테스트" {
            val money1 = Money(1000)
            val money2 = Money(1000)
            val money3 = money1

            (money1 == money2) shouldBe true
            (money1 == money3) shouldBe true
        }

        "연산자 오버로딩" {
            val money1 = Money(1000)
            val money2 = Money(2000)

            val resultMoney = Money(3000)

            money1 + money2 shouldBe resultMoney
        }

        "비교 연산자 compareTo 자동 호출" {
            val money1 = Money(1000)
            val money2 = Money(2000)

            (money1 > money2) shouldBe false
        }
    }
}

data class Money(
    val money: Int
) : Comparable<Money> {
    operator fun plus(other: Money) : Money {
        return Money(this.money + other.money)
    }

    override fun compareTo(other: Money): Int {
        return this.money - other.money
    }
}