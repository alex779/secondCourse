/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.projectone.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hovercat
 */
public class ValidationCheck {

    private static final Pattern NUM
            = Pattern.compile(".*[^0-9].*");

    private static final Pattern TIME
            = Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");

    private static final Pattern DAY
            = Pattern.compile("^[1-7]$");

    public static boolean dayValidator(String day) {
        Matcher matcher = DAY.matcher(day);
        return matcher.find();
    }

    public static boolean numValidator(String num) {
        Matcher matcher = NUM.matcher(num);
        return !matcher.find();
    }

    public static boolean timeValidator(String time) {
        Matcher matcher = TIME.matcher(time);
        return matcher.find();
    }

    public static boolean dVal(String day) {

        return day.equals(Day.valueOf(day).getDay());

    }

    public enum Day {
        MON("Monday"),
        TUE("Tuesday"),
        WED("Wednesday"),
        THU("Thursday"),
        FRI("Friday"),
        SAT("Saturday"),
        SUN("Sunday");

        private Day(String day) {
            this.day = day;
        }

        private final String day;

        public String getDay() {
            return this.day;
        }

        @Override
        public String toString() {
            return this.day;
        }
    }

    public static final boolean listVal(List<String> list, String line) {

        boolean result;
        list = new ArrayList<>();

        Optional<String> queryResult = list.stream()
                .filter(value -> value != null)
                .filter(value -> value.equalsIgnoreCase(line))
                .findFirst();
        if (queryResult.isPresent()) {
            System.out.println("Found " + line + " in list");
            result = true;
        } else {
            System.out.println("Could not find " + line + " in list");
            result = false;
        }

        return result;
    }

}
