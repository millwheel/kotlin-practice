package function

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun parseIntOrThrow(str: String): Int{
    try{
        return str.toInt() // 형변환
    } catch (e: NumberFormatException){
        throw IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다.")
    }
}