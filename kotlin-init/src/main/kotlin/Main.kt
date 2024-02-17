import person.Person
import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    val person = Person("개발자")
    startWithA1(person.name)
}


// null이 들어갈 수 없는 함수
fun startWithA1(str:String): Boolean{
    return str.startsWith("A");
}

// null이 들어갈 수 있는 함수. safe call과 Elvis 연산자
fun startWithA2(str: String?):Boolean{
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다.")
}

// null이 들어갈 수 있는 함수. safe call과 리턴타입
fun startWithA3(str: String?):Boolean?{
    return str?.startsWith("A")
}

// str이 절대로 null이 아닐 때
fun startWithA4(str: String?): Boolean{
    return str!!.startsWith("A")
}


