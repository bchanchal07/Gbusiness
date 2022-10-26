package com.milkyway.gbusiness.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J.\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020!J!\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010&J&\u0010\'\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0004J\u001c\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010-J&\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004J\b\u0010/\u001a\u0004\u0018\u00010\u0004J\b\u00100\u001a\u0004\u0018\u00010\u0004J!\u00101\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010$2\b\u0010+\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010&J&\u00103\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u00106\u001a\u0004\u0018\u00010\u0004J\u001a\u00107\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004J\u001e\u00109\u001a\u0004\u0018\u00010-2\b\u0010:\u001a\u0004\u0018\u00010-2\b\u0010;\u001a\u0004\u0018\u00010-H\u0002J\u001c\u0010<\u001a\u0004\u0018\u00010-2\b\u0010:\u001a\u0004\u0018\u00010-2\b\u0010;\u001a\u0004\u0018\u00010-R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/milkyway/gbusiness/utils/DateTimeUtils;", "", "()V", "DATE_FORMAT", "", "DATE_FORMAT_0", "DATE_FORMAT_01", "DATE_FORMAT_1", "DATE_FORMAT_10", "DATE_FORMAT_11", "DATE_FORMAT_12", "DATE_FORMAT_13", "DATE_FORMAT_14", "DATE_FORMAT_15", "DATE_FORMAT_16", "DATE_FORMAT_17", "DATE_FORMAT_18", "DATE_FORMAT_2", "DATE_FORMAT_3", "DATE_FORMAT_31", "DATE_FORMAT_32", "DATE_FORMAT_33", "DATE_FORMAT_4", "DATE_FORMAT_5", "DATE_FORMAT_6", "DATE_FORMAT_7", "DATE_FORMAT_8", "DATE_FORMAT_9", "addHrsInTimeString", "inputTimeFormat", "outputTimeFormat", "timeString", "addHrs", "", "dateStringFromSeconds", "seconds", "", "outputDateFormat", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "formatDateFromDateString", "inputDateFormat", "inputDate", "formatDateTimeFromDate", "mDateFormat", "date", "Ljava/util/Date;", "formatTimeFromTimeString", "getCurrentDate", "getCurrentTime", "getDateTimeFromTimeStamp", "time", "getMaxDateFromTwoDatesString", "createdDate", "updatedDate", "dateFormat", "getTimeStampFromDateTime", "mDateTime", "max", "d1", "d2", "min", "app_debug"})
public final class DateTimeUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.utils.DateTimeUtils INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT = "dd-MM-yyyy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_0 = "hh:mm a, dd MMM, yy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_1 = "hh:mm a";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_01 = "hh:mm";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_2 = "h:mm a";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_3 = "yyyy-MM-dd";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_31 = "yyyy-MM";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_32 = "MMM-yyyy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_33 = "yyyy-MM-dd hh:mm:ss";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_4 = "dd-MMMM-yyyy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_5 = "dd MMMM, yyyy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_6 = "dd MMMM yyyy zzzz";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_7 = "EEE, MMM d, \'\'yy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_8 = "yyyy-MM-dd hh:mm a";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_9 = "h:mm a dd MMMM yyyy";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_10 = "K:mm a, z";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_11 = "hh \'o\'\'clock\' a, zzzz";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_12 = "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_13 = "E, dd MMM yyyy HH:mm:ss z";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_14 = "yyyy.MM.dd G \'at\' HH:mm:ss z";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_15 = "yyyyy.MMMMM.dd GGG hh:mm aaa";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_16 = "EEE, d MMM yyyy HH:mm:ss Z";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_17 = "yyyy-MM-dd\'T\'HH:mm:ss.SSSZ";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATE_FORMAT_18 = "yyyy-MM-dd\'T\'HH:mm:ss.SSSXXX";
    
    private DateTimeUtils() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrentDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrentTime() {
        return null;
    }
    
    /**
     * @param time in milliseconds (Timestamp)
     * @param mDateFormat SimpleDateFormat
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDateTimeFromTimeStamp(@org.jetbrains.annotations.Nullable()
    java.lang.Long time, @org.jetbrains.annotations.Nullable()
    java.lang.String mDateFormat) {
        return null;
    }
    
    /**
     * Get Timestamp from date and time
     *
     * @param mDateTime datetime String
     * @param mDateFormat Date Format
     * @throws ParseException
     */
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    public final long getTimeStampFromDateTime(@org.jetbrains.annotations.Nullable()
    java.lang.String mDateTime, @org.jetbrains.annotations.Nullable()
    java.lang.String mDateFormat) throws java.text.ParseException {
        return 0L;
    }
    
    /**
     * Return  datetime String from date object
     *
     * @param mDateFormat format of date
     * @param date date object that you want to parse
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String formatDateTimeFromDate(@org.jetbrains.annotations.Nullable()
    java.lang.String mDateFormat, @org.jetbrains.annotations.Nullable()
    java.util.Date date) {
        return null;
    }
    
    /**
     * Convert one date format string  to another date format string in android
     *
     * @param inputDateFormat Input SimpleDateFormat
     * @param outputDateFormat Output SimpleDateFormat
     * @param inputDate input Date String
     * @throws ParseException
     */
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    public final java.lang.String formatDateFromDateString(@org.jetbrains.annotations.Nullable()
    java.lang.String inputDateFormat, @org.jetbrains.annotations.Nullable()
    java.lang.String outputDateFormat, @org.jetbrains.annotations.Nullable()
    java.lang.String inputDate) throws java.text.ParseException {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String dateStringFromSeconds(@org.jetbrains.annotations.Nullable()
    java.lang.Long seconds, @org.jetbrains.annotations.Nullable()
    java.lang.String outputDateFormat) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    public final java.lang.String getMaxDateFromTwoDatesString(@org.jetbrains.annotations.Nullable()
    java.lang.String createdDate, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedDate, @org.jetbrains.annotations.Nullable()
    java.lang.String dateFormat) throws java.text.ParseException {
        return null;
    }
    
    /**
     * Returns the maximum of two dates. A null date is treated as being less
     * than any non-null date.
     */
    private final java.util.Date max(java.util.Date d1, java.util.Date d2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    public final java.lang.String formatTimeFromTimeString(@org.jetbrains.annotations.Nullable()
    java.lang.String inputTimeFormat, @org.jetbrains.annotations.Nullable()
    java.lang.String outputTimeFormat, @org.jetbrains.annotations.Nullable()
    java.lang.String timeString) throws java.text.ParseException {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {java.text.ParseException.class})
    public final java.lang.String addHrsInTimeString(@org.jetbrains.annotations.Nullable()
    java.lang.String inputTimeFormat, @org.jetbrains.annotations.Nullable()
    java.lang.String outputTimeFormat, @org.jetbrains.annotations.Nullable()
    java.lang.String timeString, int addHrs) throws java.text.ParseException {
        return null;
    }
    
    /**
     * Returns the minimum of two dates. A null date is treated as being greater
     * than any non-null date.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date min(@org.jetbrains.annotations.Nullable()
    java.util.Date d1, @org.jetbrains.annotations.Nullable()
    java.util.Date d2) {
        return null;
    }
}