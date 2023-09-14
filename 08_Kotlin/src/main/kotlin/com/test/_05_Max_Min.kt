package com.test

fun main() {
    var i = 20
    var j = 40
    println(kotlin.math.max(i, j)) // 코틀린에 있는 math max를 사용하는 것이 Integer.max, Math.max보다 성능이 좋다
}