import koclass.Money
import koclass.Person
import kofunction.parseIntOrThrow
import kofunction.validateScore

fun main(args: Array<String>) {
    val money1 = Money(1000)
    val money2 = Money(1000)

    println(money1 === money2)
    println(money1 + money2)

    val person = Person("김말이", 100)

    validateScore(10)
    parseIntOrThrow("wne")

    val numbers = listOf(1, 2, 3) // Arrays.asList(1, 2, 3); 과 동일하다.
    for (number in numbers){
        println(number)
    }

}







