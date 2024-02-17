package entity

data class Money(
    val amout:Long
) {
    operator fun plus(other: Money): Money {
        return Money(this.amout + other.amout)
    }
}