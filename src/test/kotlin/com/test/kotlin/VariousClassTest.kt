package com.test.kotlin

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class VariousClassTest: StringSpec() {

    init {
        "data class" {
            val personDto1 = PersonDto("name", 100)
            val personDto2 = PersonDto("name", 200)

            (personDto1.name == personDto2.name) shouldBe true
            (personDto1.age == personDto2.age) shouldBe false
            println(personDto1)
        }

        "enum class" {
            println(Country.AMERICA.code)
        }

        "sealed class, interface" {

        }
    }
}

/**
 * data class는 자동으로 equals, hashcode, toString을 자동으로 생성해준다.
 */
data class PersonDto(
    val name: String,
    val age: Int
)

/**
 * when은 enum class 혹은  Sealed class와 함께 사용할 경우, 더욱더 진가를 발휘한다.
 */
enum class Country(
    val code: String
) {
    KOREA("KO"),
    AMERICA("US")
    ;
}

/**
 * enum에 대한 분기 처리를 할 때 가독성이 좋다.
 * 컴파일 시점에 enum에 어떤 값이 있는지 다 알고 있기 때문에 else 처리를 하지 않아도 된다.
 */
private fun handleCountry(country: Country) {
    when(country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}

/**
 * sealed class - 하위 클래스는 모두 같은 패키지에 위치해야한다.
 * 컴파일 시 하위 클래스의 타입을 모두 기억한다.
 * 즉, 런타임 때 클래스 타입이 추가 될 수 없다. -> enum과 비슷한 성격( when을 위처럼 Else 없이 사용가능)
 */
sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class Avante : HyundaiCar("아반떼", 1000L)
class Sonata : HyundaiCar("아반떼", 2000L)
class Grandeur : HyundaiCar("아반떼", 3000L)