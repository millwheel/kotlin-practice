package koclass

import java.lang.IllegalArgumentException

class Member(
    val name: String = "김마리",
    var age: Int = 1 // 부생성자 사용보다는 default parameter를 쓰는 것이 낫다.
) {
    init{
        if (age <= 0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }
}