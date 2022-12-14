package com.group.libraryapp.calculator

import org.junit.jupiter.api.Test

import java.lang.IllegalStateException
import java.util.Calendar

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.add()
    calculatorTest.minus()
    calculatorTest.multiply()
    calculatorTest.divide()
    calculatorTest.divideExceptionTest()
}

internal class CalculatorTest {

    @Test
    fun add() {
        // given (다음을 테스트 하려고 준비)
        val calculator = Calculator(5)

        // when (테스트 하려는 기능을 호출)
        calculator.add(3)

        // then (호출을 해봤더니 이렇게 된다)
        if (calculator.number != 8) {
            throw IllegalStateException()
        }
    }

    @Test
    fun minus() {
        // given (다음을 테스트 하려고 준비)
        val calculator = Calculator(5)

        // when (테스트 하려는 기능을 호출)
        calculator.minus(3)

        // then (호출을 해봤더니 이렇게 된다)
        if (calculator.number != 2) {
            throw IllegalStateException()
        }
    }

    @Test
    fun multiply() {
        // given (다음을 테스트 하려고 준비)
        val calculator = Calculator(5)

        // when (테스트 하려는 기능을 호출)
        calculator.multiply(3)

        // then (호출을 해봤더니 이렇게 된다)
        if (calculator.number != 15) {
            throw IllegalStateException()
        }
    }

    @Test
    fun divide() {
        // given (다음을 테스트 하려고 준비)
        val calculator = Calculator(9)

        // when (테스트 하려는 기능을 호출)
        calculator.divide(3)

        // then (호출을 해봤더니 이렇게 된다)
        if (calculator.number != 3) {
            throw IllegalStateException()
        }
    }

    @Test
    fun `0으로 나눗셈 테스트`() {
        // given
        val calculator = Calculator(9)

        // when
        calculator.divide(3)
        // then
    }

    @Test
    fun divideExceptionTest() {
        //given
        val calculator = Calculator(5)

        try {
            calculator.divide(0)
        } catch (e: IllegalArgumentException) {
            if (e.message != "0으로 나눌 수 없습니다."){
                throw IllegalStateException("메시지가 다릅니다.")
            }
            // 테스트 성공
            return
        } catch (e: Exception) {
            throw IllegalStateException()
        }
        throw IllegalStateException("기대하는 예외가 발생하지 않았습니다.")
    }
}