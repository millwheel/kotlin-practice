package koclass.animal

import koclass.animal.behavior.Flyable
import koclass.animal.behavior.Swimmable

class Penguin(
    species: String
) : Animal(species, 2), Swimmable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄 움직인다.")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimmable>.act()
        super<Flyable>.act()
    }
}