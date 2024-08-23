package com.jaro.commands;

import com.jaro.Operator;

import java.util.Stack;

public final class MultiplyCommand extends CalculationCommand {
    public MultiplyCommand() {
        super(2, Operator.MULTIPLY);
    }

    @Override
    protected void performOperation(Stack<Integer> operands) {
        operands.push(operands.pop() * operands.pop());
    }
}
