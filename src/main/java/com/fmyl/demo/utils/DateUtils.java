package com.fmyl.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by fuzq on 17/7/5.
 */
public class DateUtils {

    public static String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";


    public static String formatDate2String(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 修改时间
     *
     * @param date   时间
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   小时
     * @param minute 分
     * @return
     */
    public static Date setDate(Date date, int year, int month, int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (year != 0)
            calendar.add(Calendar.YEAR, year);
        if (month != 0)
            calendar.add(Calendar.MONTH, month);
        if (day != 0)
            calendar.add(Calendar.DATE, day);
        if (hour != 0)
            calendar.add(Calendar.HOUR_OF_DAY, hour);
        if (minute != 0)
            calendar.add(Calendar.MINUTE, minute);
        if (second != 0)
            calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    public static Date setDateByMinute(Date date, int minute) {
        return setDate(date, 0, 0, 0, 0, minute, 0);
    }

    /**
     * 时间间隔
     *
     * @param date  开始时间
     * @param date2 结束时间
     * @return
     */
    public static String between(Long date, Long date2) {
        long time = date2 - date;
        int hour = 60 * 60 * 1000;
        int minute = 60 * 1000;
        int second = 1000;
        String str = "";
        if (time / hour > 0)
            str += time / hour + "h ";
        if (time / minute > 0)
            str += time / minute + "m ";
        if (time / second > 0)
            str += time / second + "s ";
        if (time % second > 0)
            str += time % second + "ms";
        return str;
    }


    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(between(date.getTime(), setDateByMinute(date, 3).getTime()));
    }
}
