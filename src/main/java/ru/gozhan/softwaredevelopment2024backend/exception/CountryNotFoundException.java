package ru.gozhan.softwaredevelopment2024backend.exception;

public class CountryNotFoundException extends RuntimeException {

    protected static final String MESSAGE = "Country not found by this id";

    public CountryNotFoundException() {
        super(MESSAGE);
    }

}
