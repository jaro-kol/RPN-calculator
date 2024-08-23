package com.jaro.commands;

import com.jaro.Operator;

import java.util.Stack;

public final class AbsoluteValueCommand extends CalculationCommand {

    public AbsoluteValueCommand() {
        super(1, Operator.ABS);
    }

    @Override
    protected void performOperation(Stack<Integer> operands) {
        int operand = operands.pop();
        if (operand < 0) {
            operand = operand * -1;
        }
        operands.push(operand);
    }
}
