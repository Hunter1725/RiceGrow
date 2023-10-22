package com.hunter.ricegrow.Activity.Planning.Calendar;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CalendarUtils {
    public static LocalDate selectDate;

    public static ArrayList<LocalDate> daysInMonthArray() {
        ArrayList<LocalDate> daysInMonthArray = new ArrayList<>();

        YearMonth yearMonth = YearMonth.from(selectDate);
        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate prevMonth = selectDate.minusMonths(1);
        LocalDate nextMonth = selectDate.plusMonths(1);

        YearMonth prevYearMonth = YearMonth.from(prevMonth);
        int prevDaysInMonth = prevYearMonth.lengthOfMonth();

        LocalDate firstOfMonth = CalendarUtils.selectDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for(int i = 1; i <= 42; i++)
        {
            if(i <= dayOfWeek)
                daysInMonthArray.add(LocalDate.of(prevMonth.getYear(),prevMonth.getMonth(),prevDaysInMonth + i - dayOfWeek));
            else if(i > daysInMonth + dayOfWeek)
                daysInMonthArray.add(LocalDate.of(nextMonth.getYear(),nextMonth.getMonth(),i - dayOfWeek - daysInMonth));
            else
                daysInMonthArray.add(LocalDate.of(selectDate.getYear(),selectDate.getMonth(),i - dayOfWeek));
        }
        return  daysInMonthArray;
    }


    public static ArrayList<LocalDate> daysInWeekArray(LocalDate selectDate) {
        ArrayList<LocalDate> days = new ArrayList<>();
        LocalDate current = sundayForDate(selectDate);
        LocalDate endDate = current.plusWeeks(1);

        while (current.isBefore(endDate)){
            days.add(current);
            current = current.plusDays(1);
        }
        return  days;
    }

    private static LocalDate sundayForDate(LocalDate current) {
        LocalDate oneWeekAgo = current.minusWeeks(1);

        while (current.isAfter(oneWeekAgo)){
            if(current.getDayOfWeek() == DayOfWeek.SUNDAY){
                return current;
            }

            current = current.minusDays(1);
        }
        return null;
    }

    public static String monthYearFromDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    public static String formattedDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return date.format(formatter);
    }

    public static String formattedDayOfWeek(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMMM");
        return date.format(formatter);
    }

    public static String formattedWeek(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE");
        return date.format(formatter);
    }
    public static String formattedFullWeek(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
        return date.format(formatter);
    }

    public static String formattedTime(long timestamp){
        Instant instant = Instant.ofEpochSecond(timestamp);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        // Format LocalDateTime in a specific format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return dateTime.format(formatter);
    }

    public static String formattedMonthDay(long timestamp){
        Instant instant = Instant.ofEpochSecond(timestamp);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        // Format LocalDateTime in a specific format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMMM");
        return dateTime.format(formatter);
    }
}
