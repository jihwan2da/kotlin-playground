package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AbstractClassTest : StringSpec(){

    init {
        "abstract class" {
            val cat = Cat(species = "고양이과")
            val penguin = Penguin(species = "펭귄과")

            cat.legCount shouldBe 4
            penguin.wingCount shouldBe 2
            penguin.legCount shouldBe 4
        }
    }
}

abstract class Animal(
    val species: String,
    open val legCount: Int
) {
    abstract fun move()
}

class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("고양이 걸음")
    }
}

class Penguin(
    species: String,
//    private val wingCount: Int = 2
) : Animal(species, 2), Flyable, Swimable {

    val wingCount: Int = 2

    override fun move() {
        println("펭귄이 걸음")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }
}