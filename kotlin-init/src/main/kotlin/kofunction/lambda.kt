package kofunction

fun lambda(){
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("수박", 20000)
    )

    val isApple = fun(fruit: Fruit): Boolean{
        return fruit.name == "사과"
    }

    val isApple2 = {fruit: Fruit -> fruit.name == "사과"}

    isApple(fruits[0])
    isApple.invoke(fruits[0])

    filterFruits(fruits, isApple) // 람다 함수를 값처럼 사용하기
    filterFruits(fruits) { fruit -> fruit.name == "수박" } // 바로 람다 함수 넣기. 람다 함수는 소괄호 밖으로 빼낼 수 있다.
    filterFruits(fruits) {it.name == "수박"} // 위와 완전 동일한 코드. it으로 람다식을 대체할 수 있음
}

class Fruit(
    val name: String,
    val price: Int
)

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits){
        if (filter(fruit)){
            results.add(fruit)
        }
    }
    return results
}