package com.vn.ShopService.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    Calendar calendar;

    public DateUtils(Date date) {
        this.calendar = Calendar.getInstance();
        this.calendar.setTime(date);
    }

    public static DateUtils of(Date date) {
        return new DateUtils(date);
    }

    public static DateUtils of(Long time) {
        return new DateUtils(new Date(time));
    }

    public DateUtils addDate(int amount) {
        this.calendar.add(Calendar.DAY_OF_WEEK, amount);
        return this;
    }

    public DateUtils addMinutes(int amount) {
        this.calendar.add(Calendar.MINUTE, amount);
        return this;
    }

    public DateUtils truncDate() {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return this;
    }

    public static Date addDay(Date date, int days) {
        Calendar c = Calendar.getInstance();
        if (date != null) {
            c.setTime(date);
            c.add(c.DAY_OF_MONTH, days);
        }
        return c.getTime();
    }

    public static Date addMonth(Date date, int months) {
        Calendar c = Calendar.getInstance();
        if (date != null) {
            c.setTime(date);
            c.add(c.MONTH, months);
        }
        return c.getTime();
    }

    public String format(String format) {
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    public Date toDate() {
        return this.calendar.getTime();
    }

    public static Date getFromDate(Date date) {
        if (date == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 1);
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            return calendar.getTime();
        } else {
            return date;
        }
    }

    public static Date getToDate(Date date) {
        if (date == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 9999);
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.DAY_OF_MONTH, 31);
            return calendar.getTime();
        } else {
            return date;
        }
    }
}
