package kofunction

fun validateScore(score: Int){
    if (score in 0..20){
        println("This is valid score = ${score}")
    }
}