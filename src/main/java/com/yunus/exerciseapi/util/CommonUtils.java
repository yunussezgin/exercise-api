package com.yunus.exerciseapi.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommonUtils {

    public static LocalDate parseStringToLocalDateTime(String strDate) {
        if (StringUtils.isEmpty(strDate)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(strDate.trim(), formatter);
    }

    public static Integer parseStringToInteger(String strInteger) {
        if (StringUtils.isEmpty(strInteger)) {
            return null;
        }
        return Integer.parseInt(strInteger);
    }
}
