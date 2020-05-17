package com.lamonjush.libui.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    public static boolean isValidMobileNumber(String countryCode, String number) {
        if (!isValidString(number)) {
            return false;
        }
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(number, countryCode);
            return phoneNumberUtil.isValidNumber(phoneNumber);
        } catch (NumberParseException e) {
            return false;
        }
    }

    public static boolean isValidString(String string) {
        if (string == null)
            return false;
        string = string.trim();
        if (string.isEmpty())
            return false;
        if (string.equalsIgnoreCase("null"))
            return false;
        return true;
    }

    public static boolean isValidDouble(String string) {
        if (isValidString(string)) {
            if (!string.matches("^[0-9]*\\.?[0-9]*$")) {
                return false;
            }
            try {
                Double d = Double.parseDouble(string);
                return d != null;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    public static boolean isRoundedDouble(double d) {
        String numberD = String.valueOf(d);
        numberD = numberD.substring(numberD.indexOf(".") + 1);
        int num = Integer.parseInt(numberD);
        return num == 0;
    }

    /**
     * using regex to verify email.
     * ref: https://howtodoinjava.com/regex/java-regex-validate-email-address/ (using recommended point-5)
     *
     * @param s user giving email
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmail(String s) {
        if (isValidString(s)) {
            String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        }
        return false;
    }
}
