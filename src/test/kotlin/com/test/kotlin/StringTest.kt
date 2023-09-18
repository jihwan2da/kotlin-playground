package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class StringTest : StringSpec() {

    init {
        "string interpolation" {
            val name = "김지환"
            val age = 25

            println("안녕하세요 저는 ${name}입니다. 나이는 ${age}입니다.")
        }

        "without indent string" {
            val name = "지환"
            val str = """
                HI
                My Name is
                ${name}
            """.trimIndent()

            println(str)
        }

        "string indexing" {
            val str = "ABC"
            str[0] shouldBe 'A'
            str[1] shouldBe 'B'
            str[2] shouldBe 'C'
        }
    }
}