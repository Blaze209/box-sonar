package com.microsoft.identity.common.java.logging;

import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ThrowableUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes14.dex */
public class Logger {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String UNSET = "UNSET";
    private static final SimpleDateFormat sDateTimeFormatter;
    private static final Object $LOCK = new Object[0];
    private static final ExecutorService sLogExecutor = Executors.newSingleThreadExecutor();
    private static LogLevel sLogLevel = LogLevel.VERBOSE;
    private static boolean sAllowPii = false;
    private static String sPlatformString = "";
    private static final ReentrantReadWriteLock sLoggersLock = new ReentrantReadWriteLock();
    private static final Map<String, ILoggerCallback> sLoggers = new HashMap();

    public enum LogLevel {
        NO_LOG,
        ERROR,
        WARN,
        INFO,
        VERBOSE,
        UNDEFINED
    }

    public static void setLogLevel(LogLevel logLevel) {
        sLogLevel = logLevel;
    }

    public static LogLevel getLogLevel() {
        return sLogLevel;
    }

    public static void setAllowPii(boolean z) {
        sAllowPii = z;
    }

    public static boolean isAllowPii() {
        return sAllowPii;
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        sDateTimeFormatter = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static void setPlatformString(String str) {
        synchronized ($LOCK) {
            sPlatformString = str;
        }
    }

    static synchronized void resetLogger() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLoggersLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            sLoggers.clear();
            sAllowPii = false;
            sPlatformString = "";
            sLogLevel = LogLevel.VERBOSE;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sLoggersLock.writeLock().unlock();
            throw th;
        }
    }

    public static boolean setLogger(String str, ILoggerCallback iLoggerCallback) {
        if (str == null) {
            throw new NullPointerException("identifier is marked non-null but is null");
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sLoggersLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (iLoggerCallback == null) {
                sLoggers.remove(str);
            } else {
                Map<String, ILoggerCallback> map = sLoggers;
                if (!map.containsValue(iLoggerCallback)) {
                    map.put(str, iLoggerCallback);
                } else {
                    reentrantReadWriteLock.writeLock().unlock();
                    return false;
                }
            }
            reentrantReadWriteLock.writeLock().unlock();
            return true;
        } catch (Throwable th) {
            sLoggersLock.writeLock().unlock();
            throw th;
        }
    }

    public static synchronized String getDiagnosticContextMetadata() {
        return getDiagnosticContextMetadata(null);
    }

    public static void error(String str, String str2, Throwable th) {
        log(str, LogLevel.ERROR, null, str2, null, th, false);
    }

    public static void error(String str, String str2, String str3, Throwable th) {
        log(str, LogLevel.ERROR, str2, str3, null, th, false);
    }

    public static void errorPII(String str, String str2, Throwable th) {
        log(str, LogLevel.ERROR, null, str2, null, th, true);
    }

    public static void errorPII(String str, String str2, String str3, Throwable th) {
        log(str, LogLevel.ERROR, str2, str3, null, th, true);
    }

    public static void warn(String str, String str2) {
        log(str, LogLevel.WARN, null, str2, null, null, false);
    }

    public static void warn(String str, String str2, String str3) {
        log(str, LogLevel.WARN, str2, str3, null, null, false);
    }

    public static void warnWithObject(String str, String str2, String str3, ILoggable iLoggable) {
        if (isAllowPii()) {
            log(str, LogLevel.WARN, str2, str3, iLoggable.toUnsanitizedString(), null, iLoggable.containsPii());
        } else {
            log(str, LogLevel.WARN, str2, str3, iLoggable.toString(), null, false);
        }
    }

    public static void warnWithObject(String str, String str2, ILoggable iLoggable) {
        if (isAllowPii()) {
            log(str, LogLevel.WARN, null, str2, iLoggable.toUnsanitizedString(), null, iLoggable.containsPii());
        } else {
            log(str, LogLevel.WARN, null, str2, iLoggable.toString(), null, false);
        }
    }

    public static void warnPII(String str, String str2) {
        log(str, LogLevel.WARN, null, str2, null, null, true);
    }

    public static void warnPII(String str, String str2, String str3) {
        log(str, LogLevel.WARN, str2, str3, null, null, true);
    }

    public static void info(String str, String str2) {
        log(str, LogLevel.INFO, null, str2, null, null, false);
    }

    public static void infoWithObject(String str, String str2, ILoggable iLoggable) {
        if (isAllowPii()) {
            log(str, LogLevel.INFO, null, str2, iLoggable.toUnsanitizedString(), null, iLoggable.containsPii());
        } else {
            log(str, LogLevel.INFO, null, str2, iLoggable.toString(), null, false);
        }
    }

    public static void infoWithObject(String str, String str2, String str3, ILoggable iLoggable) {
        if (isAllowPii()) {
            log(str, LogLevel.INFO, str2, str3, iLoggable.toUnsanitizedString(), null, iLoggable.containsPii());
        } else {
            log(str, LogLevel.INFO, str2, str3, iLoggable.toString(), null, false);
        }
    }

    public static void info(String str, String str2, String str3) {
        log(str, LogLevel.INFO, str2, str3, null, null, false);
    }

    public static void infoPII(String str, String str2) {
        log(str, LogLevel.INFO, null, str2, null, null, true);
    }

    public static void infoPII(String str, String str2, String str3) {
        log(str, LogLevel.INFO, str2, str3, null, null, true);
    }

    public static void verbose(String str, String str2) {
        log(str, LogLevel.VERBOSE, null, str2, null, null, false);
    }

    public static void verbose(String str, String str2, String str3) {
        log(str, LogLevel.VERBOSE, str2, str3, null, null, false);
    }

    public static void verbosePII(String str, String str2) {
        log(str, LogLevel.VERBOSE, null, str2, null, null, true);
    }

    public static void verbosePII(String str, String str2, String str3) {
        log(str, LogLevel.VERBOSE, str2, str3, null, null, true);
    }

    private static void log(final String str, final LogLevel logLevel, String str2, final String str3, final String str4, final Throwable th, final boolean z) {
        if (logLevel == null) {
            throw new NullPointerException("logLevel is marked non-null but is null");
        }
        if (sLogLevel == LogLevel.NO_LOG || logLevel.compareTo(sLogLevel) > 0) {
            return;
        }
        if (sAllowPii || !z) {
            final Date date = new Date();
            final String diagnosticContextMetadata = getDiagnosticContextMetadata(str2);
            sLogExecutor.execute(new Runnable() { // from class: com.microsoft.identity.common.java.logging.Logger.1
                @Override // java.lang.Runnable
                public void run() {
                    String message = Logger.formatMessage(diagnosticContextMetadata, Logger.sPlatformString, str3, str4, Logger.sDateTimeFormatter.format(date), th);
                    Logger.sLoggersLock.readLock().lock();
                    try {
                        Iterator it = Logger.sLoggers.keySet().iterator();
                        while (it.hasNext()) {
                            try {
                                ILoggerCallback iLoggerCallback = (ILoggerCallback) Logger.sLoggers.get((String) it.next());
                                if (iLoggerCallback != null) {
                                    iLoggerCallback.log(str, logLevel, message, z);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        Logger.sLoggersLock.readLock().unlock();
                    } catch (Throwable th2) {
                        Logger.sLoggersLock.readLock().unlock();
                        throw th2;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatMessage(String str, String str2, String str3, String str4, String str5, Throwable th) {
        if (str5 == null) {
            throw new NullPointerException("dateTimeStamp is marked non-null but is null");
        }
        if (StringUtil.isNullOrEmpty(str3)) {
            str3 = "";
        }
        if (StringUtil.isNullOrEmpty(str4)) {
            str4 = "";
        }
        return "[" + str5 + (StringUtil.isNullOrEmpty(str) ? " " : " - " + str + " ") + "- " + str2 + "] " + str3 + " " + str4 + " " + (th != null ? "\n" + ThrowableUtil.getStackTraceAsString(th) : "");
    }

    private static String getDiagnosticContextMetadata(String str) {
        IRequestContext requestContext = DiagnosticContext.INSTANCE.getRequestContext();
        String str2 = requestContext.get(DiagnosticContext.THREAD_ID);
        if (StringUtil.isNullOrEmpty(str2)) {
            str2 = "UNSET";
        }
        if (StringUtil.isNullOrEmpty(str)) {
            str = requestContext.get("correlation_id");
            if (StringUtil.isNullOrEmpty(str)) {
                str = "UNSET";
            }
        }
        return String.format("%s: %s, %s: %s", DiagnosticContext.THREAD_ID, str2, "correlation_id", str);
    }
}
