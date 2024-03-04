package com.group.libraryapp.dto.homework.day2.response;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateResponse {

    private String dayOfTheWeek;

    public DateResponse(DayOfWeek dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

}
