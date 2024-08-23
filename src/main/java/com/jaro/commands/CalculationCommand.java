package com.jaro.commands;

import com.jaro.Operator;
import com.jaro.Outcome;

import java.util.Stack;

public sealed abstract class CalculationCommand permits
        AddCommand, SubtractCommand, MultiplyCommand,
        DivideCommand, MaximumValueCommand, AbsoluteValueCommand {

    protected final Integer minimalOperandCount;
    protected final Operator operator;

    protected CalculationCommand(Integer minimalOperandCount, Operator operator) {
        this.minimalOperandCount = minimalOperandCount;
        this.operator = operator;
    }

    public Outcome<Void> execute(Stack<Integer> operands) {
        Outcome<Void> validationOutcome = validateInput(operands);
        if (validationOutcome.isError()) {
            return validationOutcome;
        }
        performOperation(operands);
        return new Outcome.Success<>(null);
    }

    protected Outcome<Void> validateInput(Stack<Integer> operands) {
        if (operands.size() < minimalOperandCount) {
            return Outcome.error(String.format("Invalid expression, insufficient operands for %s operations", operator.getSign()));
        }
        return Outcome.succes();
    }

    protected abstract void performOperation(Stack<Integer> operands);
}
