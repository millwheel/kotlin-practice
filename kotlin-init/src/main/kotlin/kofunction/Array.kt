package kofunction

fun array(){
    val array = arrayOf(100, 200)

    array.plus(300)
    for ((idx, value) in array.withIndex()){
        println("$idx $value")
    }
}