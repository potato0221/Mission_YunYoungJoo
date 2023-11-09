package com.ll.standard.util;

public class Ut {

    public static class str{

        public static int parseInt(String paramValue,int defaultValue) {
            try {
                return Integer.parseInt(paramValue);
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
    }

}
