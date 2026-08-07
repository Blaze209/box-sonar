package com.microsoft.intune.mam.log;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class ExceptionUtils {
    public static String describeException(Throwable th) {
        StringBuilder sb = new StringBuilder();
        describeException(th, sb);
        return sb.toString();
    }

    private static void describeException(Throwable th, StringBuilder sb) {
        sb.append(th.getMessage());
        sb.append('\n');
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        sb.append(stringWriter.toString());
    }

    private ExceptionUtils() {
    }
}
