package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class KotlinCollectionTest: StringSpec() {

    /**
     * 가변(Mutable) 컬렉션 : 컬렉션에 element를 추가, 삭제할 수 있다.
     * 불변 컬렉션 : 컬렉션에 element를 추가, 삭제 할 수 없다.
     *
     * 즉, 불변 컬렉션은 java에서 Collection.unmodifiableList() 처리를 해준 것이다.
     * java와 같이 불변 컬렉션이더라도 안에 객체의 값은 변경할 수 있다.
     */
    init {
        "List" {
            val list = listOf(100, 200)
            val mutableList = mutableListOf(100, 200)

            list[0] shouldBe 100
            list.get(0) shouldBe 100

            for (element in list) {
                println(element)
            }

            mutableList.add(300)

            for ((idx, element) in mutableList.withIndex()) {
                println("$idx $element")
            }
        }

        "Set" {
            /**
             * mutableSet의 구현체는 LinkedHashSet이다.
             */
            val set = setOf(100, 200)
            val mutableSet = mutableSetOf(100, 200)

            for (element in set) {
                println(element)
            }

            mutableSet.add(300)

            for ((idx, element) in mutableSet.withIndex()) {
                println("$idx $element")
            }
        }

        "Map" {
            val mutableMap = mutableMapOf<Int, String>()
            mutableMap.put(1, "One")
            mutableMap[2] = "Two"
            mutableMap[5] = "Five"

            for (value in mutableMap.values) {
                println(value)
            }

            for (key in mutableMap.keys) {
                println(key)
                println(mutableMap[key])
            }

            for ((key, value) in mutableMap.entries) {
                println(key)
                println(value)
            }

            val map = mapOf(1 to "One", 2 to "Two")
        }
    }
}