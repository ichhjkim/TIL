package com.test

import kotlin.random.Random

fun main() {
    var num = Random.nextInt()
    println(num)

    var rangeNum = Random.nextInt(0, 100) // 0부터 99까지
    println(rangeNum)
}