package com.test.kotlin

import io.kotlintest.specs.StringSpec

class InterfaceTest : StringSpec(){

    init {
        "interface" {
            val penguin = Penguin(species = "펭귄과")
            penguin.act()
        }

        /**
         * java에서는 추상 필드 및 필드 오버라이드는 존재 하지 않고 getter를 override하는 방법이 존재
         * java에서 자식 클래스와 부모클래스가 같은 네임의 필드를 가지고 있다면 자식 클래스 필드는 부모클래스 필드를 숨긴다.
         * 자식 클래스 내에서 super 키워드로 같은 네임의 필드에 접근가능하다.
         */
        "open class, overrid property test" {
            val derivedClass = DerivedClass()
            println(derivedClass.myProperty)
        }
    }
}

interface Flyable {

    fun act() {
        println("날아가용~")
    }
}

interface Swimable {

    fun act() {
        println("수영해용~")
    }
}

open class BaseClass(open val myProperty: String =  "Base") {
    init {
        println("Base Class $myProperty")
    }
}

class DerivedClass(
    override val myProperty: String = "Derived"
) : BaseClass() {
    init {
        println("DerivedClass $myProperty")
    }
}
