package com.microsoft.identity.common.java.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes14.dex */
public class ThrowableUtil {
    public static synchronized String getStackTraceAsString(Throwable th) {
        StringWriter stringWriter;
        stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
}
