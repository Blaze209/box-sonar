package org.tinylog.policies;

import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractDatePolicy implements Policy {
    private static final int GROUP_HOUR = 1;
    private static final int GROUP_MINUTE = 3;
    private static final int GROUP_ZONE = 5;
    private static final Pattern TIME_PATTERN = Pattern.compile("^([01]?[0-9]|2[0-3])([^\\d]+([0-5]?[0-9]))?(@(.+))?$");
    private final Calendar calendar;

    protected abstract void scrollAhead(Calendar calendar);

    protected abstract void scrollBack(Calendar calendar);

    protected abstract void truncate(Calendar calendar, int i, int i2);

    protected AbstractDatePolicy(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            Calendar calendar = Calendar.getInstance();
            this.calendar = calendar;
            truncate(calendar, 0, 0);
        } else {
            Matcher matcher = TIME_PATTERN.matcher(str2);
            if (matcher.matches()) {
                String strGroup = matcher.group(1);
                String strGroup2 = matcher.group(3);
                String strGroup3 = matcher.group(5);
                TimeZone timeZone = strGroup3 == null ? null : TimeZone.getTimeZone(strGroup3);
                if (timeZone == null) {
                    this.calendar = Calendar.getInstance();
                } else {
                    if (!timeZone.getID().equals(strGroup3)) {
                        throw new IllegalArgumentException("Invalid time zone \"" + strGroup3 + "\" for " + str);
                    }
                    this.calendar = Calendar.getInstance(timeZone);
                }
                truncate(this.calendar, Integer.parseInt(strGroup), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
            } else {
                throw new IllegalArgumentException("Invalid time for " + str + ": " + str2);
            }
        }
        reset();
    }

    @Override // org.tinylog.policies.Policy
    public final boolean continueExistingFile(String str) {
        Calendar calendar = (Calendar) this.calendar.clone();
        scrollBack(calendar);
        return calendar.getTimeInMillis() <= new File(str).lastModified();
    }

    @Override // org.tinylog.policies.Policy
    public final boolean continueCurrentFile(byte[] bArr) {
        return this.calendar.getTimeInMillis() > System.currentTimeMillis();
    }

    @Override // org.tinylog.policies.Policy
    public final void reset() {
        while (this.calendar.getTimeInMillis() <= System.currentTimeMillis()) {
            scrollAhead(this.calendar);
        }
    }
}
