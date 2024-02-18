package kofunction


fun arrayV1(){
    val array = arrayOf(100, 200)

    array.plus(300) // element 추가
    for (i in array.indices){
        println("$i ${array[i]}")
    }
}

fun arrayV2(){
    val array = arrayOf(100, 200)

    array.plus(300) // element 추가
    for ((idx, value) in array.withIndex()){
        println("$idx $value")
    }
}