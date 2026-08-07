package com.box.androidsdk.content.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes13.dex */
public final class BoxDateFormat {
    private static final int MILLIS_PER_HOUR = 3600000;
    private static final int MILLIS_PER_MINUTE = 60000;
    private static final FastDateFormat LOCAL_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZ");
    private static ConcurrentHashMap<String, TimeZone> mTimeZones = new ConcurrentHashMap<>(10);

    private BoxDateFormat() {
    }

    public static Date parse(String str) throws ParseException {
        Integer numValueOf = Integer.valueOf(Integer.parseInt(str.substring(0, 4)));
        Integer numValueOf2 = Integer.valueOf(Integer.parseInt(str.substring(5, 7)) - 1);
        Integer numValueOf3 = Integer.valueOf(Integer.parseInt(str.substring(8, 10)));
        Integer numValueOf4 = Integer.valueOf(Integer.parseInt(str.substring(11, 13)));
        Integer numValueOf5 = Integer.valueOf(Integer.parseInt(str.substring(14, 16)));
        Integer numValueOf6 = Integer.valueOf(Integer.parseInt(str.substring(17, 19)));
        Calendar gregorianCalendar = GregorianCalendar.getInstance(getTimeZone(str.substring(19)));
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(numValueOf.intValue(), numValueOf2.intValue(), numValueOf3.intValue(), numValueOf4.intValue(), numValueOf5.intValue(), numValueOf6.intValue());
        return gregorianCalendar.getTime();
    }

    private static TimeZone getTimeZone(String str) {
        int iIntValue;
        TimeZone timeZone = mTimeZones.get(str);
        if (timeZone != null) {
            return timeZone;
        }
        if (str.equals("Z")) {
            TimeZone timeZone2 = TimeZone.getTimeZone("UTC");
            mTimeZones.put(str, timeZone2);
            return timeZone2;
        }
        Integer numValueOf = Integer.valueOf(Integer.parseInt(str.substring(str.charAt(0) == '+' ? 1 : 0, 3)));
        Integer numValueOf2 = Integer.valueOf(Integer.parseInt(str.substring(4)));
        int iIntValue2 = numValueOf.intValue() * 3600000;
        if (numValueOf.intValue() < 0) {
            iIntValue = iIntValue2 - (numValueOf2.intValue() * 60000);
        } else {
            iIntValue = iIntValue2 + (numValueOf2.intValue() * 60000);
        }
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(iIntValue, str);
        mTimeZones.put(str, simpleTimeZone);
        return simpleTimeZone;
    }

    public static String format(Date date) {
        String str = LOCAL_DATE_FORMAT.format(date);
        return str.substring(0, 22) + ":" + str.substring(22);
    }

    public static String getTimeRangeString(Date date, Date date2) {
        if (date == null && date2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (date != null) {
            sb.append(format(date));
        }
        sb.append(",");
        if (date2 != null) {
            sb.append(format(date2));
        }
        return sb.toString();
    }

    public static Date[] getTimeRangeDates(String str) {
        if (SdkUtils.isEmptyString(str)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        Date[] dateArr = new Date[2];
        try {
            dateArr[0] = parse(strArrSplit[0]);
        } catch (ArrayIndexOutOfBoundsException | ParseException unused) {
        }
        try {
            dateArr[1] = parse(strArrSplit[1]);
        } catch (ArrayIndexOutOfBoundsException | ParseException unused2) {
        }
        return dateArr;
    }
}
