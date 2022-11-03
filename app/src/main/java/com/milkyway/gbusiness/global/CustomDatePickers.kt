package com.milkyway.gbusiness.global

import android.app.DatePickerDialog
import android.content.Context
import android.widget.EditText
import java.util.*

class CustomDatePickers (private val context: Context){
    init {
        this.context
    }

    var datePickerDialog: DatePickerDialog? = null

    fun showDatePickerDialog(editTextDate: EditText) {
        //todo date format should be 5-12-2013
        if (datePickerDialog == null || !datePickerDialog!!.isShowing()) {
            val passdate = editTextDate.text.toString()
            var day = 0
            var month = 0
            var year = 0
            try {
                if (passdate != null && !passdate.equals("", ignoreCase = true)) {
                    val split = passdate.split("-".toRegex()).toTypedArray()
                    day = Integer.valueOf(split[0])
                    month = Integer.valueOf(split[1]) - 1
                    year = Integer.valueOf(split[2])
                } else {
                    val c = Calendar.getInstance()
                    year = c[Calendar.YEAR]
                    month = c[Calendar.MONTH]
                    day = c[Calendar.DAY_OF_MONTH]
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year_this, monthOfYear, dayOfMonth ->
                // TODO Auto-generated method stub
                val month = monthOfYear + 1
                var f_month = "" + month
                var f_day = "" + dayOfMonth
                if (month < 10) {
                    f_month = "0$month"
                }
                if (dayOfMonth < 10) {
                    f_day = "0$dayOfMonth"
                }
                val date = "$f_day-$f_month-$year_this"
                editTextDate.setText(date)
                editTextDate.setSelection(editTextDate.text!!.length)
            }
            datePickerDialog = DatePickerDialog(context!!, dateSetListener, year, month, day)
            datePickerDialog?.setCancelable(false)
            datePickerDialog?.show()
        }
    }
}