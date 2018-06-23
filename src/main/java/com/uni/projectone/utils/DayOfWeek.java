/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.projectone.utils;

/**
 *
 * @author hovercat
 */
public class DayOfWeek {

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
    
    
}
