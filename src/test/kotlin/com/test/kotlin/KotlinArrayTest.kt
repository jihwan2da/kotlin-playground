package com.test.kotlin

import io.kotlintest.specs.StringSpec

class KotlinArrayTest: StringSpec() {

    init {
        "indices" {
            val array = arrayOf(100, 200)
            for(i in array.indices) {
                println("$i ${array[i]}")
            }
        }

        "withIndex" {
            val array = arrayOf(100, 200)
            for((idx, value) in array.withIndex()) {
                println("$idx $value")
            }
        }

        "plus" {
            val array = arrayOf(100, 200)
            val plusArray = array.plus(300)
            for((idx, value) in plusArray.withIndex()) {
                println("$idx $value")
            }
        }
    }
}