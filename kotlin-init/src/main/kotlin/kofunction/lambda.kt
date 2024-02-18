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
}

class Fruit(
    val name: String,
    val price: Int
)