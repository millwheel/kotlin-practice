package koclass

import java.lang.IllegalArgumentException

// constructor를 맨 위에
// 필드도 생성자와 동시에 선언할 수 있다.
class Person (
    val name:String, var age: Int // primary constructor 반드시 존재 해야 한다.
){
    init{
        if (age <= 0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }

    // 또다른 새로운 생성자 추가
    constructor(name: String): this(name, 1){ // secondary constructor
        println("첫번째 부 생성자")
    } // 안에 Body를 가질 수 있다.

    constructor(): this("김말이")
}