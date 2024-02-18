package com.group.libraryapp.calcaulator

import org.hibernate.boot.model.naming.IllegalIdentifierException

class Calculator(
    private var number: Int
) {

    fun plus(operand:Int){
        this.number += operand
    }

    fun minus(operand: Int){
        this.number -= operand
    }

    fun multiply(operand: Int){
        this.number *= operand
    }

    fun divide(operand: Int){
        if (operand == 0) throw IllegalIdentifierException("0으로 나눌 수 없습니다.")
        this.number /= operand
    }
}