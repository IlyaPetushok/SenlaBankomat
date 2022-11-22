package org.example.validation.impl;

import org.example.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorNumberCard implements Validator {
    private static final String regex="(6546|8293|4356) (\\d{4} ){2}\\d{4}";
    @Override
    public boolean validator(StringBuilder numberCard) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numberCard);
        return matcher.matches();
    }
}
