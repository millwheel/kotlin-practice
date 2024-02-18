import javaclass.Car
import javaclass.CarType
import koclass.Money
import kofunction.*

fun main(args: Array<String>) {
    val money1 = Money(1000)
    val money2 = Money(1000)

    println(money1 === money2) // 동일성 체크
    println(money1 + money2) // operator function 사용

    validateScore(10)
    parseIntOrThrow("wne")

    val numbers = listOf(1, 2, 3) // Arrays.asList(1, 2, 3); 과 동일하다.
    for (number in numbers){
        println(number)
    }

    arrayV1()
    arrayV2()

    // java code 사용하기
    val car = Car("k5-2023-01", "k5", CarType.SEDAN)
    print(car.id + " ")
    print(car.modelName + " ")
    println(car.carType)

    collection()
}







