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