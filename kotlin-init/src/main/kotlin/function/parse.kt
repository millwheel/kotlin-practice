package function

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun parseIntOrThrow(str: String): Int?{
    return try{
        str.toInt() // 형변환
    } catch (e: NumberFormatException){
        null
    }
}