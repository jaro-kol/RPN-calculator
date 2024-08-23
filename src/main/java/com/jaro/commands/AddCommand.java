package com.jaro.commands;

import com.jaro.Operator;

import java.util.Stack;

public final class AddCommand extends CalculationCommand {

    public AddCommand() {
        super(2, Operator.ADD);
    }

    @Override
    protected void performOperation(Stack<Integer> operands) {
        operands.push(operands.pop() + operands.pop());
    }
}
