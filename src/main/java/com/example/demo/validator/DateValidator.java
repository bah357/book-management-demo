package com.example.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.sql.Date;
import java.time.LocalDate;

import java.time.format.DateTimeParseException;

public class DateValidator implements ConstraintValidator<ValidDate, String> {

    @Override
    public boolean isValid(String dateStr, ConstraintValidatorContext context) {
        try {
            LocalDate date = Date.valueOf(dateStr).toLocalDate();
            int year = date.getYear();
            int currentBuddhistYear = LocalDate.now().getYear() + 543;
            return year >= 1000 && year <= currentBuddhistYear;
        } catch (IllegalArgumentException | DateTimeParseException e) {
            // Invalid date format or null date
            return false;
        }
    }
}