package com.jaro;

import java.util.Optional;
import java.util.Stack;

public class RPNCalculator {

    private final CommandDispatcher commandDispatcher;
    private final Stack<Integer> operands;
    private static final String WHITESPACE_SEPARATOR = " ";

    public RPNCalculator() {
        this.commandDispatcher = new CommandDispatcher();
        this.operands = new Stack<>();
    }

    public Outcome<Integer> calculate(String expression) {
        String[] expressionElements = expression.split(WHITESPACE_SEPARATOR);
        for (String element : expressionElements) {
            if (isNumber(element)) {
                operands.push(Integer.parseInt(element));
            } else {
                Optional<Operator> operator = Operator.ofSign(element);
                if (operator.isPresent()) {
                    Outcome<?> outcome = commandDispatcher.getCommand(operator.get()).execute(operands);
                    if (outcome.isError()) {
                        return new Outcome.Error<>(((Outcome.Error<?>) outcome).message);
                    }
                } else {
                    return new Outcome.Error<>(String.format("Invalid expression, unsupported operator: %s", element));
                }
            }
        }
        return validatedOutput();
    }

    private boolean isNumber(String element) {
        for (int i = 0; i < element.length(); ++i) {
            if (i == 0 && element.charAt(0) == '-' && element.length() > 1) {
            }
            else if (!Character.isDigit(element.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public Outcome<Integer> validatedOutput() {
        if (operands.size() > 1) {
            return new Outcome.Error<>("Invalid expression, too many operands");
        } else {
            return new Outcome.Success<>(operands.pop());
        }
    }
}
