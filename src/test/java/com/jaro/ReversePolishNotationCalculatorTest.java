package com.jaro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReversePolishNotationCalculatorTest {

    @Test
    public void shouldCalculateTheValueUsingReversedPolishNotation2() {
        //given
        String reversedPolishNotationExpression = "12 2 3 4 * 10 5 / + * +";

        //when
        Outcome<Integer> result = new RPNCalculator().calculate(reversedPolishNotationExpression);

        //then
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(40, ((Outcome.Success<Integer>) result).getValue());
    }

    @Test
    public void shouldReturnInvalidOperandCountError() {
        //given
        String reversedPolishNotationExpression = "12 2 3 4 * 10 5 2 / + * +";

        //when
        Outcome<Integer> result = new RPNCalculator().calculate(reversedPolishNotationExpression);

        //then
        Assertions.assertTrue(result.isError());
        Assertions.assertEquals("Invalid expression, too many operands", ((Outcome.Error<?>) result).getMessage());
    }

    @Test
    public void shouldReturnMaximumValue() {
        //given
        String reversedPolishNotationExpression = "12 5 -1 4 34 max";

        //when
        Outcome<Integer> result = new RPNCalculator().calculate(reversedPolishNotationExpression);

        //then
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(34, ((Outcome.Success<Integer>) result).getValue());
    }

    @Test
    public void shouldReturnAbsoluteValue() {
        //given
        String reversedPolishNotationExpression = "-1 abs";

        //when
        Outcome<Integer> result = new RPNCalculator().calculate(reversedPolishNotationExpression);

        //then
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(1, ((Outcome.Success<Integer>) result).getValue());
    }

    @Test
    public void shouldCalculateTheValueUsingReversedPolishNotationWithMaxOperator() {
        //given
        String reversedPolishNotationExpression = "12 2 -3 4 * 10 5 / + * + 39 max";

        //when
        Outcome<Integer> result = new RPNCalculator().calculate(reversedPolishNotationExpression);

        //then
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(39, ((Outcome.Success<Integer>) result).getValue());
    }

    @Test
    public void shouldCalculateAbsoluteValueOfTheExpression() {
        //given
        String reversedPolishNotationExpression = "5 1 3 - * -1 / 11 - abs";

        //when
        Outcome<Integer> result = new RPNCalculator().calculate(reversedPolishNotationExpression);

        //then
        Assertions.assertTrue(result.isSuccess());
        Assertions.assertEquals(1, ((Outcome.Success<Integer>) result).getValue());
    }

}
