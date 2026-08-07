package com.microsoft.identity.common.java.util;

import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public final class DateExtensions {
    private DateExtensions() {
    }

    public static Date createCopy(Date date) {
        return date != null ? new Date(date.getTime()) : date;
    }
}
