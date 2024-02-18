package kofunction

// case 문. 어떠한 expression도 들어갈 수 있다.
// 코틀린에서 하나의 문장은 statement가 아니라 expression이다.
fun getGradeWithSwitch(score: Int):String{
    return when (score){
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

