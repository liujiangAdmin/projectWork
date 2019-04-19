package com.ucmed.hnust.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class KunshanSecondDateUtil {

    private static final Logger LOGGER = Logger.getLogger(KunshanSecondDateUtil.class);

    private static final SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy/MM/dd");
    private static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
            "yyyyMMdd");
    private static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat(
            "yyyy-MM-dd");
    private static final SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat(
            "yyyyMMddHHmm");
    private static final SimpleDateFormat sdf4 = new SimpleDateFormat(
            "yyyyMMdd");
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm");

    private static final SimpleDateFormat sdf2 = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("HHmm");

    private static final SimpleDateFormat yyyyMMddhhmmssSSS = new SimpleDateFormat(
            "yyyyMMddhhmmssSSS");

    public String simpleDate(Date date) {
        if (date == null)
            return "";
        return sdf.format(date);
    }

    public static String simpleDate1(String date1) {
        if (date1 == null)
            return "";
        return sdf.format(date1);
    }

    public static String simpleDate2(Date date) {
        if (yyyyMMddhhmmssSSS == null)
            return "";
        return yyyyMMddhhmmssSSS.format(date);

    }

    public static String formatDate1(Date date) {
        if (date == null)
            return "";
        return yyyy_MM_dd.format(date);
    }

    public static Date parseDate2(String date) {
        try {
            return sdf4.parse(date);
        } catch (ParseException e) {
            LOGGER.info(e);
        }
        return new Date();
    }

    public static String stringDate10(String date) {
        return KunshanSecondDateUtil.formatDate1(parseDate2(date));
    }

    /**
     * 取当前时间
     * 
     * @return
     */
    public static String getCurrentTime() {

        Calendar calendar = Calendar.getInstance();

        int i = calendar.get(1);
        int j = calendar.get(2) + 1;
        int k = calendar.get(5);
        return Integer.toString(i) + (j >= 10 ? Integer.toString(j) : "0" + j)
                + (k >= 10 ? Integer.toString(k) : "0" + k);
    }

    public static Date calculateDate(Date startDay, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDay);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return cal.getTime();
    }

    public static Date calculateMonth(Date startDay, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDay);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    /**
     * String 获取当前时间yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String getCurrentDateTime() {
        return dateToString4(getCurrentDate());
    }

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * String 获取今天日期yyyyMMdd
     * 
     * @return
     */
    public static String getToday() {
        Calendar calendar = Calendar.getInstance();
        return KunshanSecondDateUtil.getyyyyMMdd(calendar.getTime());
    }

    /**
     * String 获取明天日期yyyyMMdd
     * 
     * @return
     */
    public static String getTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return KunshanSecondDateUtil.getyyyyMMdd(calendar.getTime());
    }

    /**
     * String 获取几天后日期yyyyMMdd
     * 
     * @return
     */
    public static String getDateByDays(Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return KunshanSecondDateUtil.getyyyyMMdd(calendar.getTime());
    }

    /**
     * String 获取几天后日期yyyy-MM-dd
     * 
     * @return
     */
    public static String getDateByDays2(Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return KunshanSecondDateUtil.getyyyy_MM_dd(calendar.getTime());
    }

    /**
     * 获取几天(days)前的时间
     * 
     * @param days
     * @return
     */
    public static Date getDateByBeforeDays(Integer days) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, days);
        return c.getTime();
    }

    public static String getyyyyMMdd(Date date) {
        if (date == null)
            return "";
        return yyyyMMdd.format(date);
    }

    public static String getyyyy_MM_dd(Date date) {
        if (date == null)
            return "";
        return yyyy_MM_dd.format(date);
    }

    public static Date StringToDate(String date) {
        try {
            return yyyyMMdd.parse(date);
        } catch (ParseException e) {
        }
        return new Date();
    }

    /**
     * String 获取时间 yyyy-MM-dd HH:mm
     * 
     * @param date
     * @return
     */
    public static String format1(Date date) {
        if (date == null)
            date = new Date();
        return sdf1.format(date);
    }

    public static String dateToString1(Date date) {
        try {
            return sdf1.format(date);
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

    /**
     * Date 获取时间 yyyy-MM-dd HH:mm
     * 
     * @param String
     * @return Date
     */
    public static Date StringToDate1(String date) {
        try {
            return sdf1.parse(date);
        } catch (ParseException e) {
            LOGGER.info(e);
        }
        return new Date();
    }

    /**
     * Date 获取时间 yyyy/MM/dd
     * 
     * @param String
     * @return Date
     */
    public static Date StringToDate5(String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            LOGGER.info(e);
        }
        return new Date();
    }

    /**
     * Date 获取时间yyyyMMddHHmm
     * 
     * @param String
     *            yyyyMMddHHmm
     * @return Date
     */
    public static Date StringToDate2(String date) {
        try {
            return yyyyMMddHHmm.parse(date);
        } catch (ParseException e) {
            LOGGER.info(e);

        }
        return new Date();
    }

    /**
     * Date 获取时间yyyyMMdd
     * 
     * @param String
     *            yyyyMMdd
     * @return Date
     */
    public static Date StringToDate3(String date) {
        try {
            return yyyyMMdd.parse(date);
        } catch (ParseException e) {
            LOGGER.info(e);
        }
        return new Date();
    }

    public static Date StringToDate4(String date) {
        try {
            return sdf2.parse(date);
        } catch (ParseException e) {
            LOGGER.info(e);
        }
        return new Date();
    }

    public static String dateToString4(Date date) {
        try {
            return sdf2.format(date);
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

    public static String getHHmm(Date date) {
        try {
            return sdf3.format(date);
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return null;
    }

    public static Integer getWeekId(String date) {
        Date d = new Date();
        try {
            d = yyyyMMdd.parse(date);
        } catch (ParseException e) {
            LOGGER.info(e);

        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 获取周几
     * 
     * @param date
     *            yyyyMMdd
     * @return
     */
    public static String getWeek(String date) {
        String week = "";
        switch (getWeekId(date)) {
        case 1:
            week = "星期一";
            break;
        case 2:
            week = "星期二";
            break;
        case 3:
            week = "星期三";
            break;
        case 4:
            week = "星期四";
            break;
        case 5:
            week = "星期五";
            break;
        case 6:
            week = "星期六";
            break;
        case 0:
            week = "星期日";
            break;

        default:
            break;
        }
        return week;
    }

    /**
     * 时间计算（日）
     * 
     * @param date
     * @param n
     * @return
     */
    public static Date getDate(Date date, int n) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(Calendar.DAY_OF_MONTH, n);
        return gc.getTime();
    }

    public static Date getDate(Date date, int field, int n) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(field, n);
        return gc.getTime();
    }

    public static Date weekToDate(Number n) {
        Integer w = n.intValue();
        Calendar calendar = Calendar.getInstance();
        Integer t = calendar.get(Calendar.DAY_OF_WEEK);
        t = t - 1 == 0 ? 7 : t - 1;
        Integer i = w - t < 0 ? w - t + 7 : w - t;
        calendar.add(Calendar.DAY_OF_MONTH, i);
        return calendar.getTime();
    }

    public static boolean isEqual(Date one, Date another) {
        if (one == null || another == null)
            return false;
        return yyyyMMdd.format(one).equals(yyyyMMdd.format(another));
    }

    // 当前时间是上午还是下午（0：上午；1：下午）
    public static int AM_PM() {
        GregorianCalendar ca = new GregorianCalendar();
        return ca.get(GregorianCalendar.AM_PM);
    }
}
