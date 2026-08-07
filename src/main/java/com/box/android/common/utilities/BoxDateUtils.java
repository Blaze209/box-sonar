package com.box.android.common.utilities;

import android.content.Context;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public final class BoxDateUtils {
    private static int mDateUtilsFileItemFlags;
    private static int mDateUtilsUpdateItemFlags;

    private BoxDateUtils() {
    }

    private static int getFileItemFlags() {
        if (mDateUtilsFileItemFlags == 0) {
            mDateUtilsFileItemFlags = 524308;
            if (usingNumericMonths(DateFormatSymbols.getInstance().getShortMonths())) {
                mDateUtilsFileItemFlags |= 131072;
            }
        }
        return mDateUtilsFileItemFlags;
    }

    private static int getUpdateItemFlags() {
        if (mDateUtilsUpdateItemFlags == 0) {
            mDateUtilsUpdateItemFlags = 524313;
            if (usingNumericMonths(DateFormatSymbols.getInstance().getShortMonths())) {
                mDateUtilsUpdateItemFlags |= 131072;
            }
        }
        return mDateUtilsUpdateItemFlags;
    }

    public static String getRelativeDateTimeStringInPast(Context context, long j, long j2, long j3, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        if (jCurrentTimeMillis - j < TimeUnit.DAYS.toMillis(1L)) {
            return android.text.format.DateUtils.getRelativeTimeSpanString(j, jCurrentTimeMillis, j2).toString();
        }
        return android.text.format.DateUtils.getRelativeDateTimeString(context, j, j2, j3, i).toString();
    }

    private static boolean usingNumericMonths(String[] strArr) {
        return Character.isDigit(strArr[0].charAt(0));
    }

    public static String formatUpdateItemDateTime(long j, Context context) {
        if (android.text.format.DateUtils.isToday(j)) {
            return android.text.format.DateUtils.formatDateTime(context, j, 524289);
        }
        return android.text.format.DateUtils.formatDateTime(context, j, getUpdateItemFlags());
    }

    public static String formatFileItemTime(long j, Context context) {
        return android.text.format.DateUtils.formatDateTime(context, j, getFileItemFlags());
    }

    public static int getDifferenceInDays(long j, long j2) {
        return (int) (Math.abs(j - j2) / 86400000);
    }

    public static String getFormattedDate(String str, Date date, Context context) {
        return new SimpleDateFormat(str, context.getResources().getConfiguration().getLocales().get(0)).format(date);
    }

    public static String formatDateAndTimeAccordingToLocalConventions(Date date, Context context) {
        return android.text.format.DateUtils.formatDateTime(context, date.getTime(), 65557);
    }

    public static String formatDateAccordingToLocalConventions(Date date, Context context) {
        return android.text.format.DateUtils.formatDateTime(context, date.getTime(), 65556);
    }
}
