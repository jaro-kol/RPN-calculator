package com.jaro;

import java.util.HashMap;
import java.util.Optional;

public enum Operator {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), MAX("max"), ABS("abs");

    private final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    private static final HashMap<String, Operator> operators = new HashMap<>();

    static {
        for (Operator operator : Operator.values()) {
            operators.put(operator.sign, operator);
        }
    }

    public static Optional<Operator> ofSign(String sign) {
        return Optional.ofNullable(operators.get(sign));
    }
}
