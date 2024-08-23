package com.jaro.commands;

import com.jaro.Operator;

import java.util.Stack;

public final class MaximumValueCommand extends CalculationCommand {

    public MaximumValueCommand() {
        super(1, Operator.MAX);
    }

    @Override
    protected void performOperation(Stack<Integer> operands) {
        int value = Integer.MIN_VALUE;

        while (!operands.isEmpty()) {
            int operand = operands.pop();
            if (operand > value) {
                value = operand;
            }
        }
        operands.push(value);
    }
}
