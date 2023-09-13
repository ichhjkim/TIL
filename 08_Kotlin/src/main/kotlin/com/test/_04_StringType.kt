package com.test

fun main() {
    var name = "hello"
    println(name)

    var stringAddInt = "String" + 100  // 문자와 숫자를 더하면 String100으로 스트링으로 생성된다
    println(stringAddInt)

    println(name.uppercase()) // 대문자
    println(name.lowercase()) // 소문자

    println(name[0]) // 특정 배열의 글자 접근 가능

    name = "테스터"
    println("제 이름은 "+ name + "입니다")
    println("제 이름은 ${name}입니다")
    println("제 이름은 ${name+ 10}입니다") // 이런 식으로 수식을 추가할 수도 있따.


}