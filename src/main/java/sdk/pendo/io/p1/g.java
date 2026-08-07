package sdk.pendo.io.p1;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    public static TimeZone d;
    static TreeMap<String, Integer> a = new TreeMap<>(new a());
    static TreeMap<String, Integer> b = new TreeMap<>(new a());
    private static HashSet<String> c = new HashSet<>();
    static TreeMap<String, TimeZone> e = new TreeMap<>();

    public static class a implements Comparator<String> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    static {
        c.add("à");
        c.add("at");
        c.add("MEZ");
        c.add("Uhr");
        c.add(CmcdData.STREAMING_FORMAT_HLS);
        c.add("pm");
        c.add("PM");
        c.add("am");
        c.add("AM");
        c.add("min");
        c.add("um");
        c.add("o'clock");
        for (String str : TimeZone.getAvailableIDs()) {
            e.put(str, TimeZone.getTimeZone(str));
        }
        for (Locale locale : DateFormatSymbols.getAvailableLocales()) {
            if (!"ja".equals(locale.getLanguage()) && !"ko".equals(locale.getLanguage()) && !"zh".equals(locale.getLanguage())) {
                DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
                String[] months = dateFormatSymbols.getMonths();
                for (int i = 0; i < months.length; i++) {
                    if (months[i].length() != 0) {
                        a(a, months[i], Integer.valueOf(i));
                    }
                }
                String[] shortMonths = dateFormatSymbols.getShortMonths();
                for (int i2 = 0; i2 < shortMonths.length; i2++) {
                    String str2 = shortMonths[i2];
                    if (str2.length() != 0 && !Character.isDigit(str2.charAt(str2.length() - 1))) {
                        a(a, shortMonths[i2], Integer.valueOf(i2));
                        a(a, shortMonths[i2].replace(".", ""), Integer.valueOf(i2));
                    }
                }
                String[] weekdays = dateFormatSymbols.getWeekdays();
                for (int i3 = 0; i3 < weekdays.length; i3++) {
                    String str3 = weekdays[i3];
                    if (str3.length() != 0) {
                        a(b, str3, Integer.valueOf(i3));
                        a(b, str3.replace(".", ""), Integer.valueOf(i3));
                    }
                }
                String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
                for (int i4 = 0; i4 < shortWeekdays.length; i4++) {
                    String str4 = shortWeekdays[i4];
                    if (str4.length() != 0) {
                        a(b, str4, Integer.valueOf(i4));
                        a(b, str4.replace(".", ""), Integer.valueOf(i4));
                    }
                }
            }
        }
    }

    private static Date a(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        if (str == null) {
            if (!stringTokenizer.hasMoreTokens()) {
                return calendar.getTime();
            }
            str = stringTokenizer.nextToken();
        }
        return b(stringTokenizer, calendar, str);
    }

    private static Date b(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        String strA;
        String strA2;
        String strA3;
        calendar.set(11, Integer.parseInt(a(stringTokenizer, str, calendar)));
        if (stringTokenizer.hasMoreTokens() && (strA = a(stringTokenizer, stringTokenizer.nextToken(), calendar)) != null) {
            calendar.set(12, Integer.parseInt(strA));
            if (stringTokenizer.hasMoreTokens() && (strA2 = a(stringTokenizer, stringTokenizer.nextToken(), calendar)) != null) {
                calendar.set(13, Integer.parseInt(strA2));
                if (stringTokenizer.hasMoreTokens() && (strA3 = a(stringTokenizer, stringTokenizer.nextToken(), calendar)) != null) {
                    String strA4 = a(stringTokenizer, strA3, calendar);
                    if (strA4.length() == 4 && Character.isDigit(strA4.charAt(0))) {
                        calendar.set(1, a(strA4));
                    }
                    return calendar.getTime();
                }
                return calendar.getTime();
            }
            return calendar.getTime();
        }
        return calendar.getTime();
    }

    private static Date c(StringTokenizer stringTokenizer, String str) {
        String strSubstring;
        GregorianCalendar gregorianCalendarA = a();
        gregorianCalendarA.set(1, Integer.parseInt(str));
        if (!stringTokenizer.hasMoreTokens()) {
            return gregorianCalendarA.getTime();
        }
        gregorianCalendarA.set(2, b(stringTokenizer.nextToken()).intValue());
        if (!stringTokenizer.hasMoreTokens()) {
            return gregorianCalendarA.getTime();
        }
        String strNextToken = stringTokenizer.nextToken();
        if (!Character.isDigit(strNextToken.charAt(0))) {
            return gregorianCalendarA.getTime();
        }
        if (strNextToken.length() == 5 && strNextToken.charAt(2) == 'T') {
            gregorianCalendarA.set(5, Integer.parseInt(strNextToken.substring(0, 2)));
            strSubstring = strNextToken.substring(3);
        } else {
            gregorianCalendarA.set(5, Integer.parseInt(strNextToken));
            strSubstring = null;
        }
        return a(stringTokenizer, gregorianCalendarA, strSubstring);
    }

    public static Date a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (!(obj instanceof String)) {
            throw new RuntimeException("Primitive: Can not convert " + obj.getClass().getName() + " to int");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(((String) obj).replace("p.m.", "pm").replace("a.m.", "am"), " -/:,.+年月日曜時分秒");
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        String strNextToken = stringTokenizer.nextToken();
        if (strNextToken.length() == 4 && Character.isDigit(strNextToken.charAt(0))) {
            return c(stringTokenizer, strNextToken);
        }
        if (b.containsKey(strNextToken)) {
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            strNextToken = stringTokenizer.nextToken();
        }
        if (a.containsKey(strNextToken)) {
            return b(stringTokenizer, strNextToken);
        }
        if (Character.isDigit(strNextToken.charAt(0))) {
            return a(stringTokenizer, strNextToken);
        }
        return null;
    }

    private static Date b(StringTokenizer stringTokenizer, String str) {
        GregorianCalendar gregorianCalendarA = a();
        Integer num = a.get(str);
        if (num == null) {
            throw new NullPointerException("can not parse " + str + " as month");
        }
        gregorianCalendarA.set(2, num.intValue());
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        gregorianCalendarA.set(5, Integer.parseInt(stringTokenizer.nextToken()));
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        String strNextToken = stringTokenizer.nextToken();
        if (Character.isLetter(strNextToken.charAt(0))) {
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            strNextToken = stringTokenizer.nextToken();
        }
        if (strNextToken.length() == 4) {
            gregorianCalendarA.set(1, a(strNextToken));
        } else if (strNextToken.length() == 2) {
            return b(stringTokenizer, gregorianCalendarA, strNextToken);
        }
        return a(stringTokenizer, gregorianCalendarA, (String) null);
    }

    private static void a(TreeMap<String, Integer> treeMap, String str, Integer num) {
        treeMap.put(str, num);
        treeMap.put(str.replace("é", "e").replace("û", "u"), num);
    }

    private static Integer b(String str) {
        int iIntValue;
        if (Character.isDigit(str.charAt(0))) {
            iIntValue = Integer.parseInt(str) - 1;
        } else {
            Integer num = a.get(str);
            if (num == null) {
                throw new NullPointerException("can not parse " + str + " as month");
            }
            iIntValue = num.intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    private static Date a(StringTokenizer stringTokenizer, String str) {
        GregorianCalendar gregorianCalendarA = a();
        gregorianCalendarA.set(5, Integer.parseInt(str));
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        gregorianCalendarA.set(2, b(stringTokenizer.nextToken()).intValue());
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        gregorianCalendarA.set(1, a(stringTokenizer.nextToken()));
        return a(stringTokenizer, gregorianCalendarA, (String) null);
    }

    private static int a(String str) {
        int i = Integer.parseInt(str);
        if (i < 100) {
            return i > 30 ? i + 2000 : i + 1900;
        }
        return i;
    }

    private static GregorianCalendar a() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
        TimeZone timeZone = d;
        if (timeZone != null) {
            gregorianCalendar.setTimeZone(timeZone);
        }
        TimeZone timeZone2 = gregorianCalendar.getTimeZone();
        if (timeZone2 == null) {
            timeZone2 = TimeZone.getDefault();
        }
        gregorianCalendar.setTimeInMillis(-timeZone2.getRawOffset());
        return gregorianCalendar;
    }

    private static String a(StringTokenizer stringTokenizer, String str, Calendar calendar) {
        while (true) {
            TimeZone timeZone = e.get(str);
            if (timeZone != null) {
                calendar.setTimeZone(timeZone);
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
            } else {
                if (!c.contains(str)) {
                    return str;
                }
                if (str.equalsIgnoreCase("pm")) {
                    calendar.add(9, 1);
                }
                if (str.equalsIgnoreCase("am")) {
                    calendar.add(9, 0);
                }
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
            }
            str = stringTokenizer.nextToken();
        }
    }
}
