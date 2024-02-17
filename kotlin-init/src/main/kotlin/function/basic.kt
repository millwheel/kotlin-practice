package function

// 코틀린에서는 중괄호와 return이 아래처럼 대체 가능함
// 중괄화 대신 = 를 쓰면 타입도 생략 가능
fun max(a:Int, b:Int) = if (a > b){ a } else { b }


// 코틀린에는 함수 자체에도 기본값을 사용할 수 있다.
fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
){
    for(i in 1..num){
        if(useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}