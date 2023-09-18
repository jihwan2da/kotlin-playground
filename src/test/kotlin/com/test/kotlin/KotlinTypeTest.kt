package com.test.kotlin

import io.kotlintest.matchers.numerics.shouldBeExactly
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.lang.RuntimeException

class KotlinTypeTest : StringSpec() {

    init {
        "explicit type change" {
            val number1 = 3
            val number2: Long = 3L

            number1.toLong() shouldBeExactly  number2
        }

        "casting" {
            val person = Person("name")
            val nullPerson = null

            getNameIfPersonByCasting(person) shouldBe "name"
            getNameIfPersonBySmartCasting(person) shouldBe "name"
            getNameIfPersonByCasting(nullPerson) shouldBe null
            getNameIfPersonBySmartCasting(nullPerson) shouldBe null
        }
    }
}

fun getNameIfPersonByCasting(obj : Any?): String? {
    val person = obj as? Person
    return person?.name
}

fun getNameIfPersonBySmartCasting(obj : Any?) : String? {
    if (obj is Person?) {
        return obj?.name
    } else {
        throw RuntimeException();
    }
}

class Person (
    val name: String
)

