package com.test

// 코틀린은 클래스 또는 main 함수 밖에서 값을 선언하거나 지정할 수 있다.
val classout = 100
// 컴파일할 떄 제일먼저 할당되는 값
const val classout2 = 1000

fun main() {

    // 변수
    var i = 19
    var name = "테스트"
    var point = 3.3

    // 타입을 지정하고 싶으면 : 뒤에 붙이면 되고, wrapper class 로 지정
    var i2 : Int = 19
    var name2 : String = "테스트"
    var point2 : Double = 3.3

    // 상수: 자바의 final과 동일
    val nu일 = 20
    // 재 지정이 안됨 num= 10
}