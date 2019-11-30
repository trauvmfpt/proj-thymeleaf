package com.fpt.t1708e.photoplatform.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getDate(long millisecond){
        // Creating date format
        DateFormat simple = new SimpleDateFormat("dd MMMM yyyy");

        // Creating date from milliseconds
        // using Date() constructor
        Date result = new Date(millisecond);

        // Formatting Date according to the
        // given format
        return simple.format(result);
    }
}
