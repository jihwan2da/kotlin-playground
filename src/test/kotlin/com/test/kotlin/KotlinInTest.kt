package com.test.kotlin

import io.kotlintest.shouldNotThrow
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import java.lang.RuntimeException

class KotlinInTest : StringSpec() {

    init {
        "in" {
            val validScore = 60
            val invalidScore = -20

            shouldNotThrow<InvalidScoreException> {
                validateScore(validScore)
            }
            shouldThrow<InvalidScoreException> {
                validateScore(invalidScore)
            }
        }
    }

}

fun validateScore(score : Int) {
    if (score !in 0..100) {
        throw InvalidScoreException()
    }
}

class InvalidScoreException : RuntimeException()