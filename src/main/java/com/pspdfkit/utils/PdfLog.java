package com.pspdfkit.utils;

import android.util.Log;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.pc;
import com.pspdfkit.internal.uw;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class PdfLog {
    private static final String DEFAULT_LOG_TAG = "Nutrient";
    private static final go<Logger> loggers = new go<>();

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogPriority {
    }

    public interface Logger {
        default boolean isLogged(int i, String str) {
            return true;
        }

        void log(int i, String str, String str2, Throwable th);
    }

    static {
        setLoggers(new pc());
    }

    public static void addLogger(Logger logger) {
        uw.a(logger, "logger", null);
        loggers.a(logger);
    }

    public static void d(String str, Callable<String> callable) throws Exception {
        log(3, str, null, callable);
    }

    public static void e(String str, Callable<String> callable) throws Exception {
        log(6, str, null, callable);
    }

    public static List<Logger> getLoggers() {
        return loggers.a;
    }

    public static void i(String str, Callable<String> callable) throws Exception {
        log(4, str, null, callable);
    }

    private static void log(int i, String str, Throwable th, String str2, Object... objArr) {
        String stackTraceString = null;
        uw.a(objArr, "args", null);
        if (str == null) {
            str = DEFAULT_LOG_TAG;
        }
        if (str2 != null && str2.isEmpty()) {
            str2 = null;
        }
        if (str2 == null && th == null) {
            return;
        }
        for (Logger logger : loggers) {
            if (logger.isLogged(i, str)) {
                if (stackTraceString == null) {
                    if (str2 != null) {
                        stackTraceString = objArr.length > 0 ? String.format(Locale.getDefault(), str2, objArr) : str2;
                        if (th != null) {
                            stackTraceString = stackTraceString + "\n" + Log.getStackTraceString(th);
                        }
                    } else {
                        stackTraceString = Log.getStackTraceString(th);
                    }
                }
                logger.log(i, str, stackTraceString, th);
            }
        }
    }

    public static void removeAllLoggers() {
        loggers.clear();
    }

    public static void removeLogger(Logger logger) {
        uw.a(logger, "logger", null);
        loggers.b(logger);
    }

    public static void setLoggers(Collection<? extends Logger> collection) {
        uw.a(collection, "loggers", null);
        go<Logger> goVar = loggers;
        goVar.clear();
        synchronized (goVar.a) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                goVar.a((Logger) it.next());
            }
        }
    }

    public static void v(String str, Callable<String> callable) throws Exception {
        log(2, str, null, callable);
    }

    public static void w(String str, Callable<String> callable) throws Exception {
        log(5, str, null, callable);
    }

    public static void d(String str, String str2, Object... objArr) {
        log(3, str, null, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        log(6, str, null, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        log(4, str, null, str2, objArr);
    }

    public static void v(String str, String str2, Object... objArr) {
        log(2, str, null, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        log(5, str, null, str2, objArr);
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        log(3, str, th, str2, objArr);
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        log(6, str, th, str2, objArr);
    }

    public static void i(String str, Throwable th, String str2, Object... objArr) {
        log(4, str, th, str2, objArr);
    }

    public static void v(String str, Throwable th, String str2, Object... objArr) {
        log(2, str, th, str2, objArr);
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        log(5, str, th, str2, objArr);
    }

    public static void setLoggers(Logger... loggerArr) {
        uw.a(loggerArr, "loggers", null);
        setLoggers(Arrays.asList(loggerArr));
    }

    private static void log(int i, String str, Throwable th, Callable<String> callable) throws Exception {
        String stackTraceString = null;
        uw.a(callable, "messageCallback", null);
        if (str == null) {
            str = DEFAULT_LOG_TAG;
        }
        for (Logger logger : loggers) {
            if (logger.isLogged(i, str)) {
                if (stackTraceString == null) {
                    try {
                        stackTraceString = callable.call();
                    } catch (Exception unused) {
                    }
                    if (stackTraceString == null && th == null) {
                        return;
                    }
                    if (stackTraceString == null) {
                        stackTraceString = Log.getStackTraceString(th);
                    } else if (th != null) {
                        stackTraceString = stackTraceString + "\n" + Log.getStackTraceString(th);
                    }
                }
                logger.log(i, str, stackTraceString, th);
            }
        }
    }
}
