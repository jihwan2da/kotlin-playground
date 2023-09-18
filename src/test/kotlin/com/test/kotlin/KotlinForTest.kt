package com.test.kotlin

import io.kotlintest.specs.StringSpec

class KotlinForTest : StringSpec() {

    init {
        "foreach" {
            val elements = listOf("가", 3L, "나")

            for (element in elements) {
                println(element)
            }
        }

        "for" {
            for(i in 1..3) {
                println(i)
            }
        }

        "for downTo" {
            for (i in 3 downTo 1) {
                println(i)
            }
        }

        "for step" {
            for (i in 1..5 step 2) {
                println(i)
            }
        }
    }
}