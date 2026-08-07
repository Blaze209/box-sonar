package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeLoggingLevel;
import com.pspdfkit.internal.jni.NativePlatformLogger;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public final class ac extends NativePlatformLogger {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NativeLoggingLevel.values().length];
            a = iArr;
            try {
                iArr[NativeLoggingLevel.CRITICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NativeLoggingLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NativeLoggingLevel.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NativeLoggingLevel.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[NativeLoggingLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[NativeLoggingLevel.TRACE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.pspdfkit.internal.jni.NativePlatformLogger
    public final void log(NativeLoggingLevel nativeLoggingLevel, String str, String str2) {
        if (str == null) {
            str = "Nutri.CoreLogHandler";
        }
        switch (a.a[nativeLoggingLevel.ordinal()]) {
            case 1:
            case 2:
                PdfLog.e(str, str2, new Object[0]);
                break;
            case 3:
                PdfLog.w(str, str2, new Object[0]);
                break;
            case 4:
                PdfLog.i(str, str2, new Object[0]);
                break;
            case 5:
                PdfLog.d(str, str2, new Object[0]);
                break;
            case 6:
                PdfLog.v(str, str2, new Object[0]);
                break;
        }
    }
}
