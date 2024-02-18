package kofunction

fun list(){
    val numbers = listOf(100, 200) // 불변 리스트. 값을 추가로 더 넣을 수 없음
    val emptyList = emptyList<Int>() // 비어있는 리스트는 타입을 먼저 명시해줘야 한다.
    printNumbers(emptyList()) // 하지만 추론이 가능한 상태면 타입을 안 적어도 된다.

    numbers[0] // 배열처럼 바로 가져올 수 있음
    numbers.get(0) // 리스트 형태로도 가져올 수 있음

    for (number in numbers){
        println(number)
    }

    val numbers2 = mutableListOf(100, 200) // 가변 리스트
    numbers2.add(300)
}

private fun printNumbers(numbers: List<Int>){

}

fun set(){
    mutableSetOf(100, 200)
}

fun map(){
    val oldMap = mutableMapOf<Int,String>()
    oldMap.put(1, "monday")
    oldMap[2] = "tuesday" // 이런식으로 파이썬처럼 딕셔너리 형태로 사용도 할 수 있다.

    val newMap = mapOf(1 to "Monday", 2 to "Tuesday") // 정적 팩토리 메소드로 바로 맵을 만들 수도 있다. to는 중위호출

    for (key in oldMap.keys){
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries){
        println(key)
        println(value)
    }
}

