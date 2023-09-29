package com.example.ricegrow.DatabaseFiles.Converter;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class DateConverter {

    @TypeConverter
    public static LocalDate toLocalDate(Long timestamp) {
        return timestamp == null ? null : Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @TypeConverter
    public static Long toTimestamp(LocalDate localDate) {
        return localDate == null ? null : localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
