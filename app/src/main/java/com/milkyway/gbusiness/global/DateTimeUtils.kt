package com.milkyway.gbusiness.global

import android.text.format.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object DateTimeUtils {

    const val DATE_FORMAT = "dd-MM-yyyy"
    const val DATE_FORMAT_0 = "hh:mm a, dd MMM, yy"
    const val DATE_FORMAT_1 = "hh:mm a"
    const val DATE_FORMAT_01 = "hh:mm"
    const val DATE_FORMAT_2 = "h:mm a"
    const val DATE_FORMAT_3 = "yyyy-MM-dd"
    const val DATE_FORMAT_31 = "yyyy-MM"
    const val DATE_FORMAT_32 = "MMM-yyyy"
    const val DATE_FORMAT_33 = "yyyy-MM-dd hh:mm:ss"
    const val DATE_FORMAT_4 = "dd-MMMM-yyyy"
    const val DATE_FORMAT_5 = "dd MMMM, yyyy"
    const val DATE_FORMAT_6 = "dd MMMM yyyy zzzz"
    const val DATE_FORMAT_7 = "EEE, MMM d, ''yy"
    const val DATE_FORMAT_8 = "yyyy-MM-dd hh:mm a"
    const val DATE_FORMAT_9 = "h:mm a dd MMMM yyyy"
    const val DATE_FORMAT_10 = "K:mm a, z"
    const val DATE_FORMAT_11 = "hh 'o''clock' a, zzzz"
    const val DATE_FORMAT_12 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val DATE_FORMAT_13 = "E, dd MMM yyyy HH:mm:ss z"
    const val DATE_FORMAT_14 = "yyyy.MM.dd G 'at' HH:mm:ss z"
    const val DATE_FORMAT_15 = "yyyyy.MMMMM.dd GGG hh:mm aaa"
    const val DATE_FORMAT_16 = "EEE, d MMM yyyy HH:mm:ss Z"
    const val DATE_FORMAT_17 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
    const val DATE_FORMAT_18 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"

    fun getCurrentDate(): String? {
        val dateFormat = SimpleDateFormat(DATE_FORMAT)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val today = Calendar.getInstance().time
        return dateFormat.format(today)
    }

    fun getCurrentTime(): String? {
        val dateFormat = SimpleDateFormat(DATE_FORMAT_1)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val today = Calendar.getInstance().time
        return dateFormat.format(today)
    }

    fun getCurrentDateBY_(): String? {
        val c = Calendar.getInstance()
        val month = c[Calendar.MONTH] + 1
        val year = c[Calendar.YEAR]
        val date = c[Calendar.DATE]
        return "$date-$month-$year"
    }
    /**
     * @param time in milliseconds (Timestamp)
     * @param mDateFormat SimpleDateFormat
     */
    fun getDateTimeFromTimeStamp(time: Long?, mDateFormat: String?): String? {
        val dateFormat = SimpleDateFormat(mDateFormat)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val dateTime = Date(time!!)
        return dateFormat.format(dateTime)
    }

    /**
     * Get Timestamp from date and time
     *
     * @param mDateTime datetime String
     * @param mDateFormat Date Format
     * @throws ParseException
     */
    @Throws(ParseException::class)
    fun getTimeStampFromDateTime(mDateTime: String?, mDateFormat: String?): Long {
        val dateFormat = SimpleDateFormat(mDateFormat)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = dateFormat.parse(mDateTime)
        return date.time
    }

    /**
     * Return  datetime String from date object
     *
     * @param mDateFormat format of date
     * @param date date object that you want to parse
     */
    fun formatDateTimeFromDate(mDateFormat: String?, date: Date?): String? {
        return if (date == null) {
            null
        } else DateFormat.format(mDateFormat, date).toString()
    }

    /**
     * Convert one date format string  to another date format string in android
     *
     * @param inputDateFormat Input SimpleDateFormat
     * @param outputDateFormat Output SimpleDateFormat
     * @param inputDate input Date String
     * @throws ParseException
     */
    @Throws(ParseException::class)
    fun formatDateFromDateString(
        inputDateFormat: String?, outputDateFormat: String?,
        inputDate: String?,
    ): String? {
        val mParsedDate: Date
        val mOutputDateString: String
        val mInputDateFormat = SimpleDateFormat(inputDateFormat, Locale.getDefault())
        val mOutputDateFormat = SimpleDateFormat(outputDateFormat, Locale.getDefault())
        mParsedDate = mInputDateFormat.parse(inputDate)
        mOutputDateString = mOutputDateFormat.format(mParsedDate)
        return mOutputDateString
    }

    fun dateStringFromSeconds(seconds: Long?, outputDateFormat: String?): String? {
        val formatter = SimpleDateFormat(outputDateFormat)
        //val dateString = formatter.format(Date(seconds!! * 1000L))
        return formatter.format(Date(seconds!! * 1000L))
    }

    @Throws(ParseException::class)
    fun getMaxDateFromTwoDatesString(
        createdDate: String?, updatedDate: String?, dateFormat: String?,
    ): String? {
        val mCreatedDate: Date?
        val mUpdatedDate: Date?

        val mOutputDateString: String
        val mDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())

        mCreatedDate = mDateFormat.parse(createdDate)
        mUpdatedDate = mDateFormat.parse(updatedDate)
        val mMaxDate = max(mCreatedDate, mUpdatedDate)

        mOutputDateString = mDateFormat.format(mMaxDate)
        return mOutputDateString
    }

    /**
     * Returns the maximum of two dates. A null date is treated as being less
     * than any non-null date.
     */
    private fun max(d1: Date?, d2: Date?): Date? {
        if (d1 == null && d2 == null) return null
        if (d1 == null) return d2
        if (d2 == null) return d1
        return if (d1.after(d2)) d1 else d2
    }

    @Throws(ParseException::class)
    fun formatTimeFromTimeString(
        inputTimeFormat: String?, outputTimeFormat: String?, timeString: String?,
    ): String? {
        var timeFormatStr: String? = null
        try {
            val sdf = SimpleDateFormat(inputTimeFormat)
            val dateObj: Date = sdf.parse(timeString)
            timeFormatStr = SimpleDateFormat(outputTimeFormat).format(dateObj)

        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return timeFormatStr
    }


    @Throws(ParseException::class)
    fun addHrsInTimeString(
        inputTimeFormat: String?, outputTimeFormat: String?, timeString: String?, addHrs: Int,
    ): String? {
        var timeFormatStr: String? = null
        try {
            val sdf = SimpleDateFormat(inputTimeFormat)
            val dateObj: Date = sdf.parse(timeString)

            // Convert Date to Calendar
            val c = Calendar.getInstance()
            c.time = dateObj

            // Perform addition/subtraction
            c.add(Calendar.HOUR, addHrs)

            // Convert calendar back to Date
            val addedHrsDate = c.time
            timeFormatStr = SimpleDateFormat(outputTimeFormat).format(addedHrsDate)

        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return timeFormatStr
    }


    /**
     * Returns the minimum of two dates. A null date is treated as being greater
     * than any non-null date.
     */
    fun min(d1: Date?, d2: Date?): Date? {
        if (d1 == null && d2 == null) return null
        if (d1 == null) return d2
        if (d2 == null) return d1
        return if (d1.before(d2)) d1 else d2
    }
}