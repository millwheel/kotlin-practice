package com.group.libraryapp.calcaulator

import org.hibernate.boot.model.naming.IllegalIdentifierException
import java.lang.IllegalArgumentException

class Calculator(
    private var _number: Int
) {

    val number: Int
        get() = this._number

    fun plus(operand:Int){
        this._number += operand
    }

    fun minus(operand: Int){
        this._number -= operand
    }

    fun multiply(operand: Int){
        this._number *= operand
    }

    fun divide(operand: Int){
        if (operand == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        this._number /= operand
    }
}