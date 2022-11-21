package org.example.validation.impl;

import org.example.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorPinCode implements Validator {
    @Override
    public boolean validator(StringBuilder password) {
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
