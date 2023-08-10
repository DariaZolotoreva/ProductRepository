package ru.netology.javaqa.domain;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
}
