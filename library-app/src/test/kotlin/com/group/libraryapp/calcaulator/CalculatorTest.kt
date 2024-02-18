package com.group.libraryapp.calcaulator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.IllegalArgumentException


class CalculatorTest {

    @Test
    fun plus() {
        // given
        val calculator = Calculator(5)
        // when
        calculator.plus(3)
        // then
        assertThat(calculator.number).isEqualTo(8)
    }

    @Test
    fun minus() {
        // given
        val calculator = Calculator(5)
        // when
        calculator.minus(3)
        // then
        assertThat(calculator.number).isEqualTo(2)
    }

    @Test
    fun multiply() {
        val calculator = Calculator(5)
        // when
        calculator.multiply(3)
        // then
        assertThat(calculator.number).isEqualTo(15)
    }

    @Test
    fun divide() {
        val calculator = Calculator(10)
        // when
        calculator.divide(3)
        // then
        assertThat(calculator.number).isEqualTo(3)
    }

    @Test
    fun divideException() {
        val calculator = Calculator(10)
        // when
        val exception = assertThrows<IllegalArgumentException> {
            calculator.divide(0)
        }
        // then
        assertThat(exception.message).isEqualTo("0으로 나눌 수 없습니다.")
    }
}