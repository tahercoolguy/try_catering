package com.infovass.catering.activities.utill;


import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidations {
    public final static Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$");


    public static boolean isInputNotEmpty(EditText editText) {
        String text = editText.getText().toString().trim();
        if (!text.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isInputNotEmail(String email) {
        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }
        return false;
    }

    public static boolean isInputPasswordValid(String pass) {
        if (PASSWORD_PATTERN.matcher(pass).matches()) {
            return true;
        }
        return false;
    }

    public static boolean isInputMatches(EditText input1, EditText input2) {
        String value1 = input1.getText().toString().trim();
        String value2 = input2.getText().toString().trim();
        if (!value1.isEmpty() && !value2.isEmpty()) {
            if (value1.equals(value2)) {
                return true;
            }

        }
        return false;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isStringOnlyAlphabet(String str) {
        return ((str != null)) && (!str.equals("")
                && (str.matches("^[a-zA-Z]*$")));
    }

    //  check email validation
    public static boolean isEmailValid(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(final String password) {

//        Pattern pattern;
        Matcher matcher;
//        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
//        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = PASSWORD_PATTERN.matcher(password);

        return matcher.matches();

    }
}
