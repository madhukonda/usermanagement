package com.rao.usermanagement.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private static String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";


    public static boolean validatePassword(final String password) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
