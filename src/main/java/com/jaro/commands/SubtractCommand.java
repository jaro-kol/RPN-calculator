package com.jaro.commands;

import com.jaro.Operator;

import java.util.Stack;

public final class SubtractCommand extends CalculationCommand {

    public SubtractCommand() {
        super(2, Operator.SUBTRACT);
    }

    @Override
    protected void performOperation(Stack<Integer> operands) {
        int b = operands.pop();
        int a = operands.pop();
        operands.push(a - b);
    }
}
