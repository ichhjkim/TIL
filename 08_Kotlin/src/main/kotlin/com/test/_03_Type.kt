package com.test

fun main() {
    var i = 10
    var l = 20L
    // 자바는 ㅣ = i가 되었지만 코틀린은 안됨
    l = i.toLong()
    i = l.toInt()

    // 이렇게하면 "10"이 10으로 변환된다
    var name = "10"
    i = name.toInt()
}