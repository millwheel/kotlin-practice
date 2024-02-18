package koclass.animal

class Cat(
    species: String
) : Animal(species, 4) { // 상속 받을 때는 한 칸 띄우고 콜론을 쓴다.

    // override 필수적으로 붙여야 한다.
    override fun move() {
        print("고양이 움직인다")
    }
}