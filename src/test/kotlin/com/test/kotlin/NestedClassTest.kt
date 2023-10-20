package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class NestedClassTest : StringSpec() {

    init {

        "static nested class" {
            val house = House(
                "address",
                House.LivingRoom(3.24)
            )

            house.livingRoom!!.area shouldBe 3.24
        }

        "inner nested class" {
            val house = House(
                "address"
            )

            println(house.bathRoom.address)
        }

    }
}

/**
 * 기본적으로 중첩 클래스는 static을 권장한다. (내부 클래스가 외부 클래스의 참조를 가지고 있지 않기 때문에 디버깅이나, 직렬화가 어렵다.)
 * java에서는 명시적으로 중첩 static 클래스를 사용하기 위해 명시적으로 static 키워드를 사용했어야 됐다.
 * 하지만 kotlin에서는 static 키워도가 없다. -> kotlin은 그냥 외부 class 안에 class 키워드 만으로 중첩클래스를 생성하면 기본적으로 static class다.
 * 그면 static클래스가 아닌 클래스는 어떻게 생성을하나? -> inner 키워드를 붙히면 된다.
 */
class House(
    private val address: String,
    val livingRoom: LivingRoom? = null,
) {

    val bathRoom: BathRoom = BathRoom(2.12)

    class LivingRoom (
        val area: Double,
    ) {
    }

    inner class BathRoom(
        private val area: Double
    ) {
        val address: String
            get() = "${this@House.address} ${this.area}"
    }
}