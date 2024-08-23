package com.jaro;

public sealed class Outcome<T> {

    public static final class Success<T> extends Outcome<T> {
        T value;

        public Success(T value) {
            this.value = value;
        }

        public Success() {
            this.value = null;
        }

        public T getValue() {
            return value;
        }

        public boolean hasValue() {
            return value != null;
        }
    }

    public static final class Error<Void> extends Outcome<Void> {
        String message;

        public Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public boolean isSuccess() {
        return this instanceof Outcome.Success<T>;
    }

    public boolean isError() {
        return this instanceof Outcome.Error<T>;
    }

    public static  Error<Void> error(String message) {
        return new Error<>(message);
    }

    public static <Void> Success<Void> succes() {
        return new Success<>();
    }

    public static <T> Success<T> success(T value) {
        return new Success<>(value);
    }
}