package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class FunctionTest : StringSpec() {

    init {
        "function" {
            max(1, 2) shouldBe 2
            max(3, 2) shouldBe 3
        }

        "defaultParameter" {
            repeat("jihwan2da")
            repeat("jihwan2da", 4, false)
        }

        "named argument" {
            repeat(str = "jihwan2da", useNewLine = false)
        }

        "가변 인자" {
            printAll("A", "B", "C")

            val array = arrayOf("D", "E", "F")
            printAll(*array)
        }
    }
}

fun max(a: Int, b: Int) = if(a > b) a else b

fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}