package org.example.validation.impl;

import org.example.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorPinCode implements Validator {
    private static final String regex="\\d{4}";
    @Override
    public boolean validator(StringBuilder password) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
