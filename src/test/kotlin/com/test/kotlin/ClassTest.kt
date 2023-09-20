package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import java.lang.RuntimeException

class ClassTest : StringSpec() {

    init {
        "class" {
            shouldThrow<InvalidAgeException> {
                Student("jihwan2da", 0)
            }

            val student = Student("jihwan2da")
            student.age shouldBe 20
        }

        "custom getter" {
            val student1 = Student("A", 21)
            val student2 = Student("B", 19)

            student1.isNotAdult shouldBe false
            student2.isNotAdult shouldBe true
        }
    }

}
class Student(
    val name: String,
    var age: Int = 20
){
    init {
        if (age <= 0) {
            throw InvalidAgeException()
        }
    }

    /**
     * 부생성사자 보단 default 파라미터 권장
     */
//    constructor(name: String) : this(name, 20) {
//        println("신입생")
//    }

    val isNotAdult: Boolean
        get() = this.age < 20
}

class InvalidAgeException : RuntimeException()