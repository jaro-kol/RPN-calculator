package com.jaro;

import com.jaro.commands.*;
import com.jaro.exceptions.UnsupportedOperatorException;

import java.util.HashMap;
import java.util.Optional;

public class CommandDispatcher {

    private final HashMap<Operator, CalculationCommand> commands;

    public CommandDispatcher() {
        this.commands = new HashMap<>();
        commands.put(Operator.ADD, new AddCommand());
        commands.put(Operator.SUBTRACT, new SubtractCommand());
        commands.put(Operator.MULTIPLY, new MultiplyCommand());
        commands.put(Operator.DIVIDE, new DivideCommand());
        commands.put(Operator.MAX, new MaximumValueCommand());
        commands.put(Operator.ABS, new AbsoluteValueCommand());
    }

    public CalculationCommand getCommand(Operator operator) {
        return Optional.ofNullable(commands.get(operator))
                .orElseThrow(() -> new UnsupportedOperatorException(String.format("Operator %s command is not implemented", operator.name())));
    }
}
