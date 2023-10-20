package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class KotlinObjectTest: StringSpec() {

    init {
        "companion object" {
            val newBaby = Person2.newBaby("name")

            Person2.log()

            newBaby.age shouldBe 1
        }

        "singleton" {
            val a = Singleton.a

            a shouldBe 0
        }

        "anonymous class" {
            moveSomething(object : Movable {
                override fun move() {
                    println("영차영차")
                }

                override fun fly() {
                    println("날다날다")
                }

            })
        }
    }
}

/**
 * kotlin에서는 static 키워드가 존재하지 않는다.
 * 대신 companion object 블락 안에 넣어둔 변수 or 함수가 java의 static 변수, 함수 처럼 활용된다.
 *
 * 그리고 val MIN_AGE 변수에 const 키워드를 붙히지 않으면 런타임시 값이 할당된다.
 * const 키워드를 붙히면 컴파일 시 할당된다. -> 진짜 상수일 때 사용하자.
 *
 * 또한 companion object 또한 객체(동반객체) 이기 때문에 이름을 가질 수 있고 인터페이스를 상속 받을 수 있다.
 */
class Person2 private constructor(
    var name: String,
    var age: Int,
) {
   companion object Factory : Log {
       private const val MIN_AGE = 1

       @JvmStatic
       fun newBaby(name: String): Person2 {
           return Person2(name, MIN_AGE)
       }

       override fun log() {
           println("Im Factory Object")
       }
   }
}

interface Log {
    fun log()
}

/**
 * kotlin에서 싱글톤 클래스를 만들기 위해서는 object 키워드를 활용하면 된다.
 */
object Singleton {
    val a = 0
}

private interface Movable {
    fun move()
    fun fly()
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}