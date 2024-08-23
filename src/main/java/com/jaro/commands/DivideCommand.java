package com.jaro.commands;

import com.jaro.Operator;

import java.util.Stack;

public final class DivideCommand extends CalculationCommand {

    public DivideCommand() {
        super(2, Operator.DIVIDE);
    }

    @Override
    protected void performOperation(Stack<Integer> operands) {
        int b = operands.pop();
        int a = operands.pop();
        operands.push(a / b);
    }
}
