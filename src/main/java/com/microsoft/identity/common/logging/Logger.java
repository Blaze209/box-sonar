package com.microsoft.identity.common.logging;

import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes14.dex */
public class Logger {
    private static final String ANDROID_EXTERNAL_LOGGER_IDENTIFIER = "ANDROID_EXTERNAL_LOGGER";
    private static final String ANDROID_LOGCAT_LOGGER_IDENTIFIER = "ANDROID_LOGCAT_LOGGER";
    private static final Logger INSTANCE = new Logger();
    private static boolean sAllowLogcat = false;

    static {
        setAndroidLogger();
    }

    public enum LogLevel {
        NO_LOG,
        ERROR,
        WARN,
        INFO,
        VERBOSE;

        /* JADX INFO: Access modifiers changed from: private */
        public com.microsoft.identity.common.java.logging.Logger.LogLevel convertToJavaLogLevel() {
            int i = AnonymousClass3.$SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel[ordinal()];
            if (i == 1) {
                return com.microsoft.identity.common.java.logging.Logger.LogLevel.INFO;
            }
            if (i == 2) {
                return com.microsoft.identity.common.java.logging.Logger.LogLevel.WARN;
            }
            if (i == 3) {
                return com.microsoft.identity.common.java.logging.Logger.LogLevel.ERROR;
            }
            if (i == 4) {
                return com.microsoft.identity.common.java.logging.Logger.LogLevel.NO_LOG;
            }
            return com.microsoft.identity.common.java.logging.Logger.LogLevel.VERBOSE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static LogLevel convertFromJavaLogLevel(com.microsoft.identity.common.java.logging.Logger.LogLevel logLevel) {
            int i = AnonymousClass3.$SwitchMap$com$microsoft$identity$common$java$logging$Logger$LogLevel[logLevel.ordinal()];
            if (i == 1) {
                return INFO;
            }
            if (i == 2) {
                return WARN;
            }
            if (i == 3) {
                return ERROR;
            }
            if (i == 4) {
                return NO_LOG;
            }
            return VERBOSE;
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.logging.Logger$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$java$logging$Logger$LogLevel;
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel;

        static {
            int[] iArr = new int[com.microsoft.identity.common.java.logging.Logger.LogLevel.values().length];
            $SwitchMap$com$microsoft$identity$common$java$logging$Logger$LogLevel = iArr;
            try {
                iArr[com.microsoft.identity.common.java.logging.Logger.LogLevel.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$logging$Logger$LogLevel[com.microsoft.identity.common.java.logging.Logger.LogLevel.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$logging$Logger$LogLevel[com.microsoft.identity.common.java.logging.Logger.LogLevel.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$logging$Logger$LogLevel[com.microsoft.identity.common.java.logging.Logger.LogLevel.NO_LOG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$logging$Logger$LogLevel[com.microsoft.identity.common.java.logging.Logger.LogLevel.VERBOSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[LogLevel.values().length];
            $SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel = iArr2;
            try {
                iArr2[LogLevel.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel[LogLevel.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel[LogLevel.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel[LogLevel.NO_LOG.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static void setAndroidLogger() {
        com.microsoft.identity.common.java.logging.Logger.setLogger(ANDROID_LOGCAT_LOGGER_IDENTIFIER, new com.microsoft.identity.common.java.logging.ILoggerCallback() { // from class: com.microsoft.identity.common.logging.Logger.1
            @Override // com.microsoft.identity.common.java.logging.ILoggerCallback
            public void log(String str, com.microsoft.identity.common.java.logging.Logger.LogLevel logLevel, String str2, boolean z) {
                if (Logger.sAllowLogcat) {
                    int i = AnonymousClass3.$SwitchMap$com$microsoft$identity$common$java$logging$Logger$LogLevel[logLevel.ordinal()];
                    if (i == 1) {
                        Log.i(str, str2);
                        return;
                    }
                    if (i == 2) {
                        Log.w(str, str2);
                    } else if (i == 3) {
                        Log.e(str, str2);
                    } else {
                        if (i != 5) {
                            return;
                        }
                        Log.v(str, str2);
                    }
                }
            }
        });
        com.microsoft.identity.common.java.logging.Logger.setPlatformString("Android " + Build.VERSION.SDK_INT);
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    public static void setAllowPii(boolean z) {
        com.microsoft.identity.common.java.logging.Logger.setAllowPii(z);
    }

    public static void setAllowLogcat(boolean z) {
        sAllowLogcat = z;
    }

    public static boolean getAllowPii() {
        return com.microsoft.identity.common.java.logging.Logger.isAllowPii();
    }

    public static boolean getAllowLogcat() {
        return sAllowLogcat;
    }

    public void setLogLevel(LogLevel logLevel) {
        com.microsoft.identity.common.java.logging.Logger.setLogLevel(logLevel.convertToJavaLogLevel());
    }

    public void setExternalLogger(final ILoggerCallback iLoggerCallback) {
        com.microsoft.identity.common.java.logging.Logger.setLogger(ANDROID_EXTERNAL_LOGGER_IDENTIFIER, new com.microsoft.identity.common.java.logging.ILoggerCallback() { // from class: com.microsoft.identity.common.logging.Logger.2
            @Override // com.microsoft.identity.common.java.logging.ILoggerCallback
            public void log(String str, com.microsoft.identity.common.java.logging.Logger.LogLevel logLevel, String str2, boolean z) {
                iLoggerCallback.log(str, LogLevel.convertFromJavaLogLevel(logLevel), str2, z);
            }
        });
    }

    public static String getDiagnosticContextMetadata() {
        return com.microsoft.identity.common.java.logging.Logger.getDiagnosticContextMetadata();
    }

    public static void error(String str, String str2, Throwable th) {
        com.microsoft.identity.common.java.logging.Logger.error(str, str2, th);
    }

    public static void error(String str, String str2, String str3, Throwable th) {
        com.microsoft.identity.common.java.logging.Logger.error(str, str2, str3, th);
    }

    public static void errorPII(String str, String str2, Throwable th) {
        com.microsoft.identity.common.java.logging.Logger.errorPII(str, str2, th);
    }

    public static void errorPII(String str, String str2, String str3, Throwable th) {
        com.microsoft.identity.common.java.logging.Logger.errorPII(str, str2, str3, th);
    }

    public static void warn(String str, String str2) {
        com.microsoft.identity.common.java.logging.Logger.warn(str, str2);
    }

    public static void warn(String str, String str2, String str3) {
        com.microsoft.identity.common.java.logging.Logger.warn(str, str2, str3);
    }

    public static void warnPII(String str, String str2) {
        com.microsoft.identity.common.java.logging.Logger.warnPII(str, str2);
    }

    public static void warnPII(String str, String str2, String str3) {
        com.microsoft.identity.common.java.logging.Logger.warnPII(str, str2, str3);
    }

    public static void info(String str, String str2) {
        com.microsoft.identity.common.java.logging.Logger.info(str, str2);
    }

    public static void info(String str, String str2, String str3) {
        com.microsoft.identity.common.java.logging.Logger.info(str, str2, str3);
    }

    public static void infoPII(String str, String str2) {
        com.microsoft.identity.common.java.logging.Logger.infoPII(str, str2);
    }

    public static void infoPII(String str, String str2, String str3) {
        com.microsoft.identity.common.java.logging.Logger.infoPII(str, str2, str3);
    }

    public static void verbose(String str, String str2) {
        com.microsoft.identity.common.java.logging.Logger.verbose(str, str2);
    }

    public static void verbose(String str, String str2, String str3) {
        com.microsoft.identity.common.java.logging.Logger.verbose(str, str2, str3);
    }

    public static void verbosePII(String str, String str2) {
        com.microsoft.identity.common.java.logging.Logger.verbosePII(str, str2);
    }

    public static void verbosePII(String str, String str2, String str3) {
        com.microsoft.identity.common.java.logging.Logger.verbosePII(str, str2, str3);
    }
}
