package com.microsoft.identity.common.java.util.ported;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public final class DateUtilities {
    public static final Object LOCALE_CHANGE_LOCK = new Object();
    private static final String LOCALE_PREFIX_ARABIC = "ar";
    private static final String LOCALE_PREFIX_ASSAMESE = "as";
    private static final String LOCALE_PREFIX_BENGALI = "bn";
    private static final String LOCALE_PREFIX_ALGERIAN = "dz";
    private static final String LOCALE_PREFIX_PERSIAN = "fa";
    private static final String LOCALE_PREFIX_KASHMIRI = "ks";
    private static final String LOCALE_PREFIX_MARATHI = "mr";
    private static final String LOCALE_PREFIX_BURMESE = "my";
    private static final String LOCALE_PREFIX_NEPALI = "ne";
    private static final String LOCALE_PREFIX_PUNJABI = "pa";
    private static final String LOCALE_PREFIX_PASHTO = "ps";
    private static final String LOCALE_PREFIX_URDU = "ur";
    private static final String LOCALE_PREFIX_UZBEK = "uz";
    private static final Set<String> NON_GREGORIAN_CALENDAR_LOCALES = new HashSet(Arrays.asList(LOCALE_PREFIX_ARABIC, LOCALE_PREFIX_ASSAMESE, LOCALE_PREFIX_BENGALI, LOCALE_PREFIX_ALGERIAN, LOCALE_PREFIX_PERSIAN, LOCALE_PREFIX_KASHMIRI, LOCALE_PREFIX_MARATHI, LOCALE_PREFIX_BURMESE, LOCALE_PREFIX_NEPALI, LOCALE_PREFIX_PUNJABI, LOCALE_PREFIX_PASHTO, LOCALE_PREFIX_URDU, LOCALE_PREFIX_UZBEK));

    private DateUtilities() {
    }

    public static Date createCopy(Date date) {
        return date != null ? new Date(date.getTime()) : date;
    }

    public static long getExpiresOn(long j) {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + j;
    }

    public static boolean isLocaleCalendarNonGregorian(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("inputLocale is marked non-null but is null");
        }
        return NON_GREGORIAN_CALENDAR_LOCALES.contains(locale.getLanguage());
    }
}
