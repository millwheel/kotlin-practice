package function

// 코틀린에서는 중괄호와 return이 아래처럼 대체 가능함
// 중괄화 대신 = 를 쓰면 타입도 생략 가능
fun max(a:Int, b:Int) = if (a > b){ a } else { b }